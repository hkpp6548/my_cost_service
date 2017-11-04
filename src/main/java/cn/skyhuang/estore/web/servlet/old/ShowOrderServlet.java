package cn.skyhuang.estore.web.servlet.old;

import cn.skyhuang.estore.domain.Order;
import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/** 查看订单    (未重构)
 * Created by dahoufang the one on 2017/10/31.
 */
@WebServlet(name = "ShowOrderServlet", urlPatterns = "/old/showOrder")
public class ShowOrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* // 1.得到当前用户
        User user = (User) request.getSession().getAttribute("user");

        // 2.调用OrderService完成查询订单操作
        OrderService service = new OrderService();
        try {
            List<Order> orders = service.findOrder(user);
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("/showOrder.jsp").forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
