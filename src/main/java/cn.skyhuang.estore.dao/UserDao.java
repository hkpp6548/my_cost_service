package cn.skyhuang.estore.dao;

import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * Created by dahoufang the one on 2017/10/28.
 */
public class UserDao {

    public void add(User user) throws SQLException {
        String sql = "INSERT INTO user values (null,?,?,?,?,?,?,?,null)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(), user.getRole(), user.getState(), user.getActivecode());
    }
}
