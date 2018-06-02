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
public class CityController {
    @Autowired
    CityService cityService;
//    获得热门目的地并按照国家分组 可直接搜索国家表及下面的城市集合
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
//    根据百度返回的cityNum获得当前城市信息
    @RequestMapping("getCurrentCityByCityNum")
    @ResponseBody
    public City getCurrentCityByCityNum(@RequestParam(name="cityNum") String cityNum, HttpServletRequest request, HttpServletResponse response) {
        City city = cityService.getCurrentCityByCityNum(cityNum);
        return city;
    }
//    按城市名、城市代码、机场名、机场代码搜索
//    得到按城市分组的机场
    @RequestMapping("getCitys")
    @ResponseBody
    public List<City> getCitys(@RequestParam(name="text")String text, HttpServletRequest request, HttpServletResponse response) {
        List<City> citys = cityService.getAirportsGroupByCity(text);
        return citys;
    }
}
