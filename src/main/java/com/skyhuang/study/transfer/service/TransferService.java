package com.skyhuang.study.transfer.service;

import com.skyhuang.study.jdbc.Jdbc1Demo;
import com.skyhuang.study.jdbc.JdbcUtils;
import com.skyhuang.study.myDatasource.MyDataSource;
import com.skyhuang.study.transfer.dao.TransferDaoImpl;
import com.skyhuang.study.transfer.exception.TransferException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by dahoufang the one on 2017/9/19.
 */
public class TransferService {

	public void transfer(String accountin, String accountout, double money) throws TransferException {
		TransferDaoImpl transferDao = new TransferDaoImpl();
		Connection connection = null;
		MyDataSource myDataSource = null;
		try {
			myDataSource = new MyDataSource();
			//从自定义连接池中获取连接
			connection = myDataSource.getConnection();

			//connection = JdbcUtils.getConnection();
			connection.setAutoCommit(false);//开启手动事物
			transferDao.rollOut(connection, accountout,money);
			transferDao.rollIn(connection, accountin, money);

			//通过ThreadLocal，来获取相同的connection
			/*connection = JdbcUtils.getConnectionByThreadLocal();
			connection.setAutoCommit(false);
			transferDao.rollOutByThreadLocal(accountout,money);
			transferDao.rollInByThreadLocal(accountin, money);*/
		} catch (Exception e) {
			e.printStackTrace();
			if(connection != null){
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			throw new TransferException(e.getMessage());
		} finally {
			if(connection != null){
				try {
					connection.commit();
					//使用自定义连接池不关闭，放回连接池
					//myDataSource.addConnection(connection)
// Connection对象如果是从连接池中获取到的，那么它的close方法的行为已经改变了，不在是销毁，而是重新装入到连接池。
					connection.close();
					myDataSource.getConnSize();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
