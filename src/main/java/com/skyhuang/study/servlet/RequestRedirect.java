package com.skyhuang.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dahoufang the one on 2017/9/11.
 */
@WebServlet(name = "RequestRedirect",urlPatterns = "/requestRedirect")
public class RequestRedirect extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("name","testAttribute");

        //response.sendRedirect("test/requestDemo1");
        request.getRequestDispatcher("/requestDemo1").forward(request, response);


    }
}
