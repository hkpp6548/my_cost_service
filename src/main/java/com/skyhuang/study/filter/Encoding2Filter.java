package com.skyhuang.study.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/** 全局编码过滤
 * Created by hk on 2017/10/9.
 */
@WebFilter(filterName = "Encoding2Filter",urlPatterns = "/*")
public class Encoding2Filter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        //设置操作
        //request.setCharacterEncoding(encode);
        //使用装饰设计模式对request进行功能增强
        HttpServletRequest myrequest = new MyHttpRequest(request); // 增强后的request,解决了编码问题
        response.setContentType("text/html;charset=utf-8");
        //放行
        chain.doFilter(myrequest, response);
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
/**
 *  装饰模式
 *  装饰步骤：
 *      1.装饰类与被装饰类要实现同一个接口或继承同一个父类。
 *      2.在装饰类中持有一个被装饰类的引用。
 *      3.重写方法，进行功能增强。
 * */
class MyHttpRequest extends HttpServletRequestWrapper{

    private HttpServletRequest request;

    /**
     * 开关-不重复进行编码转换
     */
    private boolean flag = true;

    public MyHttpRequest(HttpServletRequest request){
        //HttpServletRequestWrapper没有无参构造，需要指定构造方法。
        super(request);
        this.request = request;
    }

    //重写3个参数方法
    @Override
    public String getParameter(String name) {
        if(name == null){
            return null;
        }
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        if(values == null || values.length == 0){
            return null;
        }
        return values[0];
    }

    @Override
    public String[] getParameterValues(String name) {
        if(name == null){
            return null;
        }
        Map<String, String[]> parameterMap = getParameterMap();
        String[] strings = parameterMap.get(name);
        return strings;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if(flag){
            for (String key: parameterMap.keySet()) {
                String[] values = parameterMap.get(key);
                for (int i = 0; i < values.length; i++) {
                    try {
                        values[i] = new String(values[i].getBytes("iso8859-1"),"utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
            flag = false;
        }
        return super.getParameterMap();
    }

}
