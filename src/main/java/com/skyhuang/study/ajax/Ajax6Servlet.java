package com.skyhuang.study.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by dahoufang the one on 2017/10/23.
 */
@WebServlet(name = "Ajax6Servlet", urlPatterns = "/ajax6servlet")
public class Ajax6Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String realPath = request.getServletContext().getRealPath("/study/ajax/person.xml");
        FileInputStream fis = new FileInputStream(realPath);

        OutputStream os = response.getOutputStream();

        int len = -1;
        byte[] b = new byte[1024];

        while ((len = fis.read(b)) != -1) {
            os.write(b, 0, len);
            os.flush();
        }
        fis.close();
        os.close();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
