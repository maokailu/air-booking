package com.cumt.mapper;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import com.cumt.pojo.Flight;
import com.cumt.pojo.FlightSearch;
import org.apache.ibatis.annotations.Param;

public interface FlightMapper {
    List<Flight> getFlightsBySearch(@Param("flightSearch")FlightSearch flightSearch, @Param("start")int start,@Param("size")int size );
    int minusClassCount(@Param("flightId")String flightId, @Param("classType")int classType);
}