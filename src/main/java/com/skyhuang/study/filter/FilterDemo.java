package com.skyhuang.study.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by dahoufang the one on 2017/9/30.
 */
public class FilterDemo implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("FilterDemo 进行拦截了");
		//放行
		filterChain.doFilter(servletRequest,servletResponse);
		System.out.println("FilterDemo end ...");
	}

	public void destroy() {

	}
}
