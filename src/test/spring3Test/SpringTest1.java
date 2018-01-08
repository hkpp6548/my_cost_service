package spring3Test;

import com.skyhuang.spring3.demo1.HelloService;
import com.skyhuang.spring3.demo1.HelloServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by hk on 2018/1/8.
 */
public class SpringTest1 {

    @Test
    // 传统方式
    public void demo1() {
        // 造成程序紧密耦合.
        HelloService helloService = new HelloServiceImpl();
        helloService.sayHello();
    }

    @Test
    // Spring开发
    public void demo2() {
        // 创建一个工厂类.
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        HelloService helloService = (HelloService) applicationContext.getBean("helloService");
        helloService.sayHello();
    }

    @Test
    // 加载磁盘路径下的配置文件:
    public void demo3() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                "applicationContext.xml");
        HelloService helloService = (HelloService) applicationContext
                .getBean("helloService");
        helloService.sayHello();
    }

    @Test
    public void demo4(){
        // ClassPathResource  FileSystemResource
        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("applicationContext.xml"));
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();
    }

}
