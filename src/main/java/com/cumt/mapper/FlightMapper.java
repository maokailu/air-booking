package com.cumt.mapper;

import java.util.List;

import com.cumt.pojo.Flight;

public interface FlightMapper {


    public int add(Flight flight);


    public void delete(int id);


    public Flight get(int id);


    public int update(Flight flight);


    public List<Flight> list();


    public int count();



}