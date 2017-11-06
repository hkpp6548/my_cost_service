/*
package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.domain.Order;
import cn.skyhuang.estore.domain.OrderItem;
import cn.skyhuang.estore.domain.Product;
import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.service.OrderItemService;
import cn.skyhuang.estore.service.OrderService;
import cn.skyhuang.estore.utils.StringStaticUtils;
import cn.skyhuang.estore.utils.UuidUtils;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

*/
/** 订单控制器
 * Created by dahoufang the one on 2017/11/4.
 *//*

@WebServlet(name = "OldOrderServlet", urlPatterns = "old/order")
public class OldOrderServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter(StringStaticUtils.PARAM_METHOD);
        if("add".equals(method)){           //生成订单
            add(request, response);
        } else if("showOrder".equals(method)){  //查看订单
            showOrder(request, response);
        } else if("findProductByOrderId".equals(method)){   //查找订单中的所有商品
            findProductByOrderId(request, response);
        } else if("delete".equals(method)){            //删除订单
            delete(request, response);
        }
    }

    */
/**
     *  根据订单id删除订单
     * @param request
     * @param response
     * @throws IOException
     *//*

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.得到要删除的订单的id
        String id = request.getParameter("orderid");
        // 2.调用service完成删除订单操作
        OrderService service = new OrderService();
        service.delOrderById(id);
        // 3.删除完成后，查询订单.
        response.sendRedirect(request.getContextPath() + "/order?method=showOrder");
    }

    */
/**
     *  查找订单中的所有商品
     * @param request
     * @param response
     * @throws IOException
     *//*

    public void findProductByOrderId(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.得到要查询的订单的id
        String orderid = request.getParameter("id");

        // 2.调用service,得到List<Product>
        OrderItemService service = new OrderItemService();
        try {
            List<Product> ps = service.findProductByOrderId(orderid);

            // 3.将ps转换成json
            // 设置json只包含name,price,description
            JsonConfig config = new JsonConfig();

            config.setExcludes(new String[] { "id", "category", "pnum", "imgurl", "imgurl_s" });
            String json = JSONArray.fromObject(ps, config).toString();

            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    */
/**
     *  查看订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *//*

    public void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.得到当前用户
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
        }
    }

    */
/**
     *  生成订单
     * @param request
     * @param response
     * @throws IOException
     *//*

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
        response.getWriter().write("订单生成成功，<a href='"+request.getContextPath()+"/order?method=showOrder'>查看订单</a>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
*/
