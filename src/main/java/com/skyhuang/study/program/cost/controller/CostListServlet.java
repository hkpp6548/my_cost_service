package com.skyhuang.study.program.cost.controller;

import com.skyhuang.domain.WebPager;
import com.skyhuang.study.program.cost.domain.Cost;
import com.skyhuang.study.program.cost.service.CostService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/** cost 列表页面
 * Created by hk on 2017/11/26.
 */
@WebServlet(name = "CostListServlet", urlPatterns = "/cost/list")
public class CostListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分页 （可在前端判断）
        String currentPage = request.getParameter("currentPage");
        if(StringUtils.isEmpty(currentPage)){
            currentPage = "1";
        }
        WebPager pager = new WebPager();
        pager.setCurrentPage(Integer.parseInt(currentPage));
        String pageSize = request.getParameter("pageSize");
        if(StringUtils.isEmpty(pageSize)){
            pageSize = "20";
        }
        pager.setPageSize(Integer.parseInt(pageSize));

        //调用服务
        CostService service = new CostService();

        try {
            List<Cost> costs = service.selectAll(pager);
            request.setAttribute("wr",costs);
            request.setAttribute("pager",pager);
            request.getRequestDispatcher("/program/cost/cost.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("获取体重信息失败！");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
