package com.cumt.controller;


import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cumt.pojo.Flight;
import com.cumt.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cumt.pojo.Category;
import com.cumt.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	FlightService flightService;

	@RequestMapping("gotologin")
	public ModelAndView gotologin(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
    @RequestMapping("gototest")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("test");
        return mav;
    }
	@RequestMapping("gotolist")
	public ModelAndView gotolist(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		return mav;
	}
	@RequestMapping("fecthFlights")
	@ResponseBody
	public String fecthFlights(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
		List<Category> cs = categoryService.list();
		return JSONArray.toJSON(cs).toString();
	}
}
