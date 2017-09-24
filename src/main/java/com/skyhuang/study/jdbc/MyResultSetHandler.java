package com.skyhuang.study.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hk on 2017/9/24.
 */
public interface MyResultSetHandler <T> {
    public T handle(ResultSet rs) throws SQLException;
}
