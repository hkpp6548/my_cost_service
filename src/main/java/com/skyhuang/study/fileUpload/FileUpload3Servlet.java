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
@WebServlet(name = "FileUpload3Servlet", urlPatterns = "/fileUpload3Servlet")
public class FileUpload3Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 1.创建 DiskFileItemFactory
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
                    if (!item.isFormField()) {
                        String name = item.getName(); // 上传文件名称
                        // 得到上传文件真实名称
                        String filename = FileUploadUtils.getRealName(name);
                        // 得到随机名称
                        String uuidname = FileUploadUtils.getUUIDFileName(filename);
                        // 得到随机目录
                        String randomDirectory = FileUploadUtils.getRandomDirectory(filename);
                        // 注意:随机目录可能不存在，需要创建.
                        String parentPath = this.getServletContext().getRealPath("/study/fileUpload/file");
                        File rd = new File(parentPath, randomDirectory);
                        if (!rd.exists()) {
                            rd.mkdirs();
                        }
                        IOUtils.copy(item.getInputStream(), new FileOutputStream(new File(rd, uuidname)));
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
