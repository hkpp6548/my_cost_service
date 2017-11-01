package cn.skyhuang.estore.dao;

import cn.skyhuang.estore.domain.OrderItem;
import cn.skyhuang.estore.domain.Product;
import cn.skyhuang.estore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/31.
 */
public class ProductDao {

    /**
     * 添加商品
     * @param p
     * @throws SQLException
     */
    public void add(Product p) throws SQLException {
        String sql = "insert into products values(?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql, p.getId(), p.getName(), p.getPrice(),
                p.getCategory(), p.getPnum(), p.getImgurl(), p.getDescription());
    }

    /**
     * 查找所有商品
     * @return
     * @throws SQLException
     */
    public List<Product> findAll() throws SQLException {
        String sql = "select * from products";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Product>(Product.class));
    }

    /**
     * 通过商品id朝找商品
     * @param id
     * @return
     * @throws SQLException
     */
    public Product findById(String id) throws SQLException {
        String sql = "select * from products";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<Product>(Product.class));
    }

    public void updatePnum(List<OrderItem> items) throws SQLException {
        String sql = "update products set pnum=pnum-? where id=?";
        QueryRunner runner = new QueryRunner();
        Object[][] params = new Object[items.size()][2];
        for (int i = 0; i < items.size(); i++) {
            OrderItem item = items.get(i);
            params[i][0] = item.getBuynum();
            params[i][1] = item.getProduct_id();
        }
        runner.batch(DataSourceUtils.getConnectionByTransaction(), sql, params);
    }

    public void changePnum(List<OrderItem> items) throws SQLException {
        String sql  = "update products set pnum = pnum+? where id=?";
        QueryRunner runner = new QueryRunner();
        Object [][] params = new Object[items.size()][2];
        for (int i = 0; i < items.size(); i++) {
            OrderItem orderItem = items.get(i);
            params[i][0] = orderItem.getBuynum();
            params[i][1] = orderItem.getProduct_id();
        }
        runner.batch(DataSourceUtils.getConnectionByTransaction(), sql, params);
    }

    public List<Product> downloadSell() throws SQLException {
        String sql = "SELECT products.name, SUM(buynum) totalSaleNum " +
                " FROM products, orderitem, orders " +
                " WHERE orderitem.product_id=products.id AND orders.id=orderitem.order_id AND" +
                " orders.paystate=0 ORDER BY totalSaleNum";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Product>(Product.class));
    }
}
