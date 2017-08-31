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
        //getInitParameter() 获取全局初始化对象
        String eccoding = servletContext.getInitParameter("encoding");
        System.out.println("getInitParameter eccoding:" + eccoding);
        //getInitParameterNames()
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = servletContext.getInitParameter(name);
            System.out.println("getInitParameterNames :" + name +"-value:"+value);
        }
        int count = (Integer)servletContext.getAttribute("count");
        // 存入到域对象中
        servletContext.setAttribute("count", ++count);
        read5();
       // read2()
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("HttpServletContextDemo被访问,总被访问次数：" + count);
        // 页面1秒会跳转
        //resp.setHeader("refresh", "1;url=/httpServletConfigDemo");
        //和location和302一起完成重定向
        resp.setStatus(302);
        // 告诉我富班长的地址
        resp.setHeader("location", "/httpServletConfigDemo");
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
        // 获取需要读取文件的路径
        //servletContext.getRealPath("/");此时会获取编译后web文件夹的路径
        String path = getServletContext().getRealPath("/WEB-INF/classes/test.properties");
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
        //在Java中，配置文件常为.properties文件,格式为文本文件，文件的内容的格式是“键=值”的格式，文本注释信息可以用"#"来注释。
        //可以用Properties类可以用来读取。
        //1． getProperty ( String key)，用指定的键在此属性列表中搜索属性。也就是通过参数 key ，得到 key 所对应的 value。
        //2． load ( InputStream inStream)，从输入流中读取属性列表（键和元素对）。
        // 通过对指定的文件（比如说上面的 test.properties 文件）进行装载来获取该文件中的所有键 - 值对。以供 getProperty ( String key) 来搜索。
        //3． setProperty ( String key, String value) ，调用 Hashtable 的方法 put 。他通过调用基类的put方法来设置 键 - 值对。
        //4． store ( OutputStream out, String comments)，以适合使用 load 方法加载到 Properties 表中的格式，
        // 将此 Properties 表中的属性列表（键和元素对）写入输出流。与 load 方法相反，该方法将键 - 值对写入到指定的文件中去。
        //5． clear ()，清除所有装载的 键 - 值对。该方法在基类中提供。
        Properties pro = new Properties();
        pro.load(in);
        in.close();
        Enumeration<Object> keys = pro.keys();
        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String propertyValue = pro.getProperty(key);
            System.out.println("key:"+key+",value:"+propertyValue);
        }
        pro.setProperty("test1","34");
        String realPath = getServletContext().getRealPath("/WEB-INF/classes/test.properties");
        OutputStream out = new FileOutputStream(realPath);
        pro.store(out, "test1");//写入参数
        out.close();
    }

    /**
     * 获取src目录下db.properties文件
     * @throws IOException
     */
    public void read2() throws IOException{
        // ServletContext读取文件 getServletContext().getResourceAsStream();直接获取输入流。
        InputStream in = getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        // 打印方式
        print(in);
    }
}
