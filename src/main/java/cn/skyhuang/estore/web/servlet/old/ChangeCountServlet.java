package cn.skyhuang.estore.web.servlet.old;

import cn.skyhuang.estore.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/** 改变购物车中的商品数量
 * Created by dahoufang the one on 2017/10/31.
 */
@WebServlet(name = "ChangeCountServlet", urlPatterns = "/changeCount")
public class ChangeCountServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*// 1.得到请求参数
        String id = request.getParameter("id");
        int count = Integer.parseInt(request.getParameter("count"));
        // 2.修改购物车中指定商品的数量.
        // 2.1得到购物车
        Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        // 2.2.修改购物车中商品数量
        Product p = new Product();
        p.setId(id);
        if (count == 0) {
            // 删除商品
            cart.remove(p);
        } else {
            cart.put(p, count);
//            Map的put 的流程是：
//（1）检查key是否为空
//（2）计算key的hashcode和在table里面的index（位置）
//（3）找到table上面的元素
//（4）遍历链表，如果没有就put进去，有就更新（更新值）
        }
        response.sendRedirect(request.getContextPath() + "/showCart.jsp");*/
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
