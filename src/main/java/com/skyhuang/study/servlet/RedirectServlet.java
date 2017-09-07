package com.skyhuang.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 重定向
 * Created by hk on 2017/9/7.
 */
@WebServlet(name = "RedirectServlet",urlPatterns = "/redirectServlet")
public class RedirectServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //向页面输出内容
        response.setContentType("text/html;charset=utf-8");//设置中文乱码的问题。
        System.out.println("访问RedirectServlet");
        //response.getWriter().write("向班长借钱!");
        //没钱
        response.setStatus(302);
        //告诉我富班长的地址
        response.setHeader("localhost","/test/index.jsp");
    }
}
