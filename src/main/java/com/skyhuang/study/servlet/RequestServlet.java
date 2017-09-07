package com.skyhuang.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 获取客户机的内容
 * Created by dahoufang the one on 2017/9/1.
 */
public class RequestServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取IP
        String ip = req.getRemoteAddr();
        // 获取请求方式
        String method = req.getMethod();
        // 获取虚拟路径
        String path = req.getContextPath();
        System.out.println("IP地址："+ip);
        System.out.println("请求方式："+method);
        System.out.println("虚拟路径名称："+path);

        // 获取请求头记住来源(防盗链)
        String referer = req.getHeader("referer");
        // 判断浏览器（文件下载）
        String agent = req.getHeader("user-agent");
        // 做操作
        System.out.println("请求头："+referer);
        System.out.println("判断浏览器："+agent);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("访问RequestServlet");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
