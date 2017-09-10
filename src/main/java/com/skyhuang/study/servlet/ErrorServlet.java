package com.skyhuang.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hk on 2017/9/1.
 */
public class ErrorServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("这是错误界面！由自己配置的/路径代替tomcat默认的路径!!!");
        /*<servlet-mapping>
            <servlet-name>ErrorServlet</servlet-name>
            <url-pattern>/</url-pattern><!-- 这个路径会代替tomcat的默认报错路径  一般不要使用 -->
          </servlet-mapping>*/
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
