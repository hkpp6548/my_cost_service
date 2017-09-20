package com.skyhuang.study.myDatasource;

import com.skyhuang.study.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by dahoufang the one on 2017/9/20.
 */
public class MyDataSource {
	//存储连接对象的容器
	LinkedList<Connection> conns = new LinkedList<Connection>();

	public MyDataSource() throws SQLException {
		// 当创建MyDateSource对象时，会向ll中装入5个Connection对象。
		for (int i = 0; i < 5; i++) {
			Connection connection = JdbcUtils.getConnection();
			conns.add(connection);
		}
	}

	public Connection getConnection() throws SQLException {
		if(conns.isEmpty()){
			for (int i = 0; i < 3; i++) {
				Connection connection = JdbcUtils.getConnection();
				conns.add(connection);
			}
		}
		Connection connection = conns.removeFirst();
		return connection;
	}

	public void addConnection(Connection conn){
		conns.add(conn);
	}

	public int getConnSize(){
		System.out.println("连接池连接个数：" + conns.size());
		return conns.size();
	}


}
