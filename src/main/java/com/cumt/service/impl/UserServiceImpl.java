package com.cumt.service.impl;

import com.cumt.mapper.TicketMapper;
import com.cumt.mapper.UserMapper;
import com.cumt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018-05-21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public String getUserId(String userId){
        return userMapper.getUserId(userId);
    }
    public String getPassword(String userId){
        return userMapper.getPassword(userId);
    }

}
