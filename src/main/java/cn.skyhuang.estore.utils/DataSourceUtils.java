package cn.skyhuang.estore.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/** 获取c3p0连接池以及数据库连接
 * Created by dahoufang the one on 2017/10/28.
 */
public class DataSourceUtils {

    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    public static DataSource getDataSource() {
        return cpds;
    }

    // 获取绑定到ThreadLocal中的Connection。
    public static Connection getConnectionByTransaction() throws SQLException {
        Connection con = tl.get();
        if (con == null) {
            con = cpds.getConnection();
            tl.set(con);
        }
        return con;
    }

    // 开启事务
    public static void startTransaction(Connection con) throws SQLException {
        if (con != null)
            con.setAutoCommit(false);
    }

    // 事务回滚
    public static void rollback(Connection con) throws SQLException {
        if (con != null)
            con.rollback();
    }

    public static void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            con.commit();// 事务提交
            con.close();
            tl.remove();
        }
    }

}
