package com.sky.soso.service;

import com.sky.soso.mapper.BusinessMapper;
import com.sky.soso.pojo.Business;
import com.sky.soso.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BusinessService {




    public List<Business> showMyBusiness(Integer loginUserUid) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Business> myBuss = sqlSession.getMapper(BusinessMapper.class).getMyBusinessByUid(loginUserUid);
        return myBuss;
    }
}
