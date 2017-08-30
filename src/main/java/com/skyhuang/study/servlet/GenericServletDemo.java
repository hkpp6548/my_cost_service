package com.skyhuang.study.servlet;

import javax.servlet.*;
import java.io.IOException;

/** init();执行顺序
 * 先执行有参数init,后执行无参数init();
 * Created by hk on 2017/8/29.
 */
public class GenericServletDemo extends GenericServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("有参数init()...");
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("无参数init()...");
        super.init();
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServletDemo service()...");
        servletResponse.getWriter().write("GenericServletDemo");
    }
}
