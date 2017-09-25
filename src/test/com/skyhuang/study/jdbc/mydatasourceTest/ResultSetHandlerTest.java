package com.skyhuang.study.jdbc.mydatasourceTest;

import com.skyhuang.domain.Account;
import com.skyhuang.study.jdbc.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hk on 2017/9/24.
 */
public class ResultSetHandlerTest {

    // 将结果封装到一个javaBean
    @Test
    public void fun1() throws SQLException {

        String sql = "select * from account where id=?";

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        Account a = runner.query(sql, new ResultSetHandler<Account>() {//ResultSetHandler上的泛型就是我们执行query方法后得到的结果.

            //重写handle方法，在这个方法中确定，怎样将结果集封装。
            public Account handle(ResultSet rs) throws SQLException {
                Account a = null;
                if (rs.next()) {
                    a = new Account();
                    a.setId(rs.getInt("id"));
                    a.setAccount(rs.getString("account"));
                    a.setMoney(rs.getDouble("money"));
                }
                return a;
            }
        }, 2);

        System.out.println(a);
    }
}
