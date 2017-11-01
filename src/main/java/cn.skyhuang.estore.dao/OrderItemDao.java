package cn.skyhuang.estore.dao;

import cn.skyhuang.estore.domain.OrderItem;
import cn.skyhuang.estore.domain.Product;
import cn.skyhuang.estore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/31.
 */
public class OrderItemDao {

    /**
     *  新增订单项
     * @param items
     * @throws SQLException
     */
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

    /**
     * 根据orderid 查找所有对应的商品信息
     * @param orderid
     * @return
     * @throws SQLException
     */
    public List<Product> findProductByOrderId(String orderid) throws SQLException {
        String sql = "SELECT p.* FROM orderitem o, products p where o.product_id = p.id and o.order_id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Product>(Product.class), orderid);
    }

    public List<OrderItem> findOrderItemByOrderId(String id) throws SQLException {
        String sql = "select * from orderitem where order_id=?";
        QueryRunner runner = new QueryRunner();
        return runner.query(DataSourceUtils.getConnectionByTransaction(), sql,
                new BeanListHandler<OrderItem>(OrderItem.class), id);

    }

    public void delOrderItemByOrderId(String id) throws SQLException {
        String sql = "delete  from orderitem where order_id=?";
        QueryRunner runner = new QueryRunner();
        runner.update(DataSourceUtils.getConnectionByTransaction(), sql, id);
    }
}
