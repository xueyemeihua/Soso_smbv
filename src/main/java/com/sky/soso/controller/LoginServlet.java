package com.sky.soso.controller;

import com.sky.soso.pojo.User;
import com.sky.soso.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户输入的信息
        String lusername = request.getParameter("lusername");
        String lpwd = request.getParameter("lpwd");
        UserService service = new UserService();
        User user = service.checkLogin(lusername,lpwd);
        if (user!=null) {
            //登录成功并跳转
            request.getSession().setAttribute("loginUser",user);
            request.setAttribute("loginError","");
            if (lusername.equals("admin")) {
                //跳转到管理员页面
                request.getRequestDispatcher("/somejsp/adminView.jsp").forward(request,response);
            } else {
                //跳转到用户页面
                request.getRequestDispatcher("/somejsp/userView.jsp").forward(request,response);
            }
        } else {
            //返回登录页面并提示用户名或密码错误
            request.setAttribute("loginUsername",lusername);
            request.setAttribute("loginError","用户名或密码错误");
            request.getRequestDispatcher("/somejsp/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
