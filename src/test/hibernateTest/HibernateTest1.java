package hibernateTest;

import com.skyhuang.hibernate.study.domain.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

/**
 * Created by hk on 2017/11/30.
 */
public class HibernateTest1 {
    @Test
    public void demo1(){
        // 1.Hiberante框架加载核心配置文件(有数据库连接信息)
        Configuration configuration = new Configuration().configure();
        // 2.创建一个SessionFactory.(获得Session--相当连接对象)
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3.获得Session对象.
        Session session = sessionFactory.openSession();
        // 4.默认的情况下,事务是不自动提交.
        Transaction tx = session.beginTransaction();
        // 5.业务逻辑操作

        // 向数据库中插入一条记录:
        Customer customer = new Customer();
        customer.setName("苍老师");
        customer.setAge(38);

        session.save(customer);

        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();
    }
}
