package com.cumt.service;

import com.cumt.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-05-15.
 */
public interface OrderItemService {
    public int addOrderItem(OrderItem orderItem, String flightId, int cabinClassId);
}
