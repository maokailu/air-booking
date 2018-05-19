package com.cumt.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.cumt.mapper.FlightMapper;
import com.cumt.pojo.Flight;
import com.cumt.pojo.FlightSearch;
import com.cumt.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl  implements FlightService {
    @Autowired
    FlightMapper flightMapper;
    public List<Flight> getFlightsBySearch(FlightSearch flightSearch){
        return flightMapper.getFlightsBySearch(flightSearch);
    };
    public int minusClassCount(String flightId, int classType){
        return flightMapper.minusClassCount(flightId,classType);
    };

}
