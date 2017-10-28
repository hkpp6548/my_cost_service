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

    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    public static DataSource getDataSource() {
        return cpds;
    }

}
