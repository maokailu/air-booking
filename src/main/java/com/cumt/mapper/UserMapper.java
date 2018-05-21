package com.cumt.mapper;

import com.cumt.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018-05-21.
 */
public interface UserMapper {
    public User getUserByUserId(@Param("userId")String userId);
    public String getPassword(@Param("userId")String userId);
}
