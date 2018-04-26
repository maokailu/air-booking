package com.cumt.service.impl;

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


    public List<Flight> list(Integer departCityCode, String name ){
        return flightMapper.list();
    };
    public List<Flight> query(){
        return flightMapper.query();
    };

}
