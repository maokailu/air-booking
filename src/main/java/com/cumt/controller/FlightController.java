package com.cumt.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cumt.pojo.Flight;
import com.cumt.service.CategoryService;
import com.cumt.service.FlightService;
import com.sun.corba.se.spi.activation.LocatorPackage.ServerLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("")
public class FlightController {
    @Autowired
    FlightService flightService;
    @RequestMapping("fecthFlightsFlight")
    @ResponseBody
    public String fecthFlights1(@RequestBody Flight flight, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");
        List<Flight> flights = flightService.list(100, "Shenzhen Airlines");
        return JSONArray.toJSONString(flights);
    }
//    @RequestMapping(value ="getLocationFlight")
//    @ResponseBody
//    public String getLocationFlight(@RequestBody Flight flight, HttpServletRequest request, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
//        response.setHeader("Access-Control-Allow-Method", "POST, GET,OPTIONS");
//        response.setHeader("Access-Control-Allow-Headers", "content-type");
//        Flight city = new Flight();
//        city.setFlightId(flight.getFlightId());
//        city.setName(flight.getName());
//        JSONObject json= new JSONObject();
//        json.put("city", JSONObject.toJSON(city));
//
//        return json.toJSONString();
//    }
}

