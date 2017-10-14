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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/** 简单的文件上传
 * Created by hk on 2017/10/12.
 */
@WebServlet(name = "FileUpload1Servlet",urlPatterns ="/fileUpload1Servlet" )
public class FileUpload1Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.创建 DiskFileItemFactory
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2.创建
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            // 底层通过request获取数据，进行解析，将解析的数据封装到List<FileItem>
            List<FileItem> fileItems = upload.parseRequest(request);
            for (FileItem item: fileItems) {
                if(item.isFormField()){//非上传组件
                    // 这就是得到了<input type="text" name="content">这样的组件
//                     String fieldName = item.getFieldName();
//                     System.out.println(fieldName);
//
//                     String name = item.getName();
//                     System.out.println(name);
//
//                     String msg = item.getString();
//                     System.out.println(msg);
                }else{//上传的组件 这就是得到了<input type="file"> 这样的组件.
                    // 获取页面组件的name <input name="">
                    String fieldName = item.getFieldName();
                    System.out.println("上传组件的名称:" + fieldName);
                    //上传的文件名称 eg:account.txt
                    String name = item.getName(); // 上传文件名称
                    System.out.println(name);
                    //全路径时进行截取
                    name = name.substring(name.lastIndexOf("\\") + 1);
                    System.out.println("上传组件:" + name);
                    //获取内容
                    String msg = item.getString();
                    System.out.println(msg);

                    // 获取上传文件内容,完成文件 上传操作
                    InputStream is = item.getInputStream();
                    /*byte[] b = new byte[1024];
                    int len = -1;*/
                    String contextPath = request.getSession().getServletContext().getRealPath("/");
                    FileOutputStream fos = new FileOutputStream(contextPath + "/study/fileUpload/file/"
                            + name);

                    /*while((len = is.read(b)) != -1){
                        fos.write(b, 0 ,len);
                    }
                    fos.close();
                    is.close();*/

                    IOUtils.copy(is, fos);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
