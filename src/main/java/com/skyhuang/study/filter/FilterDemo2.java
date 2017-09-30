package com.skyhuang.study.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by dahoufang the one on 2017/9/30.
 */
public class FilterDemo2 implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
		String filterName = filterConfig.getFilterName();
		System.out.println("过滤器名称：" + filterName);
		String encoding = filterConfig.getInitParameter("encoding");
		System.out.println("初始化参数名称：" + encoding);
		Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
		while (initParameterNames.hasMoreElements()){
			String s = initParameterNames.nextElement();
			String initParameter = filterConfig.getInitParameter(s);
			System.out.println("初始化参数名称2：" + initParameter);
		}
		ServletContext servletContext = filterConfig.getServletContext();
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		System.out.println("FilterDemo2 start");
		filterChain.doFilter(servletRequest,servletResponse);
		System.out.println("FilterDemo2 end ..");
	}

	public void destroy() {

	}
}
