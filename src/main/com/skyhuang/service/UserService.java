package com.skyhuang.service;

import com.skyhuang.dao.UserDao;
import com.skyhuang.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hk on 2017/11/18.
 */
public class UserService {
    // 登录操作
    public User login(String logonName, String logonPwd) throws SQLException {
        return new UserDao().findUserByNameAndPwd(logonName, logonPwd);
    }

    public List<User> findAll() throws SQLException {
        return new UserDao().findAll();
    }

    public void addUser(User user) throws SQLException {
        new UserDao().addUser(user);
    }

    public List<User> findBySelect(User user) throws SQLException {
        return new UserDao().findBySelect(user);
    }

    public User findById(int userID) throws SQLException {
        return new UserDao().findById(userID);
    }

    public void delById(int userID) throws SQLException {
        new UserDao().delById(userID);
    }
}
