package hibernateTest;

import com.skyhuang.hibernate.study.domain.HibernateUtils;
import com.skyhuang.hibernate.study.domain.oneToMore.Customer;
import com.skyhuang.hibernate.study.domain.oneToMore.Order;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.List;

/** Hibernate的抓取策略
 * Created by hk on 2018/1/5.
 */
public class HibernateTest7 {

    @SuppressWarnings("unchecked")
    @Test
	/*
	 * 批量抓取
	 * 	通过订单批量抓取客户:
	 * 		需要在客户一端<class>标签上配置batch-size
	 */
    public void demo13(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        List<Order> list = session.createQuery("from Order").list();
        for (Order order : list) {
            System.out.println(order.getCustomer().getCname());
        }

        tx.commit();
        session.close();
    }


    @SuppressWarnings("unchecked")
    @Test
	/*
	 * 批量抓取
	 * 	在客户一端配置
	 * 	<set>集合上配置batch-size="3"
	 */
    public void demo12(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        List<Customer> list = session.createQuery("from Customer").list();
        for (Customer customer : list) {
            for (Order order : customer.getOrders()) {
                System.out.println(order.getAddr());
            }
        }


        tx.commit();
        session.close();
    }

    @Test
	/*
	 * 在<many-to-one>标签上配置:
	 * 	* fetch="select" lazy="proxy"
	 * 		* 发送多条SQL
	 */
    public void demo11(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 在这行发送多条SQL 查询关联对象.
        Order order = (Order) session.get(Order.class, 1);

        System.out.println(order.getCustomer().getCname());

        tx.commit();
        session.close();
    }

    @Test
	/*
	 * 在<many-to-one>标签上配置:
	 * 	* fetch="select" lazy="false"
	 * 		* 发送多条SQL
	 */
    public void demo10(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 在这行发送多条SQL 查询关联对象.
        Order order = (Order) session.get(Order.class, 1);

        System.out.println(order.getCustomer().getCname());

        tx.commit();
        session.close();
    }

    @Test
	/*
	 * 在<many-to-one>标签上配置:
	 * 	* fetch="join" lazy="被忽略"
	 * 	* 发送迫切左外连接
	 */
    public void demo9(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 发送一条迫切左外连接.查询关联对象.
        Order order = (Order) session.get(Order.class, 1);

        System.out.println(order.getCustomer().getCname());

        tx.commit();
        session.close();
    }

    @Test
	/*
	 * 没有在<many-to-one>标签上配置:
	 * 	* 发送多条SQL进行查询.
	 */
    public void demo8(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 只会发送一条查询订单SQL.
        Order order = (Order) session.get(Order.class, 1);

        // 使用订单的客户对象的时候,又发送一条SQL查询订单关联的客户
        System.out.println(order.getCustomer().getCname());

        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Test
	/*
	 * 在<set>集合上配置
	 * 	* fetch="subselect" lazy="true"
	 * 		* 使用subselect的时候 需要使用 query接口进行测试.
	 * 		* 查询一个客户  查询多个客户.
	 * 	如果有多个客户:
	 * 	* select * from orders where cno in (1,2,3);
	 * 	如果只有一个客户:
	 *  * select * from orders where cno = 1;
	 */
    public void demo7(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        List<Customer> list = session.createQuery("from Customer").list();

        for (Customer customer : list) {
            System.out.println(customer.getOrders().size());
        }

        tx.commit();
        session.close();
    }


    @Test
	/*
	 * 在<set>集合上配置
	 * 	* fetch="select" lazy="extra"
	 * 	* lazy:extra及其懒惰.要订单的数量
	 */
    public void demo6(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = (Customer) session.get(Customer.class, 1);
        // select count(*) from orders where cno = ?;
        System.out.println(customer.getOrders().size());
        // 发送查询订单的SQL
        for (Order order : customer.getOrders()) {
            System.out.println(order);
        }

        tx.commit();
        session.close();
    }

    @Test
	/*
	 * 在<set>集合上配置
	 * 	* fetch="select" lazy="false"
	 * 	* lazy:false:关联对象的检索不使用延迟
	 */
    public void demo5(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 发送多条SQL,查询关联对象.
        Customer customer = (Customer) session.get(Customer.class, 1);

        System.out.println(customer.getOrders().size());

        tx.commit();
        session.close();
    }

    @Test
	/*
	 * 在<set>集合上配置
	 * 	* fetch="select" lazy="true"
	 * 	* lazy:true-使用延迟检索
	 * 	* 发送多条SQL,查询关联对象
	 */
    public void demo4(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 发送一条只查询客户的SQL
        Customer customer = (Customer) session.get(Customer.class, 1);
        // 使用订单的时候又发送一条查询这个客户的订单的SQL
        System.out.println(customer.getOrders().size());

        tx.commit();
        session.close();
    }

    @Test
	/*
	 *  <set>配置fetch="join" lazy就会被忽略!!!
	 *  	* 发送迫切左外连接查询两个表.
	 */
    public void demo3(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 直接发送一条迫切左外连接
		/*
		 *     select
        customer0_.cid as cid0_1_,
        customer0_.cname as cname0_1_,
        orders1_.cno as cno0_3_,
        orders1_.oid as oid3_,
        orders1_.oid as oid1_0_,
        orders1_.addr as addr1_0_,
        orders1_.cno as cno1_0_
	    from
	        customer customer0_
	    left outer join
	        orders orders1_
	            on customer0_.cid=orders1_.cno
	    where
	        customer0_.cid=?
		 */
        Customer customer = (Customer) session.get(Customer.class, 1);

        System.out.println(customer.getOrders().size());

        tx.commit();
        session.close();
    }

    @Test
	/*
	 *  <set>没有配置fetch 和 lazy情况
	 */
    public void demo2(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = (Customer) session.get(Customer.class, 1);// 发送查询客户的SQL.

        System.out.println(customer.getOrders().size());// 又发送一条SQL 去查询客户的关联的订单

        tx.commit();
        session.close();
    }

    @Test
	/*
	 *  区分立即检索和延迟检索
	 */
    public void demo1(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 立即检索
		/*Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println(customer);*/

        // 延迟检索:
        // 持久化类如果设置为final 延迟检索就失效了.
        // 在Customer.hbm.xml中在<class>标签上配置lazy="false"不支持延迟检索,就会立即检索.
        Customer customer = (Customer) session.load(Customer.class, 1);
        // System.out.println(customer);

        // 初始化代理对象
        // System.out.println(customer.getCname());
        Hibernate.initialize(customer);

        tx.commit();
        session.close();
    }

}
