package cn.skyhuang.estore.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 请求转发帮助类
 * Created by dahoufang the one on 2017/11/3.
 */
public class RequestSendUtiles {

    /**
     *  请求转发
     * @param pathName  需要转发的页面 "regist_success.jsp"
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void requestForward(String pathName, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(request.getContextPath() + "/" + pathName).forward(request, response);
    }

    /**
     *  请求重定向
     * @param pathName 需要重定向的页面 "regist_success.jsp"
     * @param request
     * @param response
     * @throws IOException
     */
    public static void requestRedirect(String pathName, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect(request.getContextPath() + "/" + pathName);
    }

}
