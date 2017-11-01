package cn.skyhuang.estore.web.servlet;

import cn.skyhuang.estore.domain.Product;
import cn.skyhuang.estore.service.ProductService;
import cn.skyhuang.estore.utils.DownloadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/11/1.
 */
@WebServlet(name = "DownloadServlet", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 完成下载榜单操作

        // 1.得到数据.
        ProductService service = new ProductService();
        try {
            List<Product> ps = service.downloadSell();

            // 2.设置下载两个条件
            String filename = "销售榜单" + new Date().toLocaleString() + ".csv";
            response.setContentType(this.getServletContext().getMimeType(filename));

            response.setHeader(
                    "content-disposition",
                    "attachment;filename="
                            + DownloadUtils.getDownloadFileName(
                            request.getHeader("user-agent"), filename));

            response.setCharacterEncoding("gbk");// 设置响应编码，因为我们要返回的csv文件要使用excel打开，它默认的编码就是gbk.

            PrintWriter out = response.getWriter();

            out.println("商品名称,商品数量");

            for (Product p : ps) {
                out.println(p.getName() + "," + p.getTotalSaleNum());
                out.flush();
            }
            out.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
