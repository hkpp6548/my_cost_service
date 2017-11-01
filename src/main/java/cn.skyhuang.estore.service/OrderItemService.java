package cn.skyhuang.estore.service;

import cn.skyhuang.estore.dao.OrderItemDao;
import cn.skyhuang.estore.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/11/1.
 */
public class OrderItemService {

    public List<Product> findProductByOrderId(String orderid) throws SQLException {
        OrderItemDao dao = new OrderItemDao();
        return dao.findProductByOrderId(orderid);
    }
}
