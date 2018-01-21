package spring3Test;

import com.skyhuang.spring3.aop_proxy.jdk_proxy.JDKProxy;
import com.skyhuang.spring3.aop_proxy.jdk_proxy.UserDao;
import com.skyhuang.spring3.aop_proxy.jdk_proxy.UserDaoImpl;
import org.junit.Test;

/**
 * Created by hk on 2018/1/16.
 */
public class SpringTestProxy {

    @Test
    public void demo1(){
        UserDao userDao = new UserDaoImpl();
        userDao.add();
        userDao.update();
    }

    @Test
    public void demo2(){
        // 被代理对象
        UserDao userDao = new UserDaoImpl();
        // 创建代理对象的时候传入被代理对象.
        UserDao proxy = new JDKProxy(userDao).createProxy();
        proxy.add();
        proxy.update();
    }

}
