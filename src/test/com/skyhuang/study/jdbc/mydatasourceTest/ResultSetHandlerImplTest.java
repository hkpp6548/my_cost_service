package com.skyhuang.study.jdbc.mydatasourceTest;

import com.skyhuang.domain.Account;
import com.skyhuang.study.jdbc.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by hk on 2017/9/24.
 */
public class ResultSetHandlerImplTest {
    // ArrayHandler
    @Test
    public void fun1() throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        Object[] obj = runner
                .query("select * from account", new ArrayHandler());

        System.out.println(Arrays.toString(obj));
    }

    // ArrayListHandler
    @Test
    public void fun2() throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        List<Object[]> objs = runner.query("select * from account",
                new ArrayListHandler());

        for (Object[] obj : objs) {
            System.out.println(Arrays.toString(obj));
        }
    }

    // BeanHandler
    @Test
    public void fun3() throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        Account obj = runner.query("select * from account",
                new BeanHandler<Account>(Account.class));

        System.out.println(obj);
    }

    // BeanListHandler
    @Test
    public void fun4() throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        List<Account> obj = runner.query("select * from account",
                new BeanListHandler<Account>(Account.class));

        System.out.println(obj);
    }

    // ColumnListHandler
    @Test
    public void fun5() throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        List<Object> obj = (List<Object>) runner.query("select * from account",
                new ColumnListHandler("name"));

        System.out.println(obj);
    }

    // MapHandler
    @Test
    public void fun6() throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        Map<String, Object> obj = runner.query("select * from account",
                new MapHandler());

        System.out.println(obj);
    }

    // MapListHandler
    @Test
    public void fun7() throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        List<Map<String, Object>> obj = runner.query("select * from account",
                new MapListHandler());

        System.out.println(obj);
    }

    //KeyedHandler

    @Test
    public void fun8() throws SQLException {

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        Map<Object,Map<String,Object>> obj = (Map<Object, Map<String, Object>>) runner.query("select * from account",
                new KeyedHandler("name"));

        System.out.println(obj);
    }

    //ScalarHandler
    @Test
    public void fun9() throws SQLException{
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        long obj = (Long) runner.query("select count(*) from account",new ScalarHandler());

        System.out.println(obj);
    }
}
