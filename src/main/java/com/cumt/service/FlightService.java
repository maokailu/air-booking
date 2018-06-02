package com.cumt.service;

import java.sql.Timestamp;
import java.util.List;

import com.cumt.pojo.Flight;
import com.cumt.pojo.FlightSearch;
import org.apache.ibatis.annotations.Param;

public interface FlightService {
    List<Flight> getFlightsBySearch(FlightSearch flightSearch, int start, int size);
    int minusClassCount(String flightId, int classType);
}
