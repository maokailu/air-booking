package com.cumt.service.impl;

import com.cumt.mapper.OrderMapper;
import com.cumt.mapper.PassengerMapper;
import com.cumt.pojo.Order;
import com.cumt.service.OrderService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018-05-14.
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;

    public int addOrder(Order order){
        return orderMapper.addOrder(order);
    };
}
