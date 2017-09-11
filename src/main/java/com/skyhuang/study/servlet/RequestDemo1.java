package com.skyhuang.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dahoufang the one on 2017/9/11.
 */
@WebServlet(name = "RequestDemo1",urlPatterns = "/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取
        String value = (String) request.getAttribute("name");
        // 输出中文
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("访问到了requestDemo1... "+value);
    }
}
