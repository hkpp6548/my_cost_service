package com.skyhuang.study.program.upDownload.controller;

import com.skyhuang.study.fileUpload.FileUploadUtils;
import com.skyhuang.study.program.upDownload.domain.Resources;
import com.skyhuang.study.program.upDownload.service.UpDownloadService;
import com.skyhuang.utils.DateUtils;
import com.skyhuang.utils.PropertyUtils;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** 上传控制器
 * Created by dahoufang the one on 2017/10/16.
 */
@WebServlet(name = "UpDownloadServlet", urlPatterns = "/uploadServlet")
public class UpDownloadServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UpDownloadService service = new UpDownloadService();
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
            try {
                List<FileItem> items = upload.parseRequest(request);
                // 3.得到所有上传项
                Resources ress = new Resources();
                //上传组件集合
                List<FileItem> isFormFileds = new ArrayList<FileItem>();
                //非上传组件集合
                List<FileItem> isNotFormFileds = new ArrayList<FileItem>();
                for (FileItem item : items) {
                    if (!item.isFormField()) {//是上传组件
                        isFormFileds.add(item);
                        //获得上传组件name
                        String fieldName = item.getFieldName();
                        // 上传文件名称
                        String name = item.getName();
                        // 得到上传文件真实名称
                        String realname = FileUploadUtils.getRealName(name);
                        // 得到随机名称
                        String uuidname = FileUploadUtils.getUUIDFileName(realname);
                        // 得到随机目录
                        String randomDirectory = FileUploadUtils.getRandomDirectory(realname);
                        String parentPath = PropertyUtils.getPropertyValue("datasrc.properties", "myAlibabaLinuxPath");
                        // 注意:随机目录可能不存在，需要创建.
                        File rd = new File(parentPath, randomDirectory);
                        if (!rd.exists()) {
                            rd.mkdirs();
                        }
                        IOUtils.copy(item.getInputStream(), new FileOutputStream(new File(rd, uuidname)));
                        String savepath = parentPath + randomDirectory;
                        ress.setRealname(realname);
                        ress.setUuidname(uuidname);
                        ress.setSavepath(savepath);
                        ress.setUploadtime(DateUtils.getNowDate());

                        // 删除临时文件
                        item.delete();
                    }else {
                        isNotFormFileds.add(item);
                        String string = item.getString();
                        ress.setDescription(string);
                    }
                }
                for (FileItem isFile: isFormFileds) {//上传组件
                    for (FileItem isNotFile: isNotFormFileds) {
                        isFile.getFieldName();
                    }
                }
                try {
                    service.insert(ress);
                } catch (SQLException e) {
                    e.printStackTrace();
                    //添加记录失败 删除文件
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
                request.setAttribute("message",e.getMessage());
                request.getRequestDispatcher(request.getServletContext().getRealPath("/") + "/program/upDownlaod/upload.jsp").forward(request,response);
                return;
            }
        } else {
            response.getWriter().write("不是上传操作");
            return;
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
