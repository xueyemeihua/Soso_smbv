package com.sky.soso.controller;

import com.sky.soso.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rusername = request.getParameter("rusername");
        String rpwd = request.getParameter("rpwd");
        UserService service = new UserService();
        int i = service.checkRegister(rusername,rpwd);
        if (i == 1) {
            //注册成功,跳转到登录页面
            request.setAttribute("lusername",rusername);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        } else if (i== -1){
            //返回注册页面,并提示用户名已存在
            request.setAttribute("registerError","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        } else {
            //存入数据库失败
            request.setAttribute("registerError","连接数据库失败,请检查网络");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
