package com.skyhuang.study.jdbc;

import com.skyhuang.utils.PropertyUtils;

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



}
