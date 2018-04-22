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
import org.springframework.web.servlet.ModelAndView;
import com.cumt.pojo.Category;

import java.util.List;

/**
 * Created by Administrator on 2018-04-07.
 */

@Controller
@RequestMapping("")
public class FlightController {
    @Autowired
    FlightService flightService;
    @Autowired
    CategoryService categoryService;
    @RequestMapping("fecthFlights1")
    @ResponseBody
    public String fetchFlights(){
//        List<Flight> cs = flightService.list();
//        return JSONArray.toJSON(cs).toString();

        List<Category> cs = categoryService.list();
        return JSONArray.toJSON(cs).toString();
    }
}

