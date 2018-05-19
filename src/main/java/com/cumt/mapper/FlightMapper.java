package com.cumt.mapper;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import com.cumt.pojo.Flight;
import com.cumt.pojo.FlightSearch;
import org.apache.ibatis.annotations.Param;

public interface FlightMapper {

    List<Flight> getFlightsBySearch(@Param("flightSearch")FlightSearch flightSearch);
//    List<Flight> getFlightsBySearch(@Param("flightType") int flightType,@Param("departCityCode") String departCityCode,@Param("arriveCityCode") String arriveCityCode,@Param("departAirportCode") String departAirportCode,@Param("arriveAirportCode") String arriveAirportCode,@Param("departTime") Timestamp departTime,@Param("arriveTime") Timestamp arriveTime,@Param("classType") int classType,@Param("passenger") int passenger);
    int minusClassCount(@Param("flightId")String flightId, @Param("classType")int classType);
}