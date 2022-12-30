package com.sky.soso.mapper;

import com.sky.soso.pojo.Business;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessMapper {

//    获取所有的业务信息并返回list集合
    List<Business> getAllBusiness();

//    根据用户名查询该用户办理的业务
    List<Business> getMyBusinessByUid(@Param("uid") Integer uid);

}
