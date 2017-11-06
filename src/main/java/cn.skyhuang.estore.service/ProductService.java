package cn.skyhuang.estore.service;

import cn.skyhuang.estore.annotation.PrivilegeInfo;
import cn.skyhuang.estore.domain.Product;
import cn.skyhuang.estore.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dahoufang the one on 2017/11/6.
 */
public interface ProductService {

    //添加商品
    @PrivilegeInfo("addProduct")
    public void addProduct(User user, Product p) throws SQLException;

    //查找所有商品
    //@PrivilegeInfo("findAll")
    public List<Product> findAll(User user) throws SQLException;

    //通过商品id查找商品
    @PrivilegeInfo("findById")
    public Product findById(User user, String id) throws SQLException;

    //下载榜单
    @PrivilegeInfo("downloadSell")
    public List<Product> downloadSell(User user) throws SQLException;
}
