package com.skyhuang.study.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 通过session检验验证码
 * Created by hk on 2017/9/14.
 */
@WebServlet(name = "CheckCodeServlet",urlPatterns = "/session/checkcode")
public class CheckCodeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置post请求缓冲区字符
        request.setCharacterEncoding("utf-8");
        //获取session
        String sessionCode = (String)request.getSession().getAttribute("code");
        //获取输入的验证码
        String code = request.getParameter("code");
        //校验成功
        if(null != sessionCode && sessionCode.equals(code)){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("succcess");
        }else {
            request.setAttribute("msg","验证码错误！");
            request.getRequestDispatcher("/session/login.jsp").forward(request,response);
        }
    }



}


