package com.sky.soso.service;

import com.sky.soso.mapper.BusinessMapper;
import com.sky.soso.mapper.UabtabMapper;
import com.sky.soso.mapper.UserMapper;
import com.sky.soso.pojo.Business;
import com.sky.soso.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BusinessService {

    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    BusinessMapper mapper = sqlSession.getMapper(BusinessMapper.class);

    //查询出我的业务并返回集合
    public List<Business> showMyBusiness(Integer loginUserUid) {
        List<Business> myBuss = mapper.getMyBusinessByUid(loginUserUid);
        return myBuss;
    }

    //查询出上架中的业务并返回集合
    public List<Business> showPubBusiness() {
        List<Business> pubBus = mapper.getBusinessByBcod(1);
        return pubBus;
    }

    //查询出未上架的业务并返回集合
    public List<Business> showUnPubBusiness() {
        List<Business> unPubBus = mapper.getBusinessByBcod(0);
        return unPubBus;
    }

    //    根据业务id查询该业务状态是否为某个值
    public int checkBuyBusBid(Integer bbid, Integer bcod) {
        int checkNum = mapper.checkBusBcodByBid(bbid, bcod);
        return checkNum;
    }

//    购买业务(此方法弃用,一个方法执行一个sql语句,防止sql执行不同时成功的情况发生)
//    public int buyBus(Integer uid, Integer bbid, Integer rmoney) {
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        //修改账户余额
//        int result1 = sqlSession.getMapper(UserMapper.class).updateUserMoney(bbid, rmoney);
//        //添加业务
//        int result2 = sqlSession.getMapper(UabtabMapper.class).insertColum(uid,bbid);
//        return result1+result2;
//    }

    //    购买业务修改余额
    public int buyBusUpdateMoney(Integer uid, Integer rmoney) {
        //修改账户余额
        int result = sqlSession.getMapper(UserMapper.class).updateUserMoney(uid, rmoney);
        return result;
    }

    //    购买业务添加进个人业务
    public int buyBusInsertMyBus(Integer uid, Integer bbid) {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //添加业务
        int result = sqlSession.getMapper(UabtabMapper.class).insertColum(uid, bbid);
        return result;
    }

    //    判断用户余额是否充足
    public int checkMoney(Integer loginUserMoney, Integer bbid) {
        int rmoney = -1;
        Business bus = mapper.getBusByBid(bbid);
        if (bus != null) {
            //获取业务价格
            Integer bprice = bus.getBprice();
            rmoney = loginUserMoney - bprice;
        }
        return rmoney;
    }

    //    回退余额
    public int buyBusReUpdateMoney(Integer uid, Integer rmoney, Integer bbid) {
        Business bus = sqlSession.getMapper(BusinessMapper.class).getBusByBid(bbid);
        Integer result = sqlSession.getMapper(UserMapper.class).updateUserMoney(uid, rmoney + bus.getBprice());
        return result;
    }

    //    购买业务修改个人积分
    public int buyBusUpdatePoints(Integer uid, Integer rpoints) {
        int result = 0;
        if (rpoints >= 0) {
            result = sqlSession.getMapper(UserMapper.class).updateUserPoints(uid, rpoints);
        }
        return result;
    }

    //    购买业务计算新积分
    public int countPoints(Integer points, Integer bbid) {
        Business bus = mapper.getBusByBid(bbid);
        if (bus != null) {
            int rpoints = bus.getBprice() * 10 + points;
            return rpoints;
        }
        return -1;
    }
}
