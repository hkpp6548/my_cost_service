package com.skyhuang.study.program.upDownload.controller;

import com.skyhuang.study.program.upDownload.domain.Resources;
import com.skyhuang.study.program.upDownload.service.UpDownloadService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/** 展示需要下载的文件控制器
 * Created by hk on 2017/10/17.
 */
@WebServlet(name = "ShowDownloadServlet",urlPatterns = "/showDownloadServlet")
public class ShowDownloadServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UpDownloadService service = new UpDownloadService();
        try {
            List<Resources> resources = service.selectAll();
            for(Resources rsc: resources){
                String savepath = rsc.getSavepath();
                String uuidname = rsc.getUuidname();
                savepath = savepath + "/" + uuidname;
                rsc.setSavepath(savepath);
            }
            request.setAttribute("downloads",resources);
            request.getRequestDispatcher("/program/upDownlaod/download.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
