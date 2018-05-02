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
        List<City> citys = cityService.queryByCountryId(0);
        Map<String, List> hotDestination = new HashMap<String, List>();
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        for (City city : citys) {
            if(city.getCountryId() == 0){
                list1.add(city);
            } else if(city.getCountryId() == 1){
                list2.add(city);
            }
        }
        hotDestination.put("china", list1);
        hotDestination.put("United States", list2);
        System.out.print(citys);
        return JSONArray.toJSONString(hotDestination);
    }
}
