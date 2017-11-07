package com.skyhuang.struts2.study.web.filter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 简单模拟struts2访问请求过程
 * Created by dahoufang the one on 2017/11/7.
 */
public class StrutsFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        // 1.强转
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 2.操作

        // 2.1 得到请求资源路径
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String path = uri.substring(contextPath.length() + 1);

        // System.out.println(path); // hello

        // 2.2 使用path去struts.xml文件中查找某一个<action name=path>这个标签
        SAXReader reader = new SAXReader();

        try {
            // 得到struts.xml文件的document对象。
            Document document = reader.read(new File(this.getClass()
                    .getResource("/struts.xml").getPath()));

            Element actionElement = (Element) document
                    .selectSingleNode("//action[@name='" + path + "']"); // 查找<action
            // name='hello'>这样的标签

            if (actionElement != null) {
                // 得到<action>标签上的class属性以及method属性
                String className = actionElement.attributeValue("class"); // 得到了action类的名称
                String methodName = actionElement.attributeValue("method");// 得到action类中的方法名称。

                // 2.3通过反射，得到Class对象，得到Method对象
                Class actionClass = Class.forName(className);
                Method method = actionClass.getDeclaredMethod(methodName);

                // 2.4 让method执行.
                String returnValue = (String) method.invoke(actionClass
                        .newInstance()); // 是让action类中的方法执行，并获取方法的返回值。

                // 2.5
                // 使用returnValue去action下查找其子元素result的name属性值，与returnValue做对比。
                Element resultElement = actionElement.element("result");
                String nameValue = resultElement.attributeValue("name");

                if (returnValue.equals(nameValue)) {
                    // 2.6得到了要跳转的路径。
                    String skipPath = resultElement.getText();

                    // System.out.println(skipPath);

                    request.getRequestDispatcher(skipPath).forward(request,
                            response);
                    return;
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // 3.放行
        chain.doFilter(request, response);

    }

    public void destroy() {

    }
}
