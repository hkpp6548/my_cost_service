package com.skyhuang.study.jdbc.mydatasourceTest;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 数据库元数据
 * Created by hk on 2017/9/22.
 */
public class DataBaseMetaDataTest {

    @Test
    public void dataBaseMetaDataTest(){
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            Connection connection = cpds.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
//            String driverName = metaData.getDriverName();//获去驱动名称
//            String url = metaData.getURL();//获取url
//            String userName = metaData.getUserName();//获取用户名
//            String databaseProductName = metaData.getDatabaseProductName(); //获取数据库名称
//            String databaseProductVersion = metaData.getDatabaseProductVersion();//获取数据库版本.
//            System.out.println("数据库驱动名称："+driverName);
//            System.out.println("数据库url名称："+url);
//            System.out.println("数据库用户名名称："+userName);
//            System.out.println("数据库名称："+databaseProductName);
//            System.out.println("数据库版本名称："+databaseProductVersion);
            ResultSet account = metaData.getPrimaryKeys(null, null, "account");
            while(account.next()){
                int index = 1;
                System.out.println(account.getObject(1));
                System.out.println(account.getObject(2));
                System.out.println(account.getObject(3));
                System.out.println(account.getObject(4));
                System.out.println(account.getObject(5));
                System.out.println(account.getObject(6));
                /*while(account.getObject(index) != null){
                    System.out.println(account.getObject(index));
                    index ++;
                }*/
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
