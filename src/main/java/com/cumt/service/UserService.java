package com.cumt.service;

import com.cumt.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-05-21.
 */
public interface UserService {
    public User getUserByUserId(String userId);
    public String getPassword(String userId);
    public List<User> getUsers(User user);
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUser(String userId);
    public List<User> getUsersBySearch(User user);
}
