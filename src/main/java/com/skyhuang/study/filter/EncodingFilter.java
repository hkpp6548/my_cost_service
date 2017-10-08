package com.skyhuang.study.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hk on 2017/10/3.
 */
public class EncodingFilter implements Filter{

    private String encode;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.encode = filterConfig.getInitParameter("encode");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse respone = (HttpServletResponse)servletResponse;
        //设置操作
        request.setCharacterEncoding(encode);
        //放行
        filterChain.doFilter(request, respone);
    }

    public void destroy() {

    }
}
