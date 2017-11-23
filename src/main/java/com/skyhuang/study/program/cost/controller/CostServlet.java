package com.skyhuang.study.program.cost.controller;

import com.skyhuang.domain.WebPager;
import com.skyhuang.study.program.cost.domain.Cost;
import com.skyhuang.study.program.cost.service.CostService;
import com.skyhuang.study.program.weightRecord.domain.WeightRecord;
import com.skyhuang.study.program.weightRecord.service.WeightRecordService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/** cost控制器
 * Created by dahoufang the one on 2017/11/22.
 */
@WebServlet(name = "CostServlet", urlPatterns = "/cost")
public class CostServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;chartset=utf-8");
        String method = request.getParameter("method");
        if("list".equals(method)){
            list(request, response);
        } else if ("add".equals(method)){
            add(request, response);
        } else if ("selectById".equals(method)){
            selectById(request, response);
        }
    }

    private void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        CostService service = new CostService();

        Cost wr = null;
        try {
            wr = service.selectById(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("wr", wr);
        request.getRequestDispatcher("/program/cost/cost_update.jsp").forward(request,response);
        return;

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Cost cost = new Cost();
        DateConverter dc = new DateConverter(); // 这是一个日期类型转换器.
        dc.setPattern("yyyy-MM-dd");
        ConvertUtils.register(dc, java.util.Date.class);
        try {
            BeanUtils.populate(cost, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        CostService service = new CostService();
        try {
            service.insert(cost);
            System.out.println("新增成功！");
            response.sendRedirect("/cost?method=list");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("新增失败！");
            response.getWriter().write("新增失败！");
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
