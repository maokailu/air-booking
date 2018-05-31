package com.cumt.controller;

import com.alibaba.fastjson.JSON;
import com.cumt.pojo.Flight;
import com.cumt.pojo.FlightSearch;
import com.cumt.pojo.Passenger;
import com.cumt.service.FlightService;
import com.cumt.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Passenger> getPassengers(@RequestParam(name="userId")String userId, HttpServletRequest request, HttpServletResponse response) {
        List<Passenger> passengers = passengerService.getPassengersByUserId(userId);
        System.out.print(passengers);
        return passengers;
    }
    @RequestMapping("addPassengers")
    @ResponseBody
    public String addPassengers(@RequestBody Passenger passenger, HttpServletRequest request, HttpServletResponse response) {
        int num = passengerService.addPassenger(passenger);
        Map<String,String> result = new HashMap<String, String>();
        result.put("result", "恭喜您，乘客添加成功");
        return JSON.toJSONString(result);
    }
}
