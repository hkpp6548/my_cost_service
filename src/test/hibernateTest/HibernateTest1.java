package hibernateTest;

import com.skyhuang.hibernate.study.domain.Customer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

/** Hibernate入门案例的测试
 * Created by hk on 2017/11/30.
 */
public class HibernateTest1 {

    @Test
    // 查询所有记录:SQL
    public void demo7(){
        // 1.加载核心配置文件
        Configuration configuration = new Configuration().configure();
        // 2.构建Session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3.通过工厂创建Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction tx = session.beginTransaction();

        // 5.操作
        // 查询所有:SQL
		/*SQLQuery query = session.createSQLQuery("select * from customer");
		List<Object[]> list = query.list();

		for (Object[] objs : list) {
			System.out.println(Arrays.toString(objs));
		}*/
        SQLQuery query = session.createSQLQuery("select * from customer");
        query.addEntity(Customer.class);
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }

        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();

    }


    @Test
    // 查询所有:QBC
    public void demo6(){
        // 1.加载核心配置文件
        Configuration configuration = new Configuration().configure();
        // 2.构建Session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3.通过工厂创建Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction tx = session.beginTransaction();

        // 5.操作:
        // 查询所有 :QBC.
		/*Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();*/
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("name", "凤姐"));
        List<Customer> list = criteria.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();
    }

    @Test
    // 查询所有:HQL.
    // HQL:Hibernate Query Language.Hibernate查询语言.面向对象的查询.
    public void demo5(){
        // 1.加载核心配置文件
        Configuration configuration = new Configuration().configure();
        // 手动编码加载映射文件:(在核心配置文件中没有配置映射文件的时候需要手动编码配置)
        // configuration.addResource("cn/itcast/hibernate3/demo1/Customer.hbm.xml");
        // configuration.addClass(Customer.class);
        // 2.构建Session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3.通过工厂创建Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction tx = session.beginTransaction();

        // 5.操作
        // 1.查询所有的客户
		/*Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();*/
        // 2.按名称查询
		/*Query query = session.createQuery("from Customer where name = ?");
		query.setParameter(0, "苍老师");*/
        Query query = session.createQuery("from Customer where name = :aaa");
        query.setParameter("aaa", "苍老师");
        List<Customer> list = query.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();
    }

    @Test
    // 删除记录
    public void demo4(){
        // 1.加载核心配置文件
        Configuration configuration = new Configuration().configure();
        // 2.构建Session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3.通过工厂创建Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction tx = session.beginTransaction();

        // 5.操作
        // 删除记录有两种方式:
        // 5.1手动创建对象的方式
		/*Customer customer = new Customer();
		customer.setId(2);

		session.delete(customer);*/

        // 5.2先查询在删除的方式
        Customer customer = (Customer)session.get(Customer.class, 1);
        session.delete(customer);

        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();
    }

    @Test
    // 修改记录
    public void demo3(){
        // 1.加载核心配置文件
        Configuration configuration = new Configuration().configure();
        // 2.构建Session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3.通过工厂创建Session
        Session session = sessionFactory.openSession();
        // 4.开启事务
        Transaction tx = session.beginTransaction();

        // 5.操作:
        // 修改记录:两种方式可以进行修改.
        // 5.1手动创建对象的方式
		/*Customer customer = new Customer();
		customer.setId(2);
		customer.setName("苍老师");
		session.update(customer);*/
        // 5.2先查询在修改的方式
        Customer customer = (Customer) session.get(Customer.class, 1);
        //customer.setName("凤姐");
        session.update(customer);
        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();
    }

    // 按id进行查询
    // (*****面试题)get和load方法区别
    @Test
    public void demo2(){
        // 1.Hiberante框架加载核心配置文件(有数据库连接信息)
        Configuration configuration = new Configuration().configure();
        // 2.创建一个SessionFactory.(获得Session--相当连接对象)
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 3.获得Session对象.
        Session session = sessionFactory.openSession();
        // 4.默认的情况下,事务是不自动提交.
        Transaction tx = session.beginTransaction();

        // 根据id进行查询:
        // get方法进行查询
        Customer customer = (Customer) session.get(Customer.class, 1); // 马上发生一条SQL进行查询
        System.out.println(customer);
        // load方法进行查询
        //Customer customer = (Customer) session.load(Customer.class, 1); // 没有发送SQL
        //System.out.println(customer);// 发送SQL.

        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();
    }

    //保存记录
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
        //customer.setName("苍老师3");
        customer.setAge(28);
        session.save(customer);


        // 6.事务提交
        tx.commit();
        // 7.释放资源
        session.close();
        sessionFactory.close();
    }
}
