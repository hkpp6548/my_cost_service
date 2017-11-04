package cn.skyhuang.estore.web.servlet.old;

import cn.skyhuang.estore.domain.Product;
import cn.skyhuang.estore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/** 通过商品id查找商品
 * Created by dahoufang the one on 2017/10/31.
 */
@WebServlet(name = "FindProductByIdServlet", urlPatterns = "/findProductById")
public class FindProductByIdServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*// 1.得到商品id
        String id = request.getParameter("id");
        // 2.调用service,dao完成查询商品操作
        ProductService service = new ProductService();
        try {
            Product p = service.findById(id);
            // 将p存储到request域，请求转发到productInfo.jsp页面，展示 商品信息.
            request.setAttribute("p", p);
            String imgurl = p.getImgurl();//图片真实路径
            int subnum = imgurl.lastIndexOf(".");
            String pathName = imgurl.substring(0, subnum);
            String newName = pathName + "_s" + imgurl.substring(subnum);
            request.setAttribute("img_s",newName);
            request.getRequestDispatcher("/productInfo.jsp").forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
