package hibernateTest;

import com.skyhuang.hibernate.study.domain.Book;
import com.skyhuang.hibernate.study.domain.HibernateUtils;
import org.hibernate.FlushMode;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

/** hibernate 一级缓存
 * Created by dahoufang the one on 2017/12/27.
 */
public class HibernateTest3 {
    @Test
    // saveOrUpdate方法:保存或更新一条记录
    // 如果对象是瞬时,执行save操作,如果对象是脱管,执行update操作.
    // 如果设置的id数据库中没有保存的.可以在映射文件的<id>上设置unsaved-value="-1"执行保存操作.
    public void demo11(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // 2.开启事务
        Transaction tx = session.beginTransaction();

		/*
	 	Book book = new Book();//瞬时态.
		book.setName("MySQL数据库");

		session.saveOrUpdate(book);// 执行保存.
		*/

        Book book = new Book();//瞬时态.
        book.setId(-1); // 脱管态:
        book.setName("Spring大全");

        session.saveOrUpdate(book);// 执行更新.
        // 3.提交事务
        tx.commit();
        // 4.关闭资源
        session.close();
    }

    @Test
    // update方法:更新一条记录.将脱管对象转成持久对象
    public void demo10(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // 2.开启事务
        Transaction tx = session.beginTransaction();

        Book book = new Book();//瞬时态.
        book.setId(1);// 脱管态
        book.setName("MyBatis开发");

        session.update(book);// 持久态.

        // 3.提交事务
        tx.commit();
        // 4.关闭资源
        session.close();
    }

    @Test
    // save方法
    public void demo9(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // 2.开启事务
        Transaction tx = session.beginTransaction();

        Book book = new Book();// 瞬时态对象
        book.setName("网页平面设计");
        book.setAuthor("王XX");
        book.setPrice(32d);

        session.save(book);// 持久态

        // 3.提交事务
        tx.commit();
        // 4.关闭资源
        session.close();
    }

    @Test
    // 一级缓存的刷出的时机(了解)
    public void demo8(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // session.setFlushMode(FlushMode.COMMIT);// 事务提交,及手动调用flush.
        session.setFlushMode(FlushMode.MANUAL);// 只有手动调用flush的时候才会发送
        // 2.开启事务
        Transaction tx = session.beginTransaction();

        Book book = (Book) session.get(Book.class, 1);
        book.setName("JavaScript开发");

        // List<Book> list = session.createQuery("from Book").list();
        // System.out.println(list);
        // Book book2 = (Book) session.get(Book.class, 1); // 不发送SQL,从一级缓存中获取数据.


        // 3.提交事务
        tx.commit();

        session.flush();
        // 4.关闭资源
        session.close();
    }

    @Test
    // 一级缓存的管理:refresh():将快照区的数据,覆盖了一级缓存的数据.
    public void demo7(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // 2.开启事务
        Transaction tx = session.beginTransaction();

        Book book = (Book) session.get(Book.class, 1);
        book.setName("PHP开发");

        session.refresh(book);

        // 3.提交事务
        tx.commit();
        // 4.关闭资源
        session.close();
    }

    @Test
    // 一级缓存的管理:flush()刷出缓存.
    public void demo6(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // 2.开启事务
        Transaction tx = session.beginTransaction();

        Book book = (Book) session.get(Book.class, 1);
        book.setName("Hibernate3开发");

        session.flush();// 发出update语句.

        // 3.提交事务
        tx.commit();
        // 4.关闭资源
        session.close();
    }


    @Test
    // 一级缓存的管理:clear/evict();
    public void demo5(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // 2.开启事务
        Transaction tx = session.beginTransaction();

        Book book1 = (Book) session.get(Book.class, 1);
        Book book2 = (Book) session.get(Book.class, 2);
        System.out.println(book1);
        System.out.println(book2);

        // session.clear();// 清空一级缓存的区域.
        session.evict(book1); // 清空一级缓存的某个对象.

        Book book3 = (Book) session.get(Book.class, 1);
        Book book4 = (Book) session.get(Book.class, 2);
        System.out.println(book3);
        System.out.println(book4);
        // 3.提交事务
        tx.commit();
        // 4.关闭资源
        session.close();
    }

    @Test
    // 深入理解一级缓存结构:快照区:
    public void demo4(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // 2.开启事务
        Transaction tx = session.beginTransaction();

        // 获得一个持久态的对象.
        Book book = (Book) session.get(Book.class, 1);
        book.setName("Spring3开发");

        // 3.提交事务
        tx.commit();
        // 4.关闭资源
        session.close();
    }

    @Test
    // 证明一级缓存的存在
    public void demo3(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // 2.开启事务
        Transaction tx = session.beginTransaction();

        // save方法可以向一级缓存中存放数据的.
		/*Book book = new Book();
		book.setName("JQuery开发");
		book.setAuthor("张XX");
		book.setPrice(45d);

		Integer id = (Integer) session.save(book);

		Book book2 = (Book) session.get(Book.class, id);

		System.out.println(book2);*/

        // 分别用get执行两次查询.
        Book book1 = (Book) session.get(Book.class, 1);// 马上发生SQL去查询
        System.out.println(book1);

        Book book2 = (Book) session.get(Book.class, 1);// 不发生SQL,因为使用一级缓存的数据
        System.out.println(book2);

        // 3.提交事务
        tx.commit();
        // 4.关闭资源
        session.close();
    }

    @Test
    // 测试持久态的对象自动更新数据库
    public void demo2(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // 2.开启事务
        Transaction tx = session.beginTransaction();

        // 获得一个持久态的对象.
        Book book = (Book) session.get(Book.class, 1);
        book.setName("Struts2开发");

        // session.update(book);

        // 3.提交事务
        tx.commit();
        // 4.关闭资源
        session.close();
    }

    @Test
    // 区分持久化对象的三种状态:
    public void demo1(){
        // 1.创建Session
        Session session = HibernateUtils.openSession();
        // 2.开启事务
        Transaction tx = session.beginTransaction();

        // 向数据库中保存一本图书:
        Book book = new Book();	// 瞬时态:没有唯一标识OID,没有与session关联.
        book.setName("Hiernate开发");
        book.setAuthor("孙XX");
        book.setPrice(65d);

        session.save(book); // 持久态:有唯一标识OID,与session关联.

        // 3.事务提交
        tx.commit();
        // 4.释放资源
        session.close();

        book.setName("Struts2开发"); // 脱管态:有唯一的标识,没有与session关联.
    }
}
