package com.skyhuang.study.jdbc;

import com.skyhuang.study.Annotation.JdbcConnectionAnnotation;
import com.skyhuang.utils.PropertyUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ResourceBundle;

/** 使用配置文件保存数据库链接信息
 * Created by hk 2017/8/31.
 */
public class JdbcUtils {
    private static final String DRIVERCLASS;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        DRIVERCLASS = PropertyUtils.getPropertyValue("datasrc.properties","driver_class_name");
        URL = PropertyUtils.getPropertyValue("datasrc.properties","url");
        USERNAME = PropertyUtils.getPropertyValue("datasrc.properties","username");
        PASSWORD = PropertyUtils.getPropertyValue("datasrc.properties","password");
    }

    static {
        try {
            // 将加载驱动操作，放置在静态代码块中.这样就保证了只加载一次.
            Class.forName(DRIVERCLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if(connection != null) {
            connection.close();
        }
    }

    public static void closeStatement(Statement statement) throws SQLException {
        if(statement != null){
            statement.close();
        }
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        if(resultSet != null){
            resultSet.close();
        }
    }

    /**
     * 使用注解获取数据库连接信息
     * @return
     * @throws SQLException
     * @throws NoSuchMethodException
     */
    //@JdbcConnectionAnnotation
    @JdbcConnectionAnnotation(driverClass = "com.mysql.jdbc.Driver",
        url = "jdbc:mysql://localhost:3306/testone?useSSL=false&characterEncoding=utf-8",
        userName = "root",
        password = "root")
    public static Connection getConnectionByAnnotation() throws SQLException, NoSuchMethodException {
        //通过反射取出注解
        //1.获取Class对象
        Class<JdbcUtils> jdbcUtilsClass = JdbcUtils.class;
        //2.通过反射获取方法对象
        Method getConnectionByAnnotation = jdbcUtilsClass.getDeclaredMethod("getConnectionByAnnotation");
        //3.通过方法取得注解对象
        JdbcConnectionAnnotation annotation = getConnectionByAnnotation.getAnnotation(JdbcConnectionAnnotation.class);
        //4.通过注解的方法取出各个参数值
        String driverClass = annotation.driverClass();//驱动在加载类的时候静态代码块自动加载了，否则需要Class.forName(driverClass)先加载驱动
        String url = annotation.url();
        String userName = annotation.userName();
        String password = annotation.password();
        //5.获取连接
        return DriverManager.getConnection(url,userName,password);
    }



}
