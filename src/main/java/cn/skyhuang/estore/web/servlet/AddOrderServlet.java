package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.domain.Order;
import cn.skyhuang.estore.domain.OrderItem;
import cn.skyhuang.estore.domain.Product;
import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.service.OrderService;
import cn.skyhuang.estore.utils.StringStaticUtils;
import cn.skyhuang.estore.utils.UuidUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** 生成订单项
 * Created by dahoufang the one on 2017/10/31.
 */
@WebServlet(name = "AddOrderServlet", urlPatterns = "/addOrder")
public class AddOrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order=new Order();
        try {
            BeanUtils.populate(order, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String id = UuidUtils.getUuid();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        order.setOrdertime(timestamp);
        order.setId(id);
        order.setPaystate(StringStaticUtils.ORDER_PAYSTATE_0);
        // 封装user_id
        // 从session中获取当前用户.
        User user = (User) request.getSession().getAttribute("user");
        int user_id = user.getId();
        order.setUser_id(user_id);

        // 将订单中的所有的订单项信息封装。
        List<OrderItem> items = new ArrayList<OrderItem>();
        //得到购物车
        Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        //遍历购物车
        for (Product p : cart.keySet()) {
            OrderItem item = new OrderItem(); //创建一个订单项
            item.setOrder_id(order.getId()); //向订单项中封装当前订单编号
            item.setProduct_id(p.getId()); //封装订单项中商品id
            item.setBuynum(cart.get(p));//封装订单项中的商品数量
            items.add(item);
        }
        order.setItems(items);
        //调用service中添加订单的方法
        OrderService service=new OrderService();
        service.addOrder(order);
        request.getSession().removeAttribute("cart");//生成订单后，将购物车中商品删除。
        response.getWriter().write("订单生成成功，<a href='"+request.getContextPath()+"/showOrder'>查看订单</a>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
