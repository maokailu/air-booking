package com.cumt.service;

import com.cumt.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-05-14.
 */
public interface OrderService {
    public int addOrder(Order order);
    public List<OrderInfo> getOrdersByUserId(String userId);
    public List<OrderInfo> getOrdersBySearch(User user);
    public List<OrderQuery> getOrders(OrderQuery order);
    public List<OrderStat> getOrderNumByDate();
}
