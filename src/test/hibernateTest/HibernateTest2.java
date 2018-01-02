package hibernateTest;

import com.skyhuang.hibernate.study.domain.Customer;
import com.skyhuang.hibernate.study.domain.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

/** 使用抽取工具类进行测试
 * Created by hk on 2017/11/30.
 */
public class HibernateTest2 {

    @Test
    // 查询所有记录:SQL
    public void demo7(){
        Session session = HibernateUtils.openSession();
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

        tx.commit();
        session.close();

    }


    @Test
    // 查询所有:QBC
    public void demo6(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 查询所有 :QBC.
		/*Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();*/
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("name", "凤姐"));
        List<Customer> list = criteria.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        tx.commit();
        session.close();
    }

    @Test
    // 查询所有:HQL.
    // HQL:Hibernate Query Language.Hibernate查询语言.面向对象的查询.
    public void demo5(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 1.简单查询
        // List<Customer> list = session.createQuery("from Customer").list();
        // 2.条件查询:
        // List<Customer> list = session.createQuery("from Customer where name = ?").setParameter(0, "芙蓉").list();
        // 3.分页查询:select * from customer limit a,b; a:从哪开始  b:每页显示记录数.
        Query query = session.createQuery("from Customer");
        query.setFirstResult(0);
        query.setMaxResults(3);

        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }

        tx.commit();
        session.close();
    }

    @Test
    // 删除记录
    public void demo4(){
        Session session = HibernateUtils.openSession();
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

        tx.commit();
        session.close();
    }

    @Test
    // 修改记录
    public void demo3(){
        Session session = HibernateUtils.openSession();
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
        customer.setName("凤姐");
        session.update(customer);

        tx.commit();
        session.close();
    }

    // 保存或更新
    @Test
    public void demo2(){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setId(5);
        customer.setName("天海翼");
        customer.setAge(18);
        System.out.println("事物是否提交：" + transaction.wasCommitted());
        session.saveOrUpdate(customer);
        transaction.commit();
        System.out.println("事物是否提交：" + transaction.wasCommitted());
        session.close();
    }

    //保存记录
    @Test
    public void demo1(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        Customer customer = new Customer();
        customer.setName("su_cute");
        customer.setAge(28);
        Serializable id = session.save(customer);
        System.out.println(id);
        tx.commit();
        session.close();
    }
}
