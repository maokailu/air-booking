package com.cumt.controller;

import com.cumt.pojo.Order;
import com.cumt.pojo.OrderInfo;
import com.cumt.pojo.OrderItem;
import com.cumt.service.OrderItemService;
import com.cumt.service.OrderService;
import com.cumt.service.PassengerService;
import com.cumt.utils.MetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2018-05-14.
 */
@Controller
@RequestMapping("")
public class OrderController {
    @Autowired
    OrderService orderService;
    OrderItemService orderItemService;
    @RequestMapping("createOrder")
    @ResponseBody
    public void createOrder(@RequestBody OrderInfo orderInfo, OrderItem orderItem, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");
        String ticketId = "0";
        if(ticketId.equals("0")) {
            int num = orderService.addOrder(orderInfo.getOrder());
            orderItemService.addOrderItem(orderInfo.getOrderItem());
        }
        System.out.print(orderInfo);
    }
}
