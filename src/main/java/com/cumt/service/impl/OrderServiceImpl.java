package com.cumt.service.impl;

import com.cumt.mapper.OrderMapper;
import com.cumt.mapper.PassengerMapper;
import com.cumt.pojo.*;
import com.cumt.service.OrderService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018-05-14.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;
    public List<OrderInfo> getOrdersByUserId(String userId){
        return orderMapper.getOrdersByUserId(userId);
    }
    public int addOrder(Order order){
        return orderMapper.addOrder(order);
    };
    public List<OrderInfo> getOrdersBySearch(User user){
        return orderMapper.getOrdersBySearch(user);
    }
    public List<OrderQuery> getOrders(OrderQuery order){
        return orderMapper.getOrders(order);
    }
    public List<OrderStat> getOrderNumByDate(){
        return orderMapper.getOrderNumByDate();
    }
}
