package com.cumt.controller;

import com.alibaba.fastjson.JSONArray;
import com.cumt.pojo.Airport;
import com.cumt.pojo.City;
import com.cumt.pojo.Flight;
import com.cumt.service.AirportService;
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
 * Created by Administrator on 2018-05-22.
 */
@Controller
@RequestMapping("")
public class AirportController {
    @Autowired
    AirportService airportService;
}
