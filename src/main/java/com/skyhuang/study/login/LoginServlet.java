package com.skyhuang.study.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 登陆重定向
 * Created by hk on 2017/9/9.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问LoginServlet");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("admin".equals(username) && "admin".equals(password)){
            response.getWriter().write("login success");
            //重定向到页面刷新页面。
            response.sendRedirect("/response/refresh.html");
        } else {
            //不起作用
            /*response.setStatus(302);
            response.setHeader("localhost","response/login.html");*/
            //重定向到登陆界面。
            response.sendRedirect("/response/login.html");
        }
    }
}
