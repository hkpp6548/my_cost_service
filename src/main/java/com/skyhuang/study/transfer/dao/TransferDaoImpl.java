package com.skyhuang.study.transfer.dao;

import com.skyhuang.study.transfer.exception.TransferException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by dahoufang the one on 2017/9/19.
 */
public class TransferDaoImpl implements TransferDao {

	public void rollIn(Connection connection, String account, Double money) throws SQLException, TransferException {
		String sql = "update account set money=money+?where account=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDouble(1, money);
		preparedStatement.setString(2, account);
		int row = preparedStatement.executeUpdate();
		if(row == 0){
			throw new TransferException("转入失败");
		}
		preparedStatement.close();
	}

	public void rollOut(Connection connection, String account, Double money) throws SQLException, TransferException {
		String sql = "update account set money=money-?where account=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDouble(1, money);
		preparedStatement.setString(2, account);
		int row = preparedStatement.executeUpdate();
		if(row == 0){
			throw new TransferException("转出失败");
		}
		preparedStatement.close();
	}
}
