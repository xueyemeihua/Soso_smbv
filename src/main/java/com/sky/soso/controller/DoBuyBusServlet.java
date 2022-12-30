package com.sky.soso.controller;

import com.sky.soso.pojo.User;
import com.sky.soso.service.BusinessService;
import com.sky.soso.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoBuyBusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessService service = new BusinessService();
        //获取用户id和用户输入的业务id
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        //防止登录用户信息失效(避免空指针)
        if (loginUser != null) {
            Integer uid = loginUser.getUid();
            Integer bbid = Integer.parseInt(request.getParameter("bbid"));
            //判断用户输入的业务id对应的业务状态是否为1(上架状态)
            int checkBuyBusBidNum = service.checkBuyBusBid(bbid, 1);
            if (checkBuyBusBidNum == 0) {
                //id不合理,重新输入
                request.setAttribute("doBuyBusError", "业务编号输入不合理");
                request.getRequestDispatcher("/buyBusiness.jsp").forward(request, response);
            } else {
                //id合理,判断余额是否充足
                //获取用户余额
                Integer loginUserMoney = loginUser.getMoney();
                //判断余额是否充足
                int rmoney = service.checkMoney(loginUserMoney, bbid);
                if (rmoney >= 0) {
                    //余额充足
                    //扣除费用
                    int updateMoneyNum = service.buyBusUpdateMoney(uid,rmoney);
                    if (updateMoneyNum < 1) {
                        //扣除金额失败,直接报错即可
                        request.setAttribute("doBuyBusError", "连接数据库失败,请检查网络或重试");
                        request.getRequestDispatcher("/buyBusiness.jsp").forward(request, response);
                    } else {
                        //添加业务进个人账户
                        int insertMyBusNum = service.buyBusInsertMyBus(uid, bbid);
                        if (insertMyBusNum < 1) {
                            //添加失败,考虑回退金额并跳转到购买页面并提示(没想好怎么实现)
                            int result = service.buyBusReUpdateMoney(uid,rmoney,bbid);
                            request.setAttribute("doBuyBusError", "连接数据库失败,请检查网络或重试");
                            request.getRequestDispatcher("/buyBusiness.jsp").forward(request, response);
                        } else {
                            //购买成功
                            //获取最新用户信息,并覆盖loginUser
                            UserService userService = new UserService();
                            User user = userService.getUserByUid(uid);
                            request.getSession().setAttribute("loginUser",user);
                            request.setAttribute("doBuyBusError", "");
                            request.getRequestDispatcher("/userView.jsp").forward(request, response);
                        }
                    }
                } else {
                    //余额不足
                    request.setAttribute("doBuyBusError", "余额不足,请充值");
                    request.getRequestDispatcher("/buyBusiness.jsp").forward(request, response);
                }
            }

        } else {
            //登录信息失效,重新登录
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
