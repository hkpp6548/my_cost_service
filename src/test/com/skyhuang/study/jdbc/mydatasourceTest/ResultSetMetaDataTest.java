package com.skyhuang.study.jdbc.mydatasourceTest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.*;

/**
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
			//preparedStatement.setString(1,"in");
			ParameterMetaData metaData = preparedStatement.getParameterMetaData();

			ResultSet resultSet = preparedStatement.getResultSet();




		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}