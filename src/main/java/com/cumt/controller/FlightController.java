package com.cumt.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cumt.pojo.City;
import com.cumt.pojo.Flight;
import com.cumt.service.CategoryService;
import com.cumt.service.FlightService;
import com.sun.corba.se.spi.activation.LocatorPackage.ServerLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
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
    @RequestMapping("getFlights")
    @ResponseBody
    public String getFlights(@RequestBody Flight flight, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());
        }
        Cookie cookie = new Cookie("sid", "mmm");
        cookie.setMaxAge(30 * 60);
        cookie.setPath("/");
        System.out.println("已添加===============");
        response.addCookie(cookie);
        List<Flight> flights = flightService.list(flight.getDepartCityCode(), flight.getArriveCityCode());
        return JSONArray.toJSONString(flights);
    }
    @RequestMapping(value ="getCurrentCity")
    @ResponseBody
    public String getCurrentCity(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET,OPTIONS");
        response.setHeader("Access-Control-Expose-Headers", "Set-Cookie");
        response.setHeader("Set-Cookie", "uid=maokailu");
        City city = new City();
        city.setId(2);
        city.setCityCode("SHA");
        JSONObject json= new JSONObject();
        json.put("city", JSONObject.toJSON(city));

        return json.toJSONString();
    }
}

