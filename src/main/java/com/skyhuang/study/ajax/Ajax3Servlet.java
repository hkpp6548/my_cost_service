package com.skyhuang.study.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/23.
 */
@WebServlet(name = "Ajax3Servlet", urlPatterns = "/ajax3servlet")
public class Ajax3Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        List<String> names = new ArrayList<String>();
        names.add("tom");
        names.add("fox");
        names.add("james");
        names.add("张三");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");

        if (names.contains(username)) {
            out.print("<font color='red'>用户名不可使用</font>");
        } else {
            out.print("<font color='green'>用户名可以使用</font>");
        }
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
