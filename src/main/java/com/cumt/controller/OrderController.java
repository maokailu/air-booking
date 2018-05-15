package com.cumt.controller;

import com.alibaba.fastjson.JSON;
import com.cumt.pojo.Order;
import com.cumt.pojo.OrderInfo;
import com.cumt.pojo.OrderItem;
import com.cumt.pojo.Passenger;
import com.cumt.service.FlightService;
import com.cumt.service.OrderItemService;
import com.cumt.service.OrderService;
import com.cumt.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");

        String orderId = "6";
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(orderInfo.getOrder().getUserId());
        order.setContactName(orderInfo.getOrder().getContactName());
        order.setOrderState(orderInfo.getOrder().getOrderState());
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
        result.put("result", "恭喜您，预定成功！以下是您的订单信息");
        return JSON.toJSONString(result);
    }

    @RequestMapping("getOrderDetail")
    @ResponseBody
    public String getOrderDetail(@RequestBody String orderId, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");

        return JSON.toJSONString("");
    }
}
