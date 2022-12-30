package com.sky.soso.mapper;

import org.apache.ibatis.annotations.Param;

public interface UabtabMapper {

//    购买业务
    int insertColum(@Param("uid") Integer uid, @Param("bid") Integer bbid);

}
