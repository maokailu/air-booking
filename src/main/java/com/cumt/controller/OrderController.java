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

    @RequestMapping("getOrdersByUserId")
    @ResponseBody
    public List<OrderInfo>  getOrdersByUserId(@RequestParam(name="userId")String userId, HttpServletRequest request, HttpServletResponse response) {
        List<OrderInfo>  orders = orderService.getOrdersByUserId(userId);
        return orders;
    }
//   查询所有订单及其子订单和我的订单

    @RequestMapping("getOrders")
    @ResponseBody
    public List<OrderQuery>  getOrders(@RequestBody OrderQuery order, HttpServletRequest request, HttpServletResponse response) {
        List<OrderQuery>  orders = orderService.getOrders(order);
        return orders;
    }
//    根据日期统计订单数目
    @RequestMapping("getOrderNumByDate")
    @ResponseBody
    public List<OrderStat> getOrderNumByDate(HttpServletRequest request, HttpServletResponse response) {
        List<OrderStat> orderStat = orderService.getOrderNumByDate();
        return orderStat;
    }
// 创建订单和子订单
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
        order.setTotalTicketPrice(orderInfo.getOrder().getTotalTicketPrice());
        order.setTotalAirportTax(orderInfo.getOrder().getTotalAirportTax());
        order.setTotalPrice(orderInfo.getOrder().getTotalPrice());
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
    //    根据订单号获得指定订单
    @RequestMapping("getOrderByOrderId")
    @ResponseBody
    public OrderQuery getOrderByOrderId(@RequestParam(name="orderId")String orderId, HttpServletRequest request, HttpServletResponse response) {
        OrderQuery orderQuery = orderService.getOrderByOrderId(orderId);
        return orderQuery;
    }
    //    根据订单号取消指定订单
    @RequestMapping("cancelOrderByOrderId")
    @ResponseBody
    public int cancelOrderByOrderId(@RequestParam(name="orderId")String orderId, HttpServletRequest request, HttpServletResponse response) {
//        将主订单状态置为0
        int result = orderService.cancelOrderByOrderId(orderId);
        return result;
    }
//    将String[]类型转换成List<String>
    private List<String> stringToList(String strs){
        String str[] = strs.split("-");
        return Arrays.asList(str);
    }
}

//order只包括主订单信息
//orderInfo为订单相关信息汇总 更简洁不过设计有误
//orderQuery包括所有关联表信息:用于后台管理
