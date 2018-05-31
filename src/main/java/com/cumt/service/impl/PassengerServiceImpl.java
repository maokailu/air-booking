package com.cumt.service.impl;

import com.cumt.mapper.FlightMapper;
import com.cumt.mapper.PassengerMapper;
import com.cumt.pojo.Flight;
import com.cumt.pojo.Passenger;
import com.cumt.service.PassengerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2018-05-13.
 */
@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerMapper passengerMapper;
    public int addPassenger(Passenger passenger){
        return passengerMapper.addPassenger(passenger);
    };
    public List<Passenger> getPassengersByUserId(String userId){
        return passengerMapper.getPassengersByUserId(userId);
    };
}
