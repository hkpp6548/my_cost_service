package com.skyhuang.study.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dahoufang the one on 2017/9/12.
 */
@WebServlet(name = "JspServlet",urlPatterns = "/jspServlet")
public class JspServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JspServlet");
		response.getWriter().write("<form action='' method='post'>");
		response.getWriter().write("<input type='text' name='username'>");
	}
}
