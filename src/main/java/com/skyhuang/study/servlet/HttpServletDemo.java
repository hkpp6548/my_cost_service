package com.skyhuang.study.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** service 执行顺序
 * Created by hk on 2017/8/29.
 */
public class HttpServletDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //执行顺序2;
        System.out.println("HttpServletDemo service(HttpServletRequest) ");
        super.service(req, resp);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //执行顺序1;
        System.out.println("HttpServletDemo service(ServletRequest) ");
        super.service(req, res);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //执行顺序3;
        System.out.println("HttpServletDemo doGet()");
        resp.getWriter().write("HttpServletDemo doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HttpServletDemo doPost()");
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        //<load-on-startup>1</load-on-startup> 配置后服务器启动 这个servlet就会进行初始化。
        System.out.println("HttpServletDemo init()");
    }
}
