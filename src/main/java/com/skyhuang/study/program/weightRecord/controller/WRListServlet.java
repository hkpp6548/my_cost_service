package com.skyhuang.study.program.weightRecord.controller;

import com.skyhuang.domain.WebPager;
import com.skyhuang.study.program.weightRecord.utils.CheckSessionUser;
import com.skyhuang.study.program.weightRecord.utils.StaticStringUtils;
import com.skyhuang.study.program.weightRecord.domain.User;
import com.skyhuang.study.program.weightRecord.domain.WeightRecord;
import com.skyhuang.study.program.weightRecord.service.WeightRecordService;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/** 体重记录列表
 * Created by hk on 2017/9/25.
 */
@WebServlet(name = "WRListServlet",urlPatterns = "/weightRecord/list")
public class WRListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证用户信息
        //游客可以查看列表
        //CheckSessionUser.checkUser(request, response);

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;chartset=utf-8");
        //调用服务
        WeightRecordService service = new WeightRecordService();
        //分页 （可在前端判断）
        String currentPage = request.getParameter("currentPage");
        if(StringUtils.isEmpty(currentPage)){
            currentPage = "1";
        }
        WebPager pager = new WebPager();
        pager.setCurrentPage(Integer.parseInt(currentPage));
        String pageSize = request.getParameter("pageSize");
        if(StringUtils.isEmpty(pageSize)){
            pageSize = "5";
        }
        pager.setPageSize(Integer.parseInt(pageSize));

        try {
            List<WeightRecord> weightRecords = service.selectAll(pager);
            request.setAttribute("wr",weightRecords);
            request.setAttribute("pager",pager);
            request.getRequestDispatcher("/program/weightRecord/weight_record_list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("获取体重信息失败！");
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
