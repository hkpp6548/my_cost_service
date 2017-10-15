package com.skyhuang.study.fileDownload;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/** 服务器端下载
 * Created by hk on 2017/10/15.
 */
@WebServlet(name = "FileDownload1Servlet", urlPatterns = "/fileDownload1Servlet")
public class FileDownload1Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.得到要下载 的文件名称
        String filename = request.getParameter("filename");

        //filename = new String(filename.getBytes("iso8859-1"), "utf-8");// 解决中文乱码

        File file = new File(request.getServletContext().getRealPath("/study/fileDownload/file/" + filename));
        if(file.exists()){// /文件存在，完成下载
            // 下载注意事项1--设置下载文件的mimeType
            String mimeType = request.getServletContext().getMimeType(filename);
            response.setContentType(mimeType);

            String agent = request.getHeader("user-agent");
            if (agent.contains("MSIE")) {
                // IE浏览器
                filename = URLEncoder.encode(filename, "utf-8");

            } else if (agent.contains("Firefox")) {
                // 火狐浏览器
                BASE64Encoder base64Encoder = new BASE64Encoder();
                filename = "=?utf-8?B?"
                        + base64Encoder.encode(filename.getBytes("utf-8"))
                        + "?=";
            } else {
                // 其它浏览器
                filename = URLEncoder.encode(filename, "utf-8");
            }
            // 下载注意事项2--永远是下载
            response.setHeader("content-disposition","attachment;filename=" + filename);
            // 读取要下载文件的内容
            FileInputStream is = new FileInputStream(file);
            // 将要下载的文件内容通过输出流写回到浏览器端.
            ServletOutputStream os = response.getOutputStream();
            byte [] b = new byte[1024 * 100];
            int len = -1;
            while((len = is.read(b)) != -1){
                os.write(b, 0, len);
            }
        }else{
            System.out.println("文件不存在");
            throw new RuntimeException("文件不存在");
        }
    }
}
