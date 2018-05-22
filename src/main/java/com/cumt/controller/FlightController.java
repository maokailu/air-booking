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
@RequestMapping("")
public class FlightController {
    @Autowired
    FlightService flightService;
    @RequestMapping("getFlights")
    @ResponseBody
    public List<Flight> getFlights(@RequestBody FlightSearch flightSearch, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");
//        Cookie[] cookies = request.getCookies();
//        for(Cookie cookie : cookies){
//            System.out.println("name:"+cookie.getName()+",value:"+ cookie.getValue());
//        }
        List<Flight> flights = flightService.getFlightsBySearch(flightSearch);
        return flights;
    }

    @RequestMapping(value ="getCurrentCity")
    @ResponseBody
    public String getCurrentCity(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET,OPTIONS");
        response.setHeader("Access-Control-Expose-Headers", "Set-Cookie");
        response.setHeader("Set-Cookie", "uid=maokailu");
        City city = new City();
        city.setCityCode("SHA");
        city.setCityName("上海");
        city.getCountryCode();
        JSONObject json= new JSONObject();
        json.put("city", JSONObject.toJSON(city));
//        String url = "http://api.map.baidu.com/location/ip?ak=MTsoYO1kC64Gagtb9FdsXg2fbyyQvoTA";
//        JSONObject departCity = readJsonFromUrl(url);
//        System.out.println(departCity.toString());
        return json.toJSONString();
    }

    // 调用百度API进行当前城市定位
    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject();
            json.put("departCity",jsonText);
            return json;
        } finally {
            //关闭输入流
            is.close();
        }
    }
    public String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}

