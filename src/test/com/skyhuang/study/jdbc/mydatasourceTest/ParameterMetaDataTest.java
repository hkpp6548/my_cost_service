package com.skyhuang.study.jdbc.mydatasourceTest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.*;

/** ParameterMetaData 参数元数据 主要用于获取:sql语句中占位符的相关信息.
 * Created by dahoufang the one on 2017/9/23.
 */
public class ParameterMetaDataTest {

	@Test
	public void parameterMetaDataTest(){
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			Connection connection = cpds.getConnection();
			String sql = "select * from account where account = ? and money = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setString(1,"in");
			ParameterMetaData metaData = preparedStatement.getParameterMetaData();
			int columnCount = metaData.getParameterCount();// 获取参数 个数
			int parameterType = metaData.getParameterType(1);//获取参数的类型
			String parameterTypeName = metaData.getParameterTypeName(1);//获取参数的类型
			System.out.println("参数个数：" + columnCount);
			System.out.println("参数类型：" + parameterType);
			System.out.println("参数类型：" + parameterTypeName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
