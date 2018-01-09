package spring3Test;

import com.skyhuang.spring3.demo3.TestCustomer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** Bean的作用范围
 * Created by hk on 2018/1/9.
 */
public class SpringTest3 {
    @Test
    // 测试Scope  singleton prototype
    public void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        TestCustomer c1 = (TestCustomer) applicationContext.getBean("testCustomer");
        System.out.println(c1);

        TestCustomer c2 = (TestCustomer) applicationContext.getBean("testCustomer");
        System.out.println(c2);
    }
}
