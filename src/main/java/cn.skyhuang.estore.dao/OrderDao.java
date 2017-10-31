package cn.skyhuang.estore.dao;

import cn.skyhuang.estore.domain.Order;
import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/31.
 */
public class OrderDao {

    public void addOrder(Order order) throws SQLException {
        String sql = "insert into orders values(?,?,?,?,null,?)";
        QueryRunner runner = new QueryRunner(); // 手动事务
        runner.update(DataSourceUtils.getConnectionByTransaction(), sql,
                order.getId(), order.getMoney(), order.getReceiverinfo(),
                order.getPaystate(), order.getUser_id());
    }

    public List<Order> findOrder(User user) throws SQLException {
        String sql = "select user.username,user.nickname,orders.* from orders,user where user.id=orders.user_id ";
        //user 角色
        if ("user".equals(user.getRole())) {
            sql += " and user_id=" + user.getId();
        }
        sql += " order by user_id,ordertime";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Order>(Order.class));
    }
}
