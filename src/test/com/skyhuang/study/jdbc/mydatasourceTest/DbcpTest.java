package com.skyhuang.study.jdbc.mydatasourceTest;

import com.skyhuang.utils.PropertyUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/** dbcp连接池测试
 * Created by hk on 2017/9/21.
 */
public class DbcpTest {
    // 1.手动配置
    @Test
    public void test1() throws SQLException {
        BasicDataSource bds = new BasicDataSource();
        // 需要设置连接数据库最基本四个条件
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/testone?useSSL=false&characterEncoding=utf-8");
        bds.setUsername("root");
        bds.setPassword("root");
        // 得到一个Connection
        Connection con = bds.getConnection();
        ResultSet rs = con.createStatement().executeQuery("select * from account");
        while (rs.next()) {
            System.out.println(rs.getString("account") + "  " + rs.getDouble("money"));
        }
        rs.close();
        con.close(); // 将Connection对象重新装入到连接池.
    }

    // 2.自动配置
    @Test
    public void test2() throws Exception {
        //Properties props = new Properties();
        // props.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        // props.setProperty("url", "jdbc:mysql:///day18");
        // props.setProperty("username", "root");
        // props.setProperty("password", "abc");
       /* FileInputStream fis = new FileInputStream(
                "D:\\java1110\\workspace\\day18_2\\src\\dbcp.properties");
        props.load(fis);*/
        Properties properties = PropertyUtils.getProperties("datasrc.properties");
        DataSource ds = BasicDataSourceFactory.createDataSource(properties);
        // 得到一个Connection
        Connection con = ds.getConnection();
        ResultSet rs = con.createStatement().executeQuery( "select * from account");
        while (rs.next()) {
            System.out.println(rs.getString("account") + "  " + rs.getDouble("money"));
        }
        rs.close();
        con.close(); // 将Connection对象重新装入到连接池.
    }
}
