package com.skyhuang.study.jdbc.mydatasourceTest;

import com.skyhuang.domain.Account;
import com.skyhuang.study.jdbc.DataSourceUtils;
import com.skyhuang.study.jdbc.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** dbutils-简单的jdbc封装工具
 * Created by hk on 2017/9/24.
 */
public class DbutilsTest {

    //查询
    @Test
    public void selectTest(){
        String sql = "select * from account";
        QueryRunner queryRunner = new QueryRunner();
        try {
            /*List<Account> accounts = queryRunner.query(JdbcUtils.getConnection(), sql, new ResultSetHandler<List<Account>>() {
                public List<Account> handle(ResultSet resultSet) throws SQLException {
                    List<Account> accountList = new ArrayList<Account>();
                    while (resultSet.next()){
                        Account account = new Account();
                        account.setId(resultSet.getInt("id"));
                        account.setAccount(resultSet.getString("account"));
                        account.setMoney(resultSet.getDouble("money"));
                        accountList.add(account);
                    }
                    return accountList;
                }
            });*/
            List<Account> accounts = queryRunner.query(JdbcUtils.getConnection(), sql,
                    new BeanListHandler<Account>(Account.class));
            for (Account acc: accounts) {
                System.out.println(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into account(id,account,money) values (null,?,?)";
        int skyhuang = queryRunner.update(JdbcUtils.getConnection(), sql, "skyhuang", 1000d);
        if(skyhuang > 0){
            System.out.println("插入成功！");
        }
    }

    @Test
    // 使用无参数 的QueryRunner
    public void fun1() throws SQLException {
        String sql = "select * from account where id>? and name=? ";
        QueryRunner runner = new QueryRunner(); // 事务手动控制
        Connection con = DataSourceUtils.getConnection();
        // con.setAutoCommit(false);
        List<Account> list = runner.query(con, sql, new BeanListHandler<Account>(Account.class),2,"ccc");
        // con.rollback();
        //DbUtils.close(con);
        System.out.println(list);
    }

    @Test
    // 使用有参数 的QueryRunner
    public void fun2() throws SQLException {
        String sql = "select * from account where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource()); // 自动事务
        List<Account> list = runner.query(sql, new BeanListHandler<Account>(Account.class),2);
        System.out.println(list);
    }

}
