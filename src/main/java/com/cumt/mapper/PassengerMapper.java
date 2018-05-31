package com.cumt.mapper;

import com.cumt.pojo.Flight;
import com.cumt.pojo.Passenger;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018-05-13.
 */
@Repository
public interface PassengerMapper {
    List<Passenger> getPassengersByUserId(@Param("userId")String userId);
    int addPassenger(@Param("passenger")Passenger passenger);
}
