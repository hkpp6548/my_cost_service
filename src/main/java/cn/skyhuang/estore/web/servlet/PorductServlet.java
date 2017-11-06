package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.domain.Product;
import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.service.OldProductService;
import cn.skyhuang.estore.service.ProductService;
import cn.skyhuang.estore.service.ProductServiceFactory;
import cn.skyhuang.estore.utils.RequestSendUtiles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/** 商品控制器（id查找, 查找所有）；
 * Created by dahoufang the one on 2017/11/6.
 */
@WebServlet(name = "PorductServlet", urlPatterns = "/product")
public class PorductServlet extends BaseServlet {
    /**
     *  查找所有商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        // 1.查询所有商品
        //OldProductService service = new OldProductService();
        ProductService service = ProductServiceFactory.getInstance();
        try {
            List<Product> ps = service.findAll(user);
            //2.将所有商品存储到request域。
            request.setAttribute("ps", ps);
            RequestSendUtiles.requestForward("home.jsp", request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据商品id查找商品
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        // 1.得到商品id
        String id = request.getParameter("id");
        // 2.调用service,dao完成查询商品操作
        //OldProductService service = new OldProductService();
        ProductService service = ProductServiceFactory.getInstance();
        try {
            Product p = service.findById(user, id);
            // 将p存储到request域，请求转发到productInfo.jsp页面，展示 商品信息.
            request.setAttribute("p", p);
            String imgurl = p.getImgurl();//图片真实路径
            //缩略图
            int subnum = imgurl.lastIndexOf(".");
            String pathName = imgurl.substring(0, subnum);
            String newName = pathName + "_s" + imgurl.substring(subnum);
            request.setAttribute("img_s", newName);
            RequestSendUtiles.requestForward("productInfo.jsp", request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
