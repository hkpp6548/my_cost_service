package com.skyhuang.dao;

import com.skyhuang.domain.User;
import com.skyhuang.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hk on 2017/11/18.
 */
public class UserDao {

    public User findUserByNameAndPwd(String logonName, String logonPwd) throws SQLException {
        String sql = "select * from s_user where logonName=? and logonPwd=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class), logonName, logonPwd);
    }

    public List<User> findAll() throws SQLException {
        String sql = "select * from s_user";

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        return runner.query(sql, new BeanListHandler<User>(User.class));
    }

    public void addUser(User user) throws SQLException {
        String sql = "insert into s_user values(null,?,?,?,?,?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        runner.update(sql, user.getUserName(), user.getLogonName(),
                user.getLogonPwd(), user.getSex(), user.getBirthday(),
                user.getEducation(), user.getTelephone(), user.getInterest(),
                user.getPath(), user.getFilename(), user.getRemark());
    }

    public List<User> findBySelect(User user) throws SQLException {
        String sql = "select * from s_user where 1=1 ";
        List<Object> params = new ArrayList<Object>();
        String username = user.getUserName();
        if (username != null && username.trim().length() > 0) {
            sql += " and userName like ?";
            params.add("%" + username + "%");
        }
        String sex = user.getSex();
        if (sex != null && sex.trim().length() > 0) {
            sql += " and sex=?";
            params.add(sex);
        }
        String education = user.getEducation();
        if (education != null && education.trim().length() > 0) {
            sql += " and education=?";
            params.add(education);
        }

        String isupload = user.getIsUpload();
        if ("1".equals(isupload)) {
            sql += " and filename is not null";
        } else if ("2".equals(isupload)) {
            sql += " and filename is null";
        }

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        return runner.query(sql, new BeanListHandler<User>(User.class),
                params.toArray());
    }

    public User findById(int userID) throws SQLException {
        String sql = "select * from s_users where userID=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class), userID);
    }


    public void delById(int userID) throws SQLException {
        String sql = "delete from s_user where userID=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, userID);
    }
}
