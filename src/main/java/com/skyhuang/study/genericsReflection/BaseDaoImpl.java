package com.skyhuang.study.genericsReflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/** Dao实现类的抽取
 * Created by hk on 2017/10/26.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    private Class clazz;

    public BaseDaoImpl(){
        Type genericSuperclass = this.getClass().getGenericSuperclass();//可以获取当前对象的直接超类的 Type（泛型的父类）
        if(genericSuperclass instanceof ParameterizedType){
            //参数化类型
            ParameterizedType parameterizedType= (ParameterizedType) genericSuperclass;
            //返回表示此类型实际类型参数的 Type 对象的数组
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            this.clazz= (Class)actualTypeArguments[0];
        }else{
            this.clazz= (Class)genericSuperclass;
        }
    }



    public T selectById(int id) {
        System.out.println(clazz);
        return null;
    }

    public void add(T t) {
        System.out.println(clazz);
    }

    public void delete(T t) {

    }

    public void update(T t) {

    }

    public List selectAll() {
        return null;
    }
}
