package com.cumt.controller;

import com.cumt.pojo.Flight;
import com.cumt.pojo.FlightSearch;
import com.cumt.pojo.Passenger;
import com.cumt.service.FlightService;
import com.cumt.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2018-05-13.
 */

@Controller
@RequestMapping("")
public class PassengerController {
    @Autowired
    PassengerService passengerService;
    @RequestMapping("getPassengers")
    @ResponseBody
    public List<Passenger> getFlights(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");
        List<Passenger> passengers = passengerService.getPassengersByUserId(0);
        System.out.print(passengers);
        return passengers;
    }
}