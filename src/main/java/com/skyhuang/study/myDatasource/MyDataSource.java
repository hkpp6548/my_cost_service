package com.skyhuang.study.myDatasource;

import com.skyhuang.study.jdbc.JdbcUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.*;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**	简单的自定义连接池
 * Created by dahoufang the one on 2017/9/20.
 */
public class MyDataSource implements DataSource{
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
		final Connection con = conns.removeFirst();

		Connection proxyCon = (Connection) Proxy.newProxyInstance(con
						.getClass().getClassLoader(), con.getClass().getInterfaces(),
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if ("close".equals(method.getName())) {

							// 这代表是close方法，它要做的事情是将con对象重新装入到集合中.

							conns.add(con);
							System.out.println("重新将连接对象装入到集合中");

							return null;

						} else {
							return method.invoke(con, args);// 其它方法执行原来操作
						}
					}
				});
		return proxyCon;
	}

	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}

	public void addConnection(Connection conn){
		conns.add(conn);
	}

	public int getConnSize(){
		System.out.println("连接池连接个数：" + conns.size());
		return conns.size();
	}


	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {

	}

	public void setLoginTimeout(int seconds) throws SQLException {

	}

	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
}
