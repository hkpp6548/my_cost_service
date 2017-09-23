package com.skyhuang.study.jdbc.mydatasourceTest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.*;

/**`结果集元数据
 * Created by dahoufang the one on 2017/9/23.
 */
public class ResultSetMetaDataTest {
	@Test
	public void ResultSetMetaDataTest(){
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			Connection connection = cpds.getConnection();
			String sql = "select * from account";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet= preparedStatement.executeQuery(sql);
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();//获取结果集中列数量
			for (int i = 1; i <= columnCount; i++) {
				String columnName = metaData.getColumnName(i);//获取结果集中指定列的名称.
				String columnTypeName = metaData.getColumnTypeName(i);
				System.out.print(columnName + "("+columnTypeName+")" + "\t");
			}
			System.out.println();
			while (resultSet.next()){
				String id = resultSet.getString("id");
				String account = resultSet.getString("account");
				double money = resultSet.getDouble("money");
				System.out.println(account + "\t\t\t\t\t" + money + "\t\t\t\t" + id + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}