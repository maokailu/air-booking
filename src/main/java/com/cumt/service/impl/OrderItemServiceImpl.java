package com.cumt.service.impl;

import com.cumt.mapper.OrderItemMapper;
import com.cumt.mapper.OrderMapper;
import com.cumt.pojo.OrderItem;
import com.cumt.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018-05-15.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    OrderItemMapper orderItemMapper;

    public int addOrderItem(OrderItem orderItem){
        return orderItemMapper.addOrderItem(orderItem);
    };
}
