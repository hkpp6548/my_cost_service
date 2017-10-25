package com.skyhuang.study.designMode.proxy.demo1;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 动态代理实现编码转换（实际中不这么开发）
 * Created by dahoufang the one on 2017/10/25.
 */
@WebFilter(filterName = "Encoding3Filter",urlPatterns = "/login1")
public class Encoding3Filter implements Filter {


    public void doFilter(final ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强转
        final HttpServletRequest requests = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //操作
        // 创建一个req对象的代理对象reqProxy
        HttpServletRequest proxyRequest = (HttpServletRequest)Proxy.newProxyInstance(requests.getClass().getClassLoader(), requests.getClass().getInterfaces(),
                new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 1.得到方法名称
                String name = method.getName();
                if("getParameter".equals(name)){
                    String parameter = requests.getParameter((String) (args[0]));
                    return new String(parameter.getBytes("iso8859-1"), "utf-8");
                }else{
                    // 不是getParameter方法，就执行其原来操作.
                    return method.invoke(requests,args);
                }
            }
        });
        //放行
        chain.doFilter(proxyRequest, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }
    public void destroy() {

    }

}
