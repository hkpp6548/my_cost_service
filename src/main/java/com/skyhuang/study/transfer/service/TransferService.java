package com.skyhuang.study.transfer.service;

import com.skyhuang.study.jdbc.JdbcUtils;
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
		try {
			connection = JdbcUtils.getConnection();
			connection.setAutoCommit(false);//开启手动事物
			transferDao.rollOut(connection, accountout,money);
			transferDao.rollIn(connection, accountin, money);
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
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
