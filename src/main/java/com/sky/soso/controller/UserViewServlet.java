package com.sky.soso.controller;

import com.sky.soso.pojo.User;
import com.sky.soso.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//使用登录的用户名从数据库获取最新用户信息
public class UserViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginUsername = null;
        //从域对象获取登录用户对象
        User loginUser = (User)(request.getSession().getAttribute("loginUser"));
        if (loginUser!=null){
            //获取登录名
            loginUsername = loginUser.getUsername();
        }
        UserService service = new UserService();
        //通过用户名查询用户信息
        User user = service.getUserByUsername(loginUsername);
        if (user!=null) {
            //将新的用户信息覆盖旧的用户信息
            request.setAttribute("loginUser",user);
            if (loginUsername.equals("admin")) {
                request.getRequestDispatcher("/adminView.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("/userView.jsp").forward(request,response);
            }
        } else {
            //登录信息失效,重新登录
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
