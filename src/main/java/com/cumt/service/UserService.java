package com.cumt.service;

import com.cumt.pojo.User;

/**
 * Created by Administrator on 2018-05-21.
 */
public interface UserService {
    public User getUserByUserId(String userId);
    public String getPassword(String userId);
}
