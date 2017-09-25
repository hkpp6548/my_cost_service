package com.skyhuang.study.program.weightRecord.controller;

import com.skyhuang.study.program.weightRecord.domain.WeightRecord;
import com.skyhuang.study.program.weightRecord.service.WeightRecordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hk on 2017/9/25.
 */
@WebServlet(name = "WRListServlet",urlPatterns = "/weightRecord/list")
public class WRListServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;chartset=utf-8");
        WeightRecordService service = new WeightRecordService();
        try {
            List<WeightRecord> weightRecords = service.selectAll();
            request.setAttribute("wr",weightRecords);
            request.getRequestDispatcher("/program/weightRecord/weight_record_list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("获取体重信息失败！");
        }
    }
}
