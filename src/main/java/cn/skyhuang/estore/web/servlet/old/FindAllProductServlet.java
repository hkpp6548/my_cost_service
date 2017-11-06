package cn.skyhuang.estore.web.servlet.old;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 查找所有商品  (未重构)
 * Created by dahoufang the one on 2017/10/31.
 */
@WebServlet(name = "FindAllProductServlet", urlPatterns = "/old/findAllProduct")
public class FindAllProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* // 1.查询所有商品
        ProductService service = new ProductService();
        try {
            List<Product> ps = service.findAll();
            //2.将所有商品存储到request域。
            request.setAttribute("ps", ps);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
