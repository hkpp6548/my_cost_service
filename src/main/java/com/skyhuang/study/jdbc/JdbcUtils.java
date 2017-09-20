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

    /**
        ThreadLocal可以理解成是一个Map集合
        Map<Thread,Object>
        set方法是向ThreadLocal中存储数据，那么当前的key值就是当前线程对象.
        get方法是从ThreadLocal中获取数据，它是根据当前线程对象来获取值。
        如果我们是在同一个线程中，只要在任意的一个位置存储了数据，在其它位置上，就可以获取到这个数据。
     */
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    static {
        DRIVERCLASS = PropertyUtils.getPropertyValue("datasrc.properties","driverClassName");
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

    /**
     * 获取Connection
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * 通过ThreadLocal在一个线程中获取相同的线程
     * @return
     * @throws SQLException
     */
    public static Connection getConnectionByThreadLocal() throws SQLException {
        Connection connection = threadLocal.get();
        if(connection == null){
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            threadLocal.set(connection);
            return threadLocal.get();
        }
        return connection;
    }

    /**
     * 关闭Connection
     * @param connection
     * @throws SQLException
     */
    public static void closeConnection(Connection connection) throws SQLException {
        if(connection != null) {
            connection.close();
        }
    }

    /**
     * 关闭Statement
     * @param statement
     * @throws SQLException
     */
    public static void closeStatement(Statement statement) throws SQLException {
        if(statement != null){
            statement.close();
        }
    }

    /**
     * 关闭ResultSet
     * @param resultSet
     * @throws SQLException
     */
    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        if(resultSet != null){
            resultSet.close();
        }
    }

    /**
     * 关闭PreparedStatement
     * @param preparedStatement
     * @throws SQLException
     */
    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if(preparedStatement != null){
            preparedStatement.close();
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
