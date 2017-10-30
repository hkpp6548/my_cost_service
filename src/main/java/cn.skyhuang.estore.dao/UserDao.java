package cn.skyhuang.estore.dao;

import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.utils.DataSourceUtils;
import cn.skyhuang.estore.utils.Md5Utils;
import cn.skyhuang.estore.utils.StringStaticUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/** 用户dao
 * Created by dahoufang the one on 2017/10/28.
 */
public class UserDao {

    public void add(User user) throws SQLException {
        String sql = "INSERT INTO user values (null,?,?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, user.getUsername(), Md5Utils.md5(user.getPassword()), user.getNickname(), user.getEmail(), user.getRole(), user.getState(), user.getActivecode(),user.getUpdatetime());
    }

    public User selectUserByActiveCode(String activeCode) throws SQLException {
        String sql = "SELECT * FROM user WHERE activecode = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class), activeCode);
    }

    public void activeUser(String activeCode) throws SQLException {
        String sql = "UPDATE user set state = ? WHERE activecode = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, StringStaticUtils.USER_STATE_1, activeCode);
    }

    public User selectUserByUsername(User user) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class), user.getUsername());
    }

    public User selectUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE username=? and password =?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<User>(User.class), username, Md5Utils.md5(password));
    }
}
