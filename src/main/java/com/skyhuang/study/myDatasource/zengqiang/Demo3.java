package com.skyhuang.study.myDatasource.zengqiang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 通过动态代理增强方法的功能
 * Created by hk on 2017/9/20.
 */
public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testone?useSSL=false&characterEncoding=utf-8", "root", "root");
        Connection conProxy = (Connection) Proxy.newProxyInstance(connection.getClass().getClassLoader(), connection.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(connection,args);
                    }
                });
        System.out.println(conProxy);
    }
}
