package com.skyhuang.study.ajax;

import com.skyhuang.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/23.
 */
@WebServlet(name = "Ajax4Servlet", urlPatterns = "/ajax4servlet")
public class Ajax4Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Product> ps = new ArrayList<Product>();
        ps.add(new Product(1, "洗衣机", 1800));
        ps.add(new Product(2, "电视机", 3800));
        ps.add(new Product(3, "空调", 5800));

        //request.setAttribute("ps", ps);

        //request.getRequestDispatcher("/study/ajax/product.jsp").forward(request, response);

        PrintWriter out = response.getWriter();

        StringBuilder builder = new StringBuilder();

        builder.append("<table border='1'><tr><td>商品编号</td><td>商品名称</td><td>商品价格</td></tr>");
        for (Product p : ps) {
            builder.append("<tr><td>" + p.getId() + "</td><td>" + p.getName()
                    + "</td><td>" + p.getPrice() + "</td></tr>");
        }

        builder.append("</table>");

        out.print(builder.toString());
        out.flush();
        out.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
