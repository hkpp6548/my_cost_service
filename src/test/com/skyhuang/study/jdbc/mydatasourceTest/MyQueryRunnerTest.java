package com.skyhuang.study.jdbc.mydatasourceTest;

import com.skyhuang.domain.Account;
import com.skyhuang.study.jdbc.DataSourceUtils;
import com.skyhuang.study.jdbc.MyBeanHandler;
import com.skyhuang.study.jdbc.MyQueryRunner;
import com.skyhuang.study.jdbc.MyResultSetHandler;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dahoufang the one on 2017/9/25.
 */
public class MyQueryRunnerTest {
	// 测试update方法
	@Test
	public void updateTest() throws SQLException {
		String sql = "delete from account where id=?";
		MyQueryRunner mqr = new MyQueryRunner();
		mqr.update(DataSourceUtils.getConnection(), sql, 4);
	}

	// 测试select
	@Test
	public void selectTest() throws SQLException {
		String sql = "select * from account where id=?";
		MyQueryRunner mqr = new MyQueryRunner();
		Account a=mqr.query(DataSourceUtils.getConnection(), sql,
				new MyResultSetHandler<Account>() {
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

	//测试MyBeanHandler
	@Test
	public void beanHandlerTest() throws SQLException{
		String sql = "select * from account where id=?";
		MyQueryRunner mqr = new MyQueryRunner();
		Account a= (Account) mqr.query(DataSourceUtils.getConnection(), sql,
				new MyBeanHandler(Account.class), 2);
		System.out.println(a);
	}
}
