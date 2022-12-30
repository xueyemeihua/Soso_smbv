package com.sky.soso.controller;

import com.sky.soso.pojo.Business;
import com.sky.soso.service.BusinessService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuyBusinessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessService service = new BusinessService();
        List<Business> pubBus = service.showPubBusiness();
        if (pubBus!=null) {
            if (pubBus.size()>0) {
                //有数据
                request.setAttribute("pubBus",pubBus);
                request.setAttribute("buyBusError","");
                request.getRequestDispatcher("/buyBusiness.jsp").forward(request,response);
            } else {
                //没有数据
                request.setAttribute("pubBus",pubBus);
                request.setAttribute("buyBusError","没有可以购买的业务");
                request.getRequestDispatcher("/buyBusiness.jsp").forward(request,response);
            }
        } else {
            //连接数据库失败
            pubBus = new ArrayList<>();
            request.setAttribute("pubBus",pubBus);
            request.setAttribute("buyBusError","连接数据库失败,请检查网络或重新尝试");
            request.getRequestDispatcher("/buyBusiness.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
