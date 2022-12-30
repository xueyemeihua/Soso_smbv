package com.sky.soso.mapper;

import com.sky.soso.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

//    根据用户名和密码查询用户信息
    User getUserByUsernameAndPwd(@Param("username") String username, @Param("pwd") String pwd);

//    根据用户名查询用户信息
    User getUserByUsername(@Param("username") String username);

//    新增用户
    Integer insertUser(@Param("username") String username, @Param("pwd") String pwd);
}
