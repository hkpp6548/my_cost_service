package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 删除订单
 * Created by dahoufang the one on 2017/11/1.
 */
@WebServlet(name = "DelOrderServlet", urlPatterns = "/delOrder")
public class DelOrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.得到要删除的订单的id
        String id = request.getParameter("orderid");

        // 2.调用service完成删除订单操作
        OrderService service = new OrderService();

        service.delOrderById(id);

        // 3.删除完成后，查询订单.
        response.sendRedirect(request.getContextPath() + "/showOrder");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
