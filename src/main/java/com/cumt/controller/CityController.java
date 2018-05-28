package com.cumt.controller;

import com.alibaba.fastjson.JSONArray;
import com.cumt.pojo.City;
import com.cumt.pojo.Flight;
import com.cumt.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<City> citys = cityService.getHotCitys();
        Map<String, ArrayList> hotDestination = new HashMap<String, ArrayList>();
        Map<String, ArrayList> citysGroupByCountry = new HashMap<String, ArrayList>();
        for (City city : citys) {
            if(citysGroupByCountry.get(city.getCountryCode()) != null){
                citysGroupByCountry.get(city.getCountryCode()).add(city);
            } else {
                ArrayList list = new ArrayList<>();
                list.add(city);
                citysGroupByCountry.put(city.getCountryCode(), list);
            }
        }
        System.out.print(citysGroupByCountry);
        return JSONArray.toJSONString(citysGroupByCountry);
    }
    @RequestMapping("getCurrentCityByCityNum")
    @ResponseBody
    public City getCurrentCityByCityNum(@RequestParam(name="cityNum") String cityNum, HttpServletRequest request, HttpServletResponse response) {
        City city = cityService.getCurrentCityByCityNum(cityNum);
        return city;
    }
    @RequestMapping("getCitys")
    @ResponseBody
    public List<City> getCitys(@RequestParam(name="text")String text, HttpServletRequest request, HttpServletResponse response) {
        List<City> citys = cityService.getAirportsGroupByCity(text);
        return citys;
    }
}
