package com.skyhuang.study.filter.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hk on 2017/10/3.
 */
@WebServlet(name = "Demo1Servlet",urlPatterns = "/filter/demo1")
public class Demo1Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setCharacterEncoding("utf-8");
        //过滤器已经统一处理了请求编码的问题。
        String username = request.getParameter("username");
        String msg = request.getParameter("msg");
        System.out.println("用户名：" + username);
        System.out.println("信息：" + msg);
        //通过过滤器来设置输出编码。
        //response.setCharacterEncoding("utf-8");
        //response.setContentType("text/hmtl;charset=utf-8");
        response.getWriter().write("查看成功！");
    }
}
