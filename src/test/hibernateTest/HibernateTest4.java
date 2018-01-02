package hibernateTest;

import com.skyhuang.hibernate.study.domain.HibernateUtils;
import com.skyhuang.hibernate.study.domain.oneToMore.Customer;
import com.skyhuang.hibernate.study.domain.oneToMore.Order;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

/** 一对多测试  级联关系
 * Created by dahoufang the one on 2017/12/27.
 */
public class HibernateTest4 {
    @Test
    // 区分cascade和inverse
    // 在Customer.hbm.xml中的<set>上配置 cascade="save-update" inverse="true"
    public void demo11(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCname("张三");

        Order order = new Order();
        order.setAddr("西三旗");

        customer.getOrders().add(order);
        // 客户是否存到数据库:存
        // 订单是否存到数据库:存 cascade="save-update".外键是null.
        session.save(customer);

        tx.commit();
        session.close();
    }

    @Test
    // 双向维护:自动更新数据库,产生多余的SQL.
    // 双方都有外键的维护能力.必须让其中一方放弃外键的维护权.(一般情况下都是一的放弃.)inverse="true"
    public void demo10(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = (Customer) session.get(Customer.class, 1);
        Order order = (Order) session.get(Order.class, 2);

        customer.getOrders().add(order);
        order.setCustomer(customer);

        tx.commit();
        session.close();
    }

    @Test
    // 孤儿删除:
    // 在Customer.hbm.xml中<set>上配置cascade="delete-orhpan"
    public void demo9(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 让1号客户与1号订单解除关系:
        Customer customer = (Customer) session.get(Customer.class, 1);

        Order order = (Order) session.get(Order.class, 1);

        customer.getOrders().remove(order);//解除关系  orders会删除数据

        tx.commit();
        session.close();
    }

    @Test
    // 级联删除:删除订单的时候,级联删除客户.
    public void demo8(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Order order = (Order) session.get(Order.class, 1);
        session.delete(order);

        tx.commit();
        session.close();
    }

    @Test
    // 级联删除:删除客户的时候级联删除订单.
    // 在Customer.hbm.xml的<set>标签上配置cascade="delete"
    public void demo7(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 级联删除:先查询,在删除的方式.
        Customer custoemr = (Customer) session.get(Customer.class, 1);
        session.delete(custoemr);

        tx.commit();
        session.close();
    }

    @Test
    // 删除一个客户:
    // 默认的情况下,将外键置为null,删除数据记录.（没有设置级联删除）
    public void demo6(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 删除的时候有两种:
        // 先查询在删除的情况:
        Customer customer = (Customer) session.get(Customer.class, 1);
        session.delete(customer);

        tx.commit();
        session.close();
    }

    @Test
    // 测试对象的导航关系:
    public void demo5(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 定义一个客户:
        Customer customer = new Customer();
        customer.setCname("金刚");

        // 定义三个订单
        Order order1 = new Order();
        order1.setAddr("西三旗");

        Order order2 = new Order();
        order2.setAddr("上地");

        Order order3 = new Order();
        order3.setAddr("五道口");

        order1.setCustomer(customer);

        customer.getOrders().add(order2);
        customer.getOrders().add(order3);

        // session.save(order1); // 共发送4条insert语句:
        // session.save(customer);// 共发送3条insert语句:
        session.save(order2);//功发送一条insert语句：

        tx.commit();
        session.close();
    }

    @Test
    // 保存订单级联客户.
    // 在Order.hbm.xml中<many-to-one>配置cascade属性:级联保存
    public void demo4(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 定义客户:
        Customer customer = new Customer();
        customer.setCname("郭浩");

        // 定义订单:
        Order order = new Order();
        order.setAddr("西三旗中腾建华");
        order.setCustomer(customer);

        customer.getOrders().add(order);

        // 保存的时候只保存一方:
        session.save(order);

        tx.commit();
        session.close();
    }

    @Test
    // 保存客户级联订单.
    // <set>集合是客户的关联订单对象的集合.所以在<set>上配置一个属性:cascade="save-update"
    public void demo3(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 定义客户:
        Customer customer = new Customer();
        customer.setCname("郭浩");

        // 定义订单:
        Order order = new Order();
        order.setAddr("西三旗中腾建华");
        order.setCustomer(customer);

        customer.getOrders().add(order);

        // 保存的时候只保存一方:
        session.save(customer);

        tx.commit();
        session.close();
    }

    @Test
    // 保存客户和订单的时候,是否可以只保存其中的一方?
    // 不行的报一个异常:一个持久态对象关联一个瞬时的对象.
    public void demo2(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 定义客户:
        Customer customer = new Customer();
        customer.setCname("金刚");

        // 定义订单:
        Order order = new Order();
        order.setAddr("五道口");
        order.setCustomer(customer);

        customer.getOrders().add(order);

        // 保存的时候只保存一方:
        session.save(customer);

        tx.commit();
        session.close();
    }

    @Test
    // 向客户表插入一个客户,在订单表中插入两个订单.
    public void demo1(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 定义一个客户:
        Customer customer = new Customer();
        customer.setCname("郭浩");

        // 定义两个订单:
        Order order1 = new Order();
        order1.setAddr("西三旗中腾");

        Order order2 = new Order();
        order2.setAddr("西三旗金燕龙");

        // 建立关系:
        order1.setCustomer(customer);
        order2.setCustomer(customer);

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        session.save(customer);
        session.save(order1);
        session.save(order2);

        tx.commit();
        session.close();
    }
}
