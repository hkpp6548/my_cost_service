package spring3Test;

import com.skyhuang.spring3.demo7.TestUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 测试注解配置
 * Created by hk on 2018/1/15.
 */
public class SpringTest7 {
    @Test
    public void demo(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext2.xml");
        TestUserService testUserService  = (TestUserService) applicationContext.getBean("testUserService");
        testUserService.sayHello();
        //System.out.println(car);
        System.out.println(testUserService);
    }
}
