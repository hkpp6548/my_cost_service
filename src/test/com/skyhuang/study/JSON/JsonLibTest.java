package com.skyhuang.study.JSON;

import com.skyhuang.domain.Product;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dahoufang the one on 2017/10/24.
 */
public class JsonLibTest {
    // 将数组转换成json
    @Test
    public void fun1() {
        String[] st = { "aaa", "bbb", "ccc" };
        String json = JSONArray.fromObject(st).toString();
        System.out.println(json); // ["aaa","bbb","ccc"]
    }

    // 将List集合转换成json
    @Test
    public void fun2() {
        List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");

        String json = JSONArray.fromObject(list).toString();

        System.out.println(json); // ["111","222","333"]
    }

    // 将一个javaBean转换成json
    @Test
    public void fun3() {
        Product p = new Product(1, "电冰箱", 1800);
        String json = JSONObject.fromObject(p).toString();

        System.out.println(json); // {"id":1,"name":"电冰箱","price":1800}
    }

    // 如果List<Product>
    @Test
    public void fun4() {
        List<Product> ps = new ArrayList<Product>();
        ps.add(new Product(1, "洗衣机", 1800));
        ps.add(new Product(2, "电视机", 3800));
        ps.add(new Product(3, "空调", 5800));

        JsonConfig config = new JsonConfig();
        config.setExcludes(new String[] { "type" });

        String json = JSONArray.fromObject(ps, config).toString();

        System.out.println(json);
    }

    // map集合转换成json
    @Test
    public void fun5() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("aaa", "1111");
        map.put("bbb", "222");
        System.out.println(JSONObject.fromObject(map).toString());
    }

    // 将json转换成java
    @Test
    public void fun6() {
        Product p = new Product(1, "电冰箱", 1800);
        JSONObject jsonObj = JSONObject.fromObject(p);

        // 将jsonObj在转换成java对象
        Product pp= (Product) JSONObject.toBean(jsonObj,Product.class);

        System.out.println(pp);
    }
}
