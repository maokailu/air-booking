package com.cumt.controller;


import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

	@RequestMapping("goToLogin")
	public ModelAndView goToLogin(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	@RequestMapping("fecthFlights")
	@ResponseBody
	public String fecthFlights(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
		List<Category> cs = categoryService.list();
		System.out.print("jj");
		return JSONArray.toJSON(cs).toString();
	}
	@RequestMapping("getLocation")
	@ResponseBody
	public String getLocation(HttpServletRequest request, HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		Category c = new Category();
		c.setId(100);
		c.setName("XuZhou");
		c.setFlightId(33);
		JSONObject json= new JSONObject();
		json.put("city", JSONObject.toJSON(c));
		return json.toJSONString();
	}
}
