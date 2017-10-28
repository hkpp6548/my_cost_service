package cn.skyhuang.estore.service;

import cn.skyhuang.estore.dao.UserDao;
import cn.skyhuang.estore.domain.User;

import java.sql.SQLException;

/**
 * Created by dahoufang the one on 2017/10/28.
 */
public class UserService {

    public void add(User user) throws SQLException {
        UserDao dao = new UserDao();
        dao.add(user);
    }
}
