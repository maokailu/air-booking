package com.cumt.mapper;

import com.cumt.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-05-15.
 */
public interface OrderItemMapper {
    public int addOrderItem(@Param("orderItem")OrderItem orderItem, @Param("flightId")String flightId, @Param("cabinClassId")int cabinClassId);
}
