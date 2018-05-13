package com.cumt.service;

import com.cumt.pojo.Flight;
import com.cumt.pojo.Passenger;

import java.util.List;

/**
 * Created by Administrator on 2018-05-13.
 */
public interface PassengerService {
    List<Passenger> getPassengersByUserId(int userId);
}
