package com.sky.soso.controller;

import com.sky.soso.pojo.Business;
import com.sky.soso.pojo.User;
import com.sky.soso.service.BusinessService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowMyBusinessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessService service = new BusinessService();
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser!=null) {
            Integer loginUserUid = loginUser.getUid();
            List<Business> buss = service.showMyBusiness(loginUserUid);
            if (buss!=null) {
                if (buss.size()>0) {
                    //存在业务
                    request.setAttribute("showMyBusError","");
                    request.setAttribute("myBuss",buss);
                    request.getRequestDispatcher("/somejsp/showMyBusiness.jsp").forward(request,response);
                } else {
                    //不存在业务
                    request.setAttribute("myBuss",buss);
                    request.setAttribute("showMyBusError","没有数据");
                    request.getRequestDispatcher("/somejsp/showMyBusiness.jsp").forward(request,response);

                }
            } else {
                //连接数据库失败,给出错误信息
                request.setAttribute("showMyBusError","连接数据库失败");
                request.setAttribute("myBuss",buss);
                request.getRequestDispatcher("/somejsp/showMyBusiness.jsp").forward(request,response);
            }
        } else {
            //登录信息失效,返回登录界面
            request.getRequestDispatcher("/somejsp/login.jsp").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
