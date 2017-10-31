package cn.skyhuang.estore.dao;

import cn.skyhuang.estore.domain.OrderItem;
import cn.skyhuang.estore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/31.
 */
public class OrderItemDao {

    public void addOrderItem(List<OrderItem> items) throws SQLException {
        String sql = "insert into orderItem values(?,?,?)";
        QueryRunner runner = new QueryRunner();
        Object[][] params = new Object[items.size()][3];
        for (int i = 0; i < items.size(); i++) {
            OrderItem item = items.get(i);
            params[i][0] = item.getOrder_id();
            params[i][1] = item.getProduct_id();
            params[i][2] = item.getBuynum();
        }
        //批处理插入数据库
        runner.batch(DataSourceUtils.getConnectionByTransaction(), sql, params);
    }

}
