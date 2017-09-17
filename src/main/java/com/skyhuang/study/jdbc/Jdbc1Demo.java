package com.skyhuang.study.jdbc;

import java.sql.*;

/** jdbc使用实例
 * Created by hk on 2017/8/31.
 */
public class Jdbc1Demo {

    private static final String URL = "jdbc:mysql://localhost:3306/testone?useSSL=false&characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    /**
     * 最初始版查询示例
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void queryDemo()throws SQLException, ClassNotFoundException{
        // 1.注册驱动
        //DriverManager.deregisterDriver(new Driver());//加载了两个驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过连接对象获取操作sql语句Statement
        Statement statement = connection.createStatement();
        //4.操作sql语句
        String sql = "select * from a";
        //5.操作sql语句(select语句),会得到一个ResultSet结果集
        ResultSet resultSet = statement.executeQuery(sql);
        //6遍历结果集
        while (resultSet.next()){
            String aid = resultSet.getString("aid");
            String bid = resultSet.getString("bid");
            String bid2 = resultSet.getString("bid2");
            System.out.println("aid:"+ aid + "，bid:"+bid+"，tenant:"+bid2);
        }
        //7.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }

    /**
     * jdbc更新操作
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void updateDemo()throws SQLException, ClassNotFoundException{
        // 1.注册驱动
        //DriverManager.deregisterDriver(new Driver());//加载了两个驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接对象
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过连接对象获取操作sql语句Statement
        Statement statement = connection.createStatement();
        //4.操作sql语句
        String sql = "update a SET bid='222' where aid='1'";
        //5.操作sql语句(select语句),会得到一个ResultSet结果集
        int i = statement.executeUpdate(sql);
        System.out.println(i);
        //7.释放资源
        statement.close();
        connection.close();
    }

    /**
     * 使用JdbcUtils进行查询示例
     */
    public static void queryDemo2(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            statement =  connection.createStatement();
            String sql = "select * from a";
            resultSet = statement.executeQuery(sql);
            //6遍历结果集
            while (resultSet.next()){
                String aid = resultSet.getString("aid");
                String bid = resultSet.getString("bid");
                String bid2 = resultSet.getString("bid2");
                System.out.println("aid:"+ aid + "，bid:"+bid+"，tenant:"+bid2);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //7.释放资源
            try {
                JdbcUtils.closeResultSet(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                JdbcUtils.closeStatement(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                JdbcUtils.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用JdbcUtils和PreparedStatement进行查询。
     */
    public static void queryDemo3(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            String sql = "SELECT * FROM a WHERE aid = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,"111");
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("查询成功，有数据");
            }else{
                System.out.println("没有数据");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.closeResultSet(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                JdbcUtils.closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用JdbcUtils进行插入操作
     */
    public static void insertDemo(){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JdbcUtils.getConnection();
            statement =  connection.createStatement();
            String sql = "INSERT INTO a VALUES ('111','111','111')";
            int i = statement.executeUpdate(sql);
            if (i != 0 ) {
                System.out.println("添加成功！");
            } else {
                System.out.println("添加失败！");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                //7.释放资源
                JdbcUtils.closeStatement(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                JdbcUtils.closeConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
