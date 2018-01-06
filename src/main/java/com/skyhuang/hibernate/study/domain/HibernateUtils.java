package com.skyhuang.hibernate.study.domain;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/** Hibernate抽取工具类
 * Created by dahoufang the one on 2017/12/5.
 */
public class HibernateUtils {

    private static Configuration configuration;

    private static SessionFactory sessionFactory;

    static {
        //加载核心配置文件
        configuration = new Configuration().configure();
        //构建Session工厂
        sessionFactory = configuration.buildSessionFactory();
    }

    /**
     *  获取session
     * @return
     */
    public static Session openSession(){
        return sessionFactory.openSession();
    }

    /**
     * 获取当前线程里的同一个session
     * @return
     */
    public static Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

}
