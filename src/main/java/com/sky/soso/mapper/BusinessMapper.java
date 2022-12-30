package com.sky.soso.mapper;

import com.sky.soso.pojo.Business;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessMapper {

//    获取所有的业务信息并返回list集合
    List<Business> getAllBusiness();

//    根据用户名查询该用户办理的业务
    List<Business> getMyBusinessByUid(@Param("uid") Integer uid);

//    根据业务状态查询业务
    List<Business> getBusinessByBcod(@Param("bcod") int bcod);

//    根据业务id查询该业务状态是否为某个值
    int checkBusBcodByBid(@Param("bid") Integer bbid, @Param("bcod") int bcod);

//    根据bid获取业务对象
    Business getBusByBid(@Param("bid") Integer bbid);

}
