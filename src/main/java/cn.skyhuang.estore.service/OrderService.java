package cn.skyhuang.estore.service;

import cn.skyhuang.estore.dao.OrderDao;
import cn.skyhuang.estore.dao.OrderItemDao;
import cn.skyhuang.estore.dao.ProductDao;
import cn.skyhuang.estore.domain.Order;
import cn.skyhuang.estore.domain.OrderItem;
import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/31.
 */
public class OrderService {

    public void addOrder(Order order) {
        OrderDao odao = new OrderDao();
        OrderItemDao oidao = new OrderItemDao();
        ProductDao pdao = new ProductDao();

        try {
            //开启事物
            DataSourceUtils.startTransaction(DataSourceUtils.getConnectionByTransaction());
            // 1.调用OrderDao完成向orders表中添加数据
            odao.addOrder(order);//添加订单
            // 2.调用OrderItemDao完成对orderItem表的添加操作
            oidao.addOrderItem(order.getItems());
            // 3.调用ProductDao完成对products表中数量修改操作.
            pdao.updatePnum(order.getItems());
        } catch (SQLException e){
            e.printStackTrace();
            try {
                //事物回滚
                DataSourceUtils.rollback(DataSourceUtils.getConnectionByTransaction());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                // 释放资源,并且事务提交以及从ThreadLocal中移除Connection。
                DataSourceUtils.closeConnection(DataSourceUtils.getConnectionByTransaction());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Order> findOrder(User user) throws SQLException {
        return new OrderDao().findOrder(user);
    }

    public void delOrderById(String id) {
        OrderDao odao = new OrderDao();
        OrderItemDao oidao = new OrderItemDao();
        ProductDao pdao = new ProductDao();
        try {
            DataSourceUtils.startTransaction(DataSourceUtils.getConnectionByTransaction());
            // 2.操作
            // 2.1 根据orderid查询出所有订单项
            List<OrderItem> items = oidao.findOrderItemByOrderId(id);
            // 2.2根据orderid删除相关订单项
            oidao.delOrderItemByOrderId(id);
            // 2.3根据orderid删除订单
            odao.delOrderById(id);
            // 2.4.根据查询出的items，修改products表中的数据.
            pdao.changePnum(items);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                //事物回滚
                DataSourceUtils.rollback(DataSourceUtils.getConnectionByTransaction());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                //
                DataSourceUtils.closeConnection(DataSourceUtils.getConnectionByTransaction());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}