package com.skyhuang.study.transfer.dao;

import com.skyhuang.study.transfer.exception.TransferException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by dahoufang the one on 2017/9/19.
 */
public interface TransferDao {

	public void rollIn(Connection connection,String account,Double money) throws SQLException, TransferException;

	public void rollOut(Connection connection,String account,Double money) throws SQLException, TransferException;

	public void rollInByThreadLocal(String account, Double money) throws SQLException, TransferException;

	public void rollOutByThreadLocal(String account, Double money) throws SQLException, TransferException;

}
