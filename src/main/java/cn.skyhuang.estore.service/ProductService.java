package cn.skyhuang.estore.service;

import cn.skyhuang.estore.dao.ProductDao;
import cn.skyhuang.estore.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/10/31.
 */
public class ProductService {

    //添加商品
    public void addProduct(Product p) throws SQLException{
        ProductDao dao = new ProductDao();
        dao.add(p);
    }
    //查找所有商品
    public List<Product> findAll() throws SQLException {
        return new ProductDao().findAll();
    }
    //通过商品id查找商品
    public Product findById(String id) throws SQLException {
        return new ProductDao().findById(id);
    }

    public List<Product> downloadSell() throws SQLException {
        return new ProductDao().downloadSell();
    }
}
