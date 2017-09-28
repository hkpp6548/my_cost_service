package com.skyhuang.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**  页面定时刷新  last-modefied	和 if-modefied-since和304状态码一起来控制缓存。
 * Created by hk on 2017/9/7.
 */
@WebServlet(name = "RefreshServlet",urlPatterns = "/refreshServlet")
public class RefreshServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//设置中文乱码的问题。
        response.getWriter().write("访问到了RefreshServlet!");
        System.out.println("访问到了RefreshServlet!");
        //页面5秒会跳转
        response.setHeader("refresh","5;url=/index.jsp");
    }
}
