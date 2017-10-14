package com.skyhuang.study.fileUpload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/14.
 */
@WebServlet(name = "FileUpload2Servlet", urlPatterns = "/fileUpload2Servlet")
public class FileUpload2Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 1.创建 DiskFileItemFactory
        // DiskFileItemFactory factory = new DiskFileItemFactory(); //使用默认的.
        File file = new File(request.getServletContext().getRealPath("/temp"));// 获取temp目录部署到tomcat后的绝对磁盘路径
        DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 10, file); // 使用默认的.
        // 2.创建ServletFileUpload
        ServletFileUpload upload = new ServletFileUpload(factory);
        boolean flag = upload.isMultipartContent(request); // 用于判断是否是上传操作.
        if (flag) {
            // 解决上传文件名称中文乱码
            upload.setHeaderEncoding("utf-8");
            // 设置上传文件大小
            //upload.setSizeMax(1024 * 1024 * 10);// 总大小为10m
            try {
                List<FileItem> items = upload.parseRequest(request);// 解决request,得到所有的上传项FileItem
                // 3.得到所有上传项
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        // 非上传组件
                        System.out.println("组件名称:" + item.getFieldName());
                        System.out.println("内容:" + item.getString("utf-8")); // 解决乱码问题
                    } else {
                        // 上传组件
                        System.out.println("组件名称:" + item.getFieldName());
                        System.out.println("上传文件名称:" + item.getName());

                        String name = item.getName(); // 上传文件名称
                        System.out.println(name);
                        name = name.substring(name.lastIndexOf("\\") + 1);
                        String contextPath = request.getSession().getServletContext().getRealPath("/");
                        //io帮助类
                        IOUtils.copy(item.getInputStream(), new FileOutputStream(contextPath + "/study/fileUpload/file/" + name));
                        // 删除临时文件
                        item.delete();
                    }
                }
            } catch (FileUploadException e) {
                // e.printStackTrace();
                response.getWriter().write(e.getMessage());
                return;
            }
        } else {
            response.getWriter().write("不是上传操作");
            return;
        }
    }
}
