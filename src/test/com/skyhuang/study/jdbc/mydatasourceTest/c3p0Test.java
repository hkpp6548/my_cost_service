package com.skyhuang.study.jdbc.mydatasourceTest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hk on 2017/9/21.
 */
public class c3p0Test {
    @Test
    public void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/testone?useSSL=false&characterEncoding=utf-8");
        cpds.setUser("root");
        cpds.setPassword("root");
        // 得到一个Connection
        Connection con = cpds.getConnection();
        ResultSet rs = con.createStatement().executeQuery("select * from account");
        while (rs.next()) {
            System.out.println(rs.getString("account") + "  " + rs.getDouble("money"));
        }
        rs.close();
        con.close(); // 将Connection对象重新装入到连接池.
    }

    @Test
    public void test2() throws PropertyVetoException, SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        // 得到一个Connection
        Connection con = cpds.getConnection();
        ResultSet rs = con.createStatement().executeQuery("select * from account");
        while (rs.next()) {
            System.out.println(rs.getString("account") + "  " + rs.getDouble("money"));
        }
        rs.close();
        con.close(); // 将Connection对象重新装入到连接池.
        // String path = this.getClass().getResource("/").getPath();
        // System.out.println(path);
    }
}
