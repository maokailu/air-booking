package com.cumt.service.impl;

import com.cumt.mapper.TicketMapper;
import com.cumt.mapper.UserMapper;
import com.cumt.pojo.User;
import com.cumt.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018-05-21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public User getUserByUserId(String userId){
        return userMapper.getUserByUserId(userId);
    }
    public String getPassword(String userId){
        return userMapper.getPassword(userId);
    }
    public List<User> getUsers(User user){
        return userMapper.getUsers(user);
    }
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    public int updateUser(User user){
        return userMapper.updateUser(user);
    }
    public int deleteUser(String userId){
        return userMapper.dateleUser(userId);
    }
    public List<User> getUsersBySearch(User user){
        return userMapper.getUsersBySearch((user));
    }
}
