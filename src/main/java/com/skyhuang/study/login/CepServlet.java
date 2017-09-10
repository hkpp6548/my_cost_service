package com.skyhuang.study.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  禁用浏览器缓存
 * Created by hk on 2017/9/9.
 */
@WebServlet(name = "CepServlet",urlPatterns = "/cep")
public class CepServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /*
        禁用浏览器缓存（三个头信息）
		* 应用：网银。页面的数据是发送变化的。
            Cache-Control : no-cache
            Expires: -1					值是日期类型（setDateHeader()）
            Pragma : no-cache
            低版本的ie会有缓存
        */
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",-1);
        response.setHeader("Pragma","no-cache");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = sdf.format(date);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(format);
    }
}
