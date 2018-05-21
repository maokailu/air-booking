package com.cumt.mapper;

import com.cumt.pojo.Order;
import com.cumt.pojo.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-05-14.
 */
public interface OrderMapper {
    public int addOrder(Order order);
    public List<OrderInfo> getOrdersByUserId(@Param("userId")String userId);
}
