package com.sky.soso.service;

import com.sky.soso.mapper.UserMapper;
import com.sky.soso.pojo.User;
import com.sky.soso.utils.MD5Util;
import com.sky.soso.utils.SqlSessionUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

public class UserService {

    //获取mapper对象
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    public User checkLogin(String lusername, String lpwd) {
        //将用户输入的密码加密
        String md5_lpwd = MD5Util.getMD5(lpwd);
        //获取查询的用户信息并返回用户对象
        User user = mapper.getUserByUsernameAndPwd(lusername, md5_lpwd);
        return user;
    }

    public int checkRegister(String rusername, String rpwd) {
        //判断用户的用户名是否在数据库存在
        User user = mapper.getUserByUsername(rusername);
        if (user!=null) {
            //数据库中存在该用户名,注册失败
            return -1;
        } else {
            //数据库中没有该用户名,可以调用注册方法进行注册
            //将用户输入密码加密
            String md5 = MD5Util.getMD5(rpwd);
            int i = mapper.insertUser(rusername,md5);
            return i;
        }
    }

    public User getUserByUsername(String loginUsername) {
        User user = mapper.getUserByUsername(loginUsername);
        return user;
    }

    public User getUserByUid(Integer uid) {
        User user = mapper.getUserByUid(uid);
        return user;
    }

    public int updateUserInfo(String name, String phone, String cardid, Integer uid) {
        int result = mapper.updateUserInfo(name, phone, cardid, uid);
        return result;
    }
}
