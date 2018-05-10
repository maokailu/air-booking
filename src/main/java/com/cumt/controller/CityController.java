package com.cumt.controller;

import com.alibaba.fastjson.JSONArray;
import com.cumt.pojo.City;
import com.cumt.pojo.Flight;
import com.cumt.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-05-02.
 */
@Controller
@RequestMapping("")
public class CityController {
    @Autowired
    CityService cityService;
    @RequestMapping("getHotDestinations")
    @ResponseBody
    public String getHotDestinations(@RequestBody Flight flight, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");
        List<City> citys = cityService.getHotCitys();
        Map<String, List> hotDestination = new HashMap<String, List>();
        Map<String, List> countrys = new HashMap<String, List>();
        for (City city : citys) {
            if(countrys.get(city.getCountryName()) != null){
                countrys.get(city.getCountryName()).add(city);
            } else {
                countrys.put(city.getCountryName(), new ArrayList());
            }
        }
        return JSONArray.toJSONString(countrys);
    }
}
