package com.sky.soso;

import com.sky.soso.mapper.BusinessMapper;
import com.sky.soso.pojo.Business;
import com.sky.soso.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class BusinessMapperTest {

    @Test
    public void testGetAllBusiness() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Business> buss = sqlSession.getMapper(BusinessMapper.class).getAllBusiness();
        System.out.println(buss);
    }

    @Test
    public void testGetMyBusinessByUid() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        List<Business> buss = sqlSession.getMapper(BusinessMapper.class).getMyBusinessByUid(1001);
        System.out.println(buss);
    }

}
