package com.skyhuang.study.transfer.web;

import com.skyhuang.study.transfer.exception.TransferException;
import com.skyhuang.study.transfer.service.TransferService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 使用事物进行转账汇款操作
 * Created by dahoufang the one on 2017/9/19.
 */
@WebServlet(name = "TransferServlet",urlPatterns = "/transfer")
public class TransferServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String accountin = request.getParameter("accountin");
		String accountout = request.getParameter("accountout");
		String moneyStr = request.getParameter("money");
		double money = Double.parseDouble(moneyStr);
		TransferService transferService = new TransferService();

		try {
			transferService.transfer(accountin, accountout, money);
			response.getWriter().write("转账成功");
		} catch (TransferException e) {
			e.printStackTrace();
			response.getWriter().write("转账失败" + e.getMessage());
		}


	}
}
