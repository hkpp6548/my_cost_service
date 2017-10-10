package com.skyhuang.study.program.weightRecord.controller;

import com.skyhuang.study.program.weightRecord.domain.WeightRecord;
import com.skyhuang.study.program.weightRecord.service.WeightRecordService;
import com.skyhuang.study.program.weightRecord.utils.CheckSessionUser;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**	修改一条体重记录
 * Created by dahoufang the one on 2017/9/26.
 */
@WebServlet(name = "WRUpdateByIdServlet",urlPatterns = "/weightRecord/updateById")
public class WRUpdateByIdServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证用户信息
		CheckSessionUser.checkUser(request, response);

		response.setContentType("text/html;charset=utf-8");
		WeightRecord wr = new WeightRecord();
		DateConverter dc = new DateConverter(); // 这是一个日期类型转换器.
		dc.setPattern("yyyy-MM-dd");
		ConvertUtils.register(dc, java.util.Date.class);
		try {
			BeanUtils.populate(wr, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		WeightRecordService service = new WeightRecordService();
		try {
			service.updateById(wr);
			response.getWriter().write("修改成功,3秒后将跳到列表界面");
			response.setHeader("refresh","3;url=/weightRecord/list");
			//response.sendRedirect("/weightRecord/list");
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("修改失败,3秒后将跳到列表界面");
			response.setHeader("refresh","3;url=/weightRecord/list");
		}
	}
}
