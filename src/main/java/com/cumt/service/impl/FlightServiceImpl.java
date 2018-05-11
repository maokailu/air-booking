package com.cumt.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.cumt.mapper.FlightMapper;
import com.cumt.pojo.Flight;
import com.cumt.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl  implements FlightService {
    @Autowired
    FlightMapper flightMapper;
    public List<Flight> getFlightsBySearch(int flightType, String departCityCode, String arriveCityCode,  String departAirportCode, String arriveAirportCode, Timestamp departTime, Timestamp arriveTime, int classType, int passenger){
        return flightMapper.getFlightsBySearch(flightType,departCityCode,arriveCityCode, departAirportCode, arriveAirportCode, departTime, arriveTime, classType, passenger);
    };
}
