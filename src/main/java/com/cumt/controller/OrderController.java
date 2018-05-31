package com.cumt.controller;

import com.alibaba.fastjson.JSON;
import com.cumt.pojo.*;
import com.cumt.service.FlightService;
import com.cumt.service.OrderItemService;
import com.cumt.service.OrderService;
import com.cumt.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by Administrator on 2018-05-14.
 */
@Controller
@RequestMapping("")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    FlightService flightService;
    @RequestMapping("createOrder")
    @ResponseBody
    public String createOrder(@RequestBody OrderInfo orderInfo, HttpServletRequest request, HttpServletResponse response) {
        //随机产生订单号
        String orderId = "6";
        int orderState = 1;
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(orderInfo.getOrder().getUserId());
        order.setContactName(orderInfo.getOrder().getContactName());
        order.setOrderState(orderState);
        order.setCellphone(orderInfo.getOrder().getCellphone());
        order.setEmail(orderInfo.getOrder().getEmail());
        order.setOrderDate(orderInfo.getOrder().getOrderDate());
        int id = orderService.addOrder(order);
        if(id!=0){
            List<Passenger> passengers = new ArrayList<Passenger>();
            passengers = orderInfo.getPassengers();
            for (int i = 0; i < passengers.size(); i++) {
                String passengerId = passengers.get(i).getPassengerId();
                String orderItemId = "66";
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderId(orderId);
                orderItem.setOrderItemId(orderItemId);
                orderItem.setPassengerId(passengerId);
                orderItem.setSeatRequire(orderInfo.getOrderItem().getSeatRequire());
                String flightId = orderInfo.getTicket().getFlightId();
                int cabinClassId = orderInfo.getTicket().getCabinClassId();
                orderItemService.addOrderItem(orderItem, flightId, cabinClassId);
                flightService.minusClassCount(flightId, cabinClassId);
            }
        }
        System.out.print(orderInfo);

        Map<String,String> result=new HashMap<String, String>();
        result.put("result", "恭喜您，机票预定成功！");
        return JSON.toJSONString(result);
    }

    @RequestMapping("getOrderDetail")
    @ResponseBody
    public String getOrderDetail(@RequestBody String orderId, HttpServletRequest request, HttpServletResponse response) {
        return JSON.toJSONString("");
    }

    @RequestMapping("getOrdersByUserId")
    @ResponseBody
    public List<OrderInfo>  getOrdersByUserId(@RequestParam(name="userId")String userId, HttpServletRequest request, HttpServletResponse response) {
        List<OrderInfo>  orders = orderService.getOrdersByUserId(userId);
        return orders;
    }

    @RequestMapping("getOrdersBySearch")
    @ResponseBody
    public List<OrderInfo>  getOrdersBySearch(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        List<OrderInfo>  orders = orderService.getOrdersBySearch(user);
        return orders;
    }
    @RequestMapping("getOrders")
    @ResponseBody
    public List<OrderQuery>  getOrders(@RequestBody OrderQuery order, HttpServletRequest request, HttpServletResponse response) {
        List<OrderQuery>  orders = orderService.getOrders(order);
        return orders;
    }
    @RequestMapping("getOrderNumByDate")
    @ResponseBody
    public List<OrderStat> getOrderNumByDate(HttpServletRequest request, HttpServletResponse response) {
        List<OrderStat> orderStat = orderService.getOrderNumByDate();
        return orderStat;
    }

    @RequestMapping(value = "booking", method= RequestMethod.POST)
    @ResponseBody
    public int booking(@RequestBody OrderInfo orderInfo, HttpServletRequest request, HttpServletResponse response) {
        Order order = new Order();
        String orderId = String.valueOf(Calendar.getInstance().getTimeInMillis());
        int orderState = 1;// 已完成
        order.setOrderId(orderId);
        order.setUserId(orderInfo.getOrder().getUserId());
        order.setContactName(orderInfo.getOrder().getContactName());
        order.setOrderState(orderState);
        order.setCellphone(orderInfo.getOrder().getCellphone());
        order.setEmail(orderInfo.getOrder().getEmail());
        order.setOrderDate(orderInfo.getOrder().getOrderDate());
        int id = orderService.addOrder(order);
        int result = 0;
        if(id!=0){
            List<Passenger> passengers = orderInfo.getPassengers();
            for (int i = 0; i < passengers.size(); i++) {
                String passengerId = passengers.get(i).getPassengerId();
                String[] flightIds = orderInfo.getTicket().getFlightId().split("-");
                for(int j = 0; j < flightIds.length; j++){
                    List<OrderItem> orderItems = new ArrayList<OrderItem>();
                    String orderItemId = String.valueOf(Calendar.getInstance().getTimeInMillis());
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrderId(orderId);
                    orderItem.setOrderItemId(orderItemId);
                    orderItem.setPassengerId(passengerId);
                    orderItem.setSeatRequire(orderInfo.getOrderItem().getSeatRequire());
                    String flightId = flightIds[j];
                    int cabinClassId = orderInfo.getTicket().getCabinClassId();
                    result += orderItemService.addOrderItem(orderItem, flightId, cabinClassId);
                    flightService.minusClassCount(flightId, cabinClassId);
                }
            }
        }
        return result;
    }
    private List<String> stringToList(String strs){
        String str[] = strs.split("-");
        return Arrays.asList(str);
    }
}
