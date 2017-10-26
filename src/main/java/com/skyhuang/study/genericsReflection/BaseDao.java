package com.skyhuang.study.genericsReflection;

import java.util.List;

/** Dao的一些方法的抽取
 * Created by hk on 2017/10/26.
 */
public interface BaseDao<T> {

    public T selectById(int id);

    public void add(T t);

    public void delete(T t);

    public void update(T t);

    public List<T> selectAll();


}
