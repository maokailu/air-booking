package com.cumt.mapper;

import com.cumt.pojo.Flight;
import com.cumt.pojo.Passenger;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-05-13.
 */
public interface PassengerMapper {
    List<Passenger> getPassengersByUserId(@Param("userId") int userId);
    int addPassenger(@Param("passenger")Passenger passenger);
}
