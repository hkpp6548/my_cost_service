package com.skyhuang.study.program.weightRecord.controller;

import com.skyhuang.study.program.weightRecord.domain.WeightRecord;
import com.skyhuang.study.program.weightRecord.service.WeightRecordService;
import com.skyhuang.study.program.weightRecord.utils.CheckSessionUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**	查找一条体重记录
 * Created by dahoufang the one on 2017/9/26.
 */
@WebServlet(name = "WRSelectByIdServlet",urlPatterns = "/weightRecord/selectById")
public class WRSelectByIdServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证用户信息
		CheckSessionUser.checkUser(request, response);

		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		WeightRecordService service = new WeightRecordService();

		try {
			WeightRecord wr = service.selectById(Integer.parseInt(id));
			request.setAttribute("wr", wr);
			request.getRequestDispatcher("/program/weightRecord/weight_record_update.jsp").forward(request,response);
			return;

		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("根据id查询失败！");
			return;
		}
	}
}
