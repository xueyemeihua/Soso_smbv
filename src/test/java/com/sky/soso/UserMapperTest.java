package com.sky.soso;

import com.sky.soso.mapper.UserMapper;
import com.sky.soso.pojo.User;
import com.sky.soso.utils.MD5Util;
import com.sky.soso.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    @Test
    public void testGetUserByUsernameAndPwd() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String md5 = MD5Util.getMD5("111");
        User user = mapper.getUserByUsernameAndPwd("hutao", md5);
        System.out.println(user);
    }


}
