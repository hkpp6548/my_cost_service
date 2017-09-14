package com.skyhuang.study.login;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/** 文件下载 已附件形式
 * Created by hk on 2017/9/9.
 */
@WebServlet(name = "DownloadServlet",urlPatterns = "/downloadServlet")
public class DownloadServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        download(request, response);
    }

    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 先获取到文件，读入输入流中
        // 获取文件的绝对磁盘路径
        String realPath = getServletContext().getRealPath("/img/girl.jpg");
        // 包含文件的名称	c:\tomcat\webapps\day10\img\girl7.jpg
        // 截取文件的名称	girl7.jpg
        int lastIndexOf = realPath.lastIndexOf("\\");
        String fileName = null;
        if(lastIndexOf != -1){
            fileName = realPath.substring(lastIndexOf + 1);
        }
        if(fileName != null){
            //设置头信息 文件以附件形式下载
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            //输入流
            FileInputStream inputStream = new FileInputStream(realPath);
            //输出到客户端
            ServletOutputStream outputStream = response.getOutputStream();
            byte [] bytes = new byte[1024];
            int len = 0;
            //io拷贝
            while ((len = inputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
            inputStream.close();
            //outputStream.close();//服务器管理流
        }

    }

}
