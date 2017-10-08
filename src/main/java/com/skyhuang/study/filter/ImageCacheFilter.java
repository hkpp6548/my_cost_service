package com.skyhuang.study.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hk on 2017/10/3.
 */
@WebFilter(filterName = "ImageCacheFilter",urlPatterns = "*.bmp")
public class ImageCacheFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setDateHeader("expires", System.currentTimeMillis()+60*60*24*10*1000);//缓存10天
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
