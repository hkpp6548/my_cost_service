package cn.skyhuang.estore.web.servlet.old;

import cn.skyhuang.estore.domain.Product;
import cn.skyhuang.estore.service.OrderItemService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/11/1.
 */
@WebServlet(name = "findProductByOrderServlet", urlPatterns = "/findProductByOrder")
public class findProductByOrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*// 1.得到要查询的订单的id
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
        }*/
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
