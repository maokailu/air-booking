package com.cumt.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.cumt.pojo.City;
import com.cumt.pojo.Flight;
import com.cumt.pojo.FlightSearch;
import com.cumt.service.CategoryService;
import com.cumt.service.FlightService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.corba.se.spi.activation.LocatorPackage.ServerLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class FlightController {
    @Autowired
    FlightService flightService;
//    搜索航班
    @RequestMapping("getFlights")
    @ResponseBody
    public List<Flight> getFlights(@RequestBody FlightSearch flightSearch,@RequestParam(name="start")int start,@RequestParam(name="size")int size, HttpServletRequest request, HttpServletResponse response) {
        List<Flight> flights = flightService.getFlightsBySearch(flightSearch, size * start, size);
        return flights;
    }
}

