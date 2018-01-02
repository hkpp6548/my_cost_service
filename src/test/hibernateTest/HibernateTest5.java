package hibernateTest;

import com.skyhuang.hibernate.study.domain.HibernateUtils;
import com.skyhuang.hibernate.study.domain.moreToMore.Course;
import com.skyhuang.hibernate.study.domain.moreToMore.Student;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

/** 多对多测试  级联关系
 * Created by dahoufang the one on 2017/12/27.
 */
public class HibernateTest5 {

    @Test
    // 保存学生和课程.为学生选择一些课程:(未设置级联的操作)
    public void demo1(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 创建学生:
        Student student1 = new Student();
        student1.setSname("张三");
        Student student2 = new Student();
        student2.setSname("李四");

        // 创建课程:
        Course course1 = new Course();
        course1.setCname("Java语言");
        Course course2 = new Course();
        course2.setCname("Android语言");

        // 张三选1号和2号课
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);

        course1.getStudents().add(student1);
        course2.getStudents().add(student1);

        student2.getCourses().add(course1);
        course1.getStudents().add(student2);

        // 执行保存:
        session.save(student1);
        session.save(student2);
        session.save(course1);
        session.save(course2);

        tx.commit();
        session.close();
    }

    @Test
    // 级联操作:级联保存:保存学生关联课程
    // 在Student.hbm.xml中配置<set>上 cascade="save-update"
    public void demo2(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 创建学生:
        Student student1 = new Student();
        student1.setSname("王五");

        // 创建课程:
        Course course1 = new Course();
        course1.setCname("PHP语言");

        student1.getCourses().add(course1);
        course1.getStudents().add(student1);

        session.save(student1);

        tx.commit();
        session.close();
    }



    @Test
    // 级联删除:在多对多中很少使用.
    // 删除:删除学生同时删除学生关联选课
    public void demo3(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Student student = (Student) session.get(Student.class, 3);
        session.delete(student);

        tx.commit();
        session.close();
    }


    @Test
    // 多对多的学生退选.
    public void demo4(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 查询一号学生
        Student student = (Student) session.get(Student.class, 3);
        Course course = (Course) session.get(Course.class, 3);
        student.getCourses().remove(course);

        tx.commit();
        session.close();
    }

}
