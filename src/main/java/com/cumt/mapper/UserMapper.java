package com.cumt.mapper;

import com.cumt.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-05-21.
 */
public interface UserMapper {
    public User getUserByUserId(@Param("userId")String userId);
    public String getPassword(@Param("userId")String userId);
    public List<User> getUsers(@Param("user")User user);
    public int addUser(@Param("user")User user);
    public int updateUser(@Param("user")User user);
    public int dateleUser(@Param("userId")String userId);
    public List<User> getUsersBySearch(@Param("user")User user);
}
