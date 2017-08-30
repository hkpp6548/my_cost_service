package com.skyhuang.study.servlet;

import javax.servlet.*;
import java.io.IOException;

/** 实现Servlet接口
 *  生命周期
 * Created by hk on 2017/8/29.
 */
public class ServletDemo implements Servlet{
    /**
     *  Servlet实例被创建后，调用init方法进行初始化
     * 	Servlet什么时候被创建呢？
     * 		* 不是服务器一启动时，实例被创建，第一次访问的时候，实例才被创建(也可以服务启动的时候创建)。
     * 	init方法调用几次呢？
     * 		* 只被调用一次。
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletDemo init()...");
    }
    /**
     * service调用几次呢？
     * 	* 有一次请求，调用一次service方法
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("ServletDemo service()...");
        servletResponse.getWriter().write("hello ServletDemo");
    }
    /**
     * Servlet实例什么时候被销毁呢？
     * 	* 服务器关闭，手动移除。
     * 	destroy调用几次呢？
     * 	* 一次
     */
    public void destroy() {
        System.out.println("ServletDemo destroy()...");
    }

    public ServletConfig getServletConfig() {
        return null;
    }
    public String getServletInfo() {
        return null;
    }
}
