package com.cumt.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cumt.pojo.Flight;
import com.cumt.service.CategoryService;
import com.cumt.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2018-04-07.
 */

@Controller
@RequestMapping("")
public class FlightController {
    @Autowired
    FlightService flightService;
    @RequestMapping("fecthFlightssss")
    @ResponseBody
    public String fecthFlights1(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Flight> cs = flightService.list();
        System.out.print("jj");
        return JSONArray.toJSONString(cs);
    }
    @RequestMapping("getLocationFlight")
    @ResponseBody
    public String getLocationFlight(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Flight c = new Flight();
        c.setId(100);
        c.setName("XuZhouJJ");
        JSONObject json= new JSONObject();
        json.put("city", JSONObject.toJSON(c));
        return json.toJSONString();
    }
}

