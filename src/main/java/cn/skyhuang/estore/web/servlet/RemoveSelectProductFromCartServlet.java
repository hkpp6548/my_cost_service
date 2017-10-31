package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/** 从购物车中删除选中的商品
 * Created by dahoufang the one on 2017/10/31.
 */
@WebServlet(name = "RemoveSelectProductFromCartServlet", urlPatterns = "/removeSelectProductFromCart")
public class RemoveSelectProductFromCartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] id = request.getParameterValues("id");
        Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        for (int i = 0; i < id.length; i++) {
            Product p = new Product();
            p.setId(id[i]);
            cart.remove(p);
        }
        response.sendRedirect(request.getContextPath() + "/showCart.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
