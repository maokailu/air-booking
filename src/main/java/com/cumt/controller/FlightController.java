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
    public String fecthFlights1(@RequestParam(required=false,defaultValue = "1") String name, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");

        List<Flight> flights = flightService.list(100, "China XuZhou");
        return JSONArray.toJSONString(flights);
    }
    @RequestMapping(value ="getLocationFlight")
    @ResponseBody
    public String getLocationFlight(@RequestParam(required=false,defaultValue = "bbb")String name, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");
        Flight flight = new Flight();
        flight.setFlightId(100);
        flight.setName("XuZhou");
        JSONObject json= new JSONObject();
        json.put("city", JSONObject.toJSON(flight));

        return json.toJSONString();
    }
//    public static void main d(String[] args) {
//        ServerLocation location = obj.getLocation("206.190.36.45");
//        System.out.println(location);
//    }
}

