package hibernateTest;

import com.skyhuang.hibernate.study.domain.HibernateUtils;
import com.skyhuang.hibernate.study.domain.oneToMore.Customer;
import com.skyhuang.hibernate.study.domain.oneToMore.Order;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;
import java.util.List;

/** 检索方式测试
 * Created by dahoufang the one on 2018/1/3.
 */
public class HibernateTest6 {

    @Test
    //简单的查询:查询所有数据
    public void demo2(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 使用HQL查询所有客户信息:
        /*List<Customer> list = session.createQuery("from Customer").list();
        for (Customer customer:list) {
            System.out.println(customer);
        }*/
        // 使用QBC的方式查询所有记录:
        /*List<Customer> list = session.createCriteria(Customer.class).list();
        for (Customer customer:list) {
            System.out.println(customer);
        }*/
        // 3.使用SQL语句查询所有记录:
        /*List<Object[]> list = session.createSQLQuery("SELECT * FROM customer").list();
        for (Object[] object:list) {
            System.out.println(Arrays.toString(object));
        }*/

        // 3.使用SQL查询所有记录:封装到实体对象中
        List<Customer> list = session.createSQLQuery("SELECT * FROM customer").addEntity(Customer.class).list();
        for (Customer customer :list) {
            System.out.println(customer);
        }

        tx.commit();
        session.close();
    }

    @Test
    //初始化数据
    public void deme1(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCname("小飞");

        for (int i = 1; i <= 10; i++) {
            Order order = new Order();
            order.setAddr("河南" + i);
            order.setCustomer(customer);
            customer.getOrders().add(order);
        }

        session.save(customer);

        tx.commit();
        session.close();
    }

}
