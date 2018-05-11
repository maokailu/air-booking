package com.cumt.mapper;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import com.cumt.pojo.Flight;

public interface FlightMapper {

    List<Flight> getFlightsBySearch(int flightType, String departCityCode, String arriveCityCode,  String departAirportCode, String arriveAirportCode, Timestamp departTime, Timestamp arriveTime, int classType, int passenger);

}