package com.sky.soso.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class VolidLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //获取HttpServletRequest对象
        HttpServletRequest request = (HttpServletRequest) req;
        //获取登录名
        Object loginUser = request.getSession().getAttribute("loginUser");
        //获取请求连接
        String requestURI = request.getRequestURI();
        if (loginUser!=null || requestURI.indexOf("login")>=0 ||
                requestURI.indexOf("register")>=0 || requestURI.indexOf("index")>=0) {
            //只要登录过或者正在进行的登录,注册,主页请求,则不拦截
            chain.doFilter(request, resp);
        } else {
            //拦截请求并返回登录页面
            request.getRequestDispatcher("/somejsp/login.jsp").forward(request,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
