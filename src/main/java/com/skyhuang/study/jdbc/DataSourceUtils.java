package com.skyhuang.study.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hk on 2017/9/24.
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
