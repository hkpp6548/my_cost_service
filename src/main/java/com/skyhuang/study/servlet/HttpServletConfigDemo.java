package com.skyhuang.study.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/** ServletConfig对象信息
 * Created by hk on 2017/8/30.
 */
public class HttpServletConfigDemo extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HttpServletConfigAndContext doGet() 数据处理！开始。");
        //获取ServletConfig对象
        ServletConfig servletConfig = getServletConfig();
        //获取Servlet名字
        String servletName = servletConfig.getServletName();
        System.out.println("Servlet名字 :" + servletName);
        //获取初始化参数
        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(name);
            System.out.println("参数名称："+name+",参数值："+value);
        }
        ServletContext servletContext = getServletContext();
        int count = (Integer)servletContext.getAttribute("count");
        servletContext.setAttribute("count",++count);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("HttpServletConfigDemo:被访问,总被访问次数：" + count);
        resp.setHeader("refresh", "1;url=/httpServletContextDemo");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("HttpServletConfigAndContext init();");
    }
}
