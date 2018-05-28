package com.cumt.controller;

import com.alibaba.fastjson.JSON;
import com.cumt.pojo.*;
import com.cumt.service.PassengerService;
import com.cumt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

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
    //    查询用户
    @RequestMapping("getUsers")
    @ResponseBody
    public List<User> getUsers(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        List<User> users = userService.getUsers(user);
        return users;
    }
    //    新增用户
    @RequestMapping("addUser")
    @ResponseBody
    public int addUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//        时间戳
        String userId = String.valueOf(Calendar.getInstance().getTimeInMillis());
        User userObj = new User();
        user.setUserId(userId);
        int num = userService.addUser(user);
        return num;
    }
    //    更新用户
    @RequestMapping("updateUser")
    @ResponseBody
    public int updateUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        int result = userService.updateUser(user);
        return result;
    }
    //    删除用户
    @RequestMapping("deleteUser")
    @ResponseBody
    public int deleteUser(@RequestParam(name="userId")String userId, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        int result = userService.deleteUser(userId);
        return result;
    }
    //    搜索用户
    @RequestMapping("getUsersBySearch")
    @ResponseBody
    public List<User> getUsersBySearch(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        List<User> users = userService.getUsersBySearch(user);
        return users;
    }
}
