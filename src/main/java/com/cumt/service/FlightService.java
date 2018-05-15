package com.cumt.service;

import java.sql.Timestamp;
import java.util.List;

import com.cumt.pojo.Flight;
import org.apache.ibatis.annotations.Param;

public interface FlightService {

    List<Flight> getFlightsBySearch(int flightType, String departCityCode, String arriveCityCode, String departAirportCode, String arriveAirportCode, Timestamp departTime, Timestamp arriveTime, int classType, int passenger);
    int minusClassCount(String flightId, int classType);
}
