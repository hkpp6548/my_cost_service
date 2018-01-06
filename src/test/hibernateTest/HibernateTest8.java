package hibernateTest;

import com.skyhuang.hibernate.study.domain.Customer;
import com.skyhuang.hibernate.study.domain.HibernateUtils;
import org.hibernate.LockMode;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

/** hibernate事物管理
 * Created by hk on 2018/1/7.
 */
public class HibernateTest8 {
    @Test
	/*
	 * 当前线程中绑定的session的使用
	 */
    public void demo8(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCname("张三");

        session.save(customer);

        tx.commit();
        // session.close();
    }

    @Test
	/*
	 * 事务通常在service层开启.session在DAO层.
	 * 	* 事务开启由session开启.
	 */
    public void demo7(){
        Session session1 = HibernateUtils.openSession();
        Session session2 = HibernateUtils.openSession();

        System.out.println(session1 == session2);

        Session session3 = HibernateUtils.getCurrentSession();
        Session session4 = HibernateUtils.getCurrentSession();
        System.out.println(session3 == session4);
    }

    @Test
	/*
	 * 使用乐观锁解决丢失更新
	 */
    public void demo6(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = (Customer) session.get(Customer.class, 3);
        customer.setAge(26);

        tx.commit();
        session.close();
    }

    @Test
	/*
	 * 使用乐观锁解决丢失更新
	 */
    public void demo5(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = (Customer) session.get(Customer.class, 3);
        customer.setCname("沈明贞");

        tx.commit();
        session.close();
    }

    @SuppressWarnings("deprecation")
    @Test
	/*
	 * 使用悲观锁解决丢失更新
	 */
    public void demo4(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 使用悲观锁(拍他锁)
        Customer customer = (Customer) session.get(Customer.class, 3, LockMode.UPGRADE);
        customer.setAge(32);

        tx.commit();
        session.close();
    }

    @SuppressWarnings("deprecation")
    @Test
	/*
	 * 使用悲观锁解决丢失更新
	 */
    public void demo3(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 使用悲观锁(拍他锁)
        Customer customer = (Customer) session.get(Customer.class, 3, LockMode.UPGRADE);
        customer.setCname("沈明贞");

        tx.commit();
        session.close();
    }

    @Test
	/*
	 * 丢失更新的产生
	 */
    public void demo2(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = (Customer) session.get(Customer.class, 3);
        customer.setAge(30);

        tx.commit();
        session.close();
    }

    @Test
	/*
	 * 丢失更新的产生
	 */
    public void demo1(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = (Customer) session.get(Customer.class, 3);
        customer.setCname("沈明贞");

        tx.commit();
        session.close();
    }
}
