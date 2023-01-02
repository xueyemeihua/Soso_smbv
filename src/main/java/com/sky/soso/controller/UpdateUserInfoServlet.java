package com.sky.soso.controller;

import com.sky.soso.pojo.User;
import com.sky.soso.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //对用户输入的信息进行判断,是否符合规范(在js中使用AJAX完成)
        //获取用户输入信息
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String cardid = request.getParameter("cardid");
        //获取用户登录信息
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser!=null) {
            UserService service = new UserService();
            int result = service.updateUserInfo(name,phone,cardid,loginUser.getUid());
            //修改成功,跳转到用户界面前,更新loginUser
            User user = service.getUserByUid(loginUser.getUid());
            request.getSession().setAttribute("loginUser",user);
            request.getRequestDispatcher("/userView.jsp").forward(request,response);
        } else {
            //重新登录
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
