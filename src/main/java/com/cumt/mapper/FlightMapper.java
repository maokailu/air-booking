package com.cumt.mapper;

import java.util.List;

import com.cumt.pojo.Flight;

public interface FlightMapper {

    List<Flight> list();
    List<Flight> query();

}