/*
package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.domain.Product;
import cn.skyhuang.estore.service.ProductService;
import cn.skyhuang.estore.utils.RequestSendUtiles;
import cn.skyhuang.estore.utils.StringStaticUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

*/
/** 购物车控制器(新增 修改 删除)
 * Created by dahoufang the one on 2017/11/3.
 *//*

@WebServlet(name = "OldCartServlet", urlPatterns = "old/cart")
public class OldCartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            String method = request.getParameter(StringStaticUtils.PARAM_METHOD);
            if ("add".equals(method)) {             //新增
                add(request, response);
            } else if("changeNum".equals(method)){   //修改数量
                changeNum(request, response);
            } else if("remove".equals(method)){     //删除商品
                remove(request, response);
            } else if("removeSelect".equals(method)){//删除选中商品
                removeSelect(request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    */
/**
     *  从购物车中删除选中的商品
     * @param request
     * @param response
     * @throws IOException
     *//*

    public void removeSelect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //选中商品的id
        String[] id = request.getParameterValues("id");
        Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        for (int i = 0; i < id.length; i++) {
            Product p = new Product();
            p.setId(id[i]);
            cart.remove(p);
        }
        RequestSendUtiles.requestRedirect("showCart.jsp", request, response);
    }

    */
/**
     *  从购物车中删除某种商品
     * @param request
     * @param response
     * @throws IOException
     *//*

    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 得到要删除的商品的id
        String id = request.getParameter("id");
        // 得到购物车，从购物车中将商品删除,
        Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        Product p = new Product();
        p.setId(id);
        cart.remove(p);
        //如果购物车中无商品，将购物车删除。
        if (cart.size() == 0) {
            request.getSession().removeAttribute("cart");
        }
        RequestSendUtiles.requestRedirect("showCart.jsp", request, response);
    }

    */
/**
     *  更改购物车中已有商品的数量
     * @param request
     * @param response
     * @throws IOException
     *//*

    public void changeNum(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.得到请求参数
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
        // Map的put 的流程是：
        //（1）检查key是否为空
        //（2）计算key的hashcode和在table里面的index（位置）
        //（3）找到table上面的元素
        //（4）遍历链表，如果没有就put进去，有就更新（更新值）
        }
        RequestSendUtiles.requestRedirect("showCart.jsp", request, response);
    }

    */
/**
     *  添加商品到购物车
     * @param request
     * @param response
     * @throws IOException
     *//*

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1.得到商品id
        String id = request.getParameter("id");
        // 2.根据id查询商品
        ProductService service = new ProductService();
        try {
            Product p = service.findById(id);
            // 3.将商品添加到购物车
            HttpSession session = request.getSession();
            // 从session中获取购物车
            Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
            // 如果cart为null,说明，没有购物车，是第一次购物
            if (cart == null) {
                // 创建出购物车
                cart = new HashMap<Product, Integer>();
            }
            // 判断购物车中是滞有当前要买的商品
            Integer count = cart.get(p);
            if (count == null) {
                // 如果为null,说明购物车中没有这个商品，这时商品的数量就为1
                count = 1;
            } else {
                // 如果不为null,说明购物车中有这个商品，这时，就将商品的数量+1
                count += 1;
            }
            // 将商品存储到购物车中
            cart.put(p, count);
            // 将购物车存储到session中.
            session.setAttribute("cart", cart);
            response.getWriter().write("添加商品到购物车成功，<a href='" + StringStaticUtils.HOME_PATH + "'>继续购物</a>," +
                    "<a href='" + StringStaticUtils.HOME_PATH + "/showCart.jsp'>查看购物车</a>");
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
*/
