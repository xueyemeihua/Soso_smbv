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

//    修改用户余额
    int updateUserMoney(@Param("uid") Integer uid, @Param("money") Integer rmoney);

//    根据用户编号查询用户信息
    User getUserByUid(@Param("uid") Integer uid);

//    根据uid修改积分
    int updateUserPoints(@Param("uid") Integer uid, @Param("points") Integer rpoints);
}
