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
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session openSession(){
        return sessionFactory.openSession();
    }

}
