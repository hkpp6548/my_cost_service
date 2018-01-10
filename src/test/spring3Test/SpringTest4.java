package spring3Test;

import com.skyhuang.spring3.demo4.CustomerService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hk on 2018/1/10.
 */
public class SpringTest4 {
    @Test
    // Bean完整的生命周期
    public void demo1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
        customerService.add();
        customerService.find();

        applicationContext.close();
    }
}
