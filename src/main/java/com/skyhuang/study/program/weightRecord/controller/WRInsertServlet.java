package com.skyhuang.study.program.weightRecord.controller;

import com.skyhuang.study.program.weightRecord.domain.WeightRecord;
import com.skyhuang.study.program.weightRecord.service.WeightRecordService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by dahoufang the one on 2017/9/25.
 */
@WebServlet(name = "WRInsertServlet",urlPatterns = "/weightRecord/insert")
public class WRInsertServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		WeightRecord wr = new WeightRecord();
		DateConverter dc = new DateConverter(); // 这是一个日期类型转换器.
		dc.setPattern("yyyy-MM-dd");
		try {
			ConvertUtils.register(dc, java.util.Date.class);
			BeanUtils.populate(wr, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		WeightRecordService service = new WeightRecordService();
		try {
			service.insert(wr);
			System.out.println("新增成功！");
			response.sendRedirect("/weightRecord/list");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("新增失败！");
			response.getWriter().write("新增失败！");
		}

	}
}
