package com.skyhuang.study.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by dahoufang the one on 2017/8/30.
 */
public class HttpServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext
        ServletContext servletContext = getServletContext();
        //getInitParameter()
        String eccoding = servletContext.getInitParameter("encoding");
        System.out.println("getInitParameter eccoding:" + eccoding);
        //getInitParameterNames()
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = servletContext.getInitParameter(name);
            System.out.println("getInitParameterNames :" + name +"-value:"+value);
        }
        int showCount = 1;
        Object count = servletContext.getAttribute("count");
        if (count == null) {
            servletContext.setAttribute("count",1);
        } else {
            Integer count1 = (Integer) count;
            servletContext.setAttribute("count",++count1);
            showCount = count1;
            System.out.println("被访问：" + count1 + "次");
        }
        //read5();
       // read2();

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("ServletContextServlet:被访问" + showCount + "次。");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("count",0);
    }


    /**
     * 通过ServletContext对象获取文件的绝对磁盘路径
     * 获取src目录下文件
     * @throws IOException
     */
    public void read5() throws IOException{
        // 获取对象
        String path = getServletContext().getRealPath("/WEB-INF/classes/db.properties");
        // System.out.println(path);
        // C:\apache-tomcat-6.0.14\webapps\day09\WEB-INF\classes\db.properties
        System.out.println("运行时路径：" + path);
        // 获取输入流
        InputStream in = new FileInputStream(path);
        print(in);
    }

    /**
     * 在控制台打印内容
     * @param in
     * @throws IOException
     */
    public void print(InputStream in) throws IOException{
        Properties pro = new Properties();
        // 加载
        pro.load(in);
        pro.setProperty("test","34");
        OutputStream out = new FileOutputStream("E:\\ePLD\\my\\myServlet\\out\\artifacts\\myServlet_war_exploded\\WEB-INF\\classes\\db.properties");
        pro.store(out, "test");//写入参数
        out.close();
        // 获取文件中的内容
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");
        String desc = pro.getProperty("desc");

        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("描述："+desc);
    }

    /**
     * 获取src目录下db.properties文件
     * @throws IOException
     */
    public void read2() throws IOException{
        // ServletContext读取文件
        InputStream in = getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        // 打印方式
        print(in);
    }
}
