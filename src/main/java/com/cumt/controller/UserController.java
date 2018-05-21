package com.cumt.controller;

import com.alibaba.fastjson.JSON;
import com.cumt.pojo.*;
import com.cumt.service.PassengerService;
import com.cumt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-05-13.
 */
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
//    登陆功能
    @RequestMapping("login")
    @ResponseBody
    public String login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8082");
        response.setHeader("Access-Control-Allow-Method", "POST, GET");
        String result = "";
        User findUser = userService.getUserByUserId(user.getUserId());
        String userId = "";
        if(findUser!=null){
            userId = findUser.getUserId();
        }
        String password = user.getPassword();
        if(!userId.equals("")){
            if(findUser.getPassword().equals(password)){
                String userIdEncode = "";
                userIdEncode = URLEncoder.encode(userId, "UTF-8");
                Cookie cookie = new Cookie("userId", userIdEncode);
                cookie.setMaxAge(30 * 60);
                cookie.setPath("/");
                System.out.println("已添加===============");
                response.addCookie(cookie);
                result = "登陆成功！";
            }else{
                result = "密码错误！";
            };
        }else{
            result = "账户不存在！";
        }
        return JSON.toJSONString(result);
    }

}
