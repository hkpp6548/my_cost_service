package com.skyhuang.study.designMode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 动态代理测试说明
 * Created by dahoufang the one on 2017/10/25.
 */
public class StudentProxyTest {

    public static void main(String[] args) {
        // 做Person接口实现类Student的动态代理。
        // 1.创建一个Student 被代理
        final Person s = new Student();
        // 2.得到s的代理对象.
        Person sproxy = (Person) Proxy.newProxyInstance(s.getClass()
                        .getClassLoader(), s.getClass().getInterfaces(),
                new InvocationHandler() {
                    // 参数 proxy就是代理对象
                    // 参数method就是调用方法
                    // 参数args就是调用的方法的参数
                    // 返回值,就是真实行为执行后返回的结果，会传递给代理对象调用的方法.
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        // proxy,就是代理对象，我们一般不使用。
                        // method,就是要访问的方法。
                        // args 就是要访问的方法的参数
                        return method.invoke(s, args); // s.say("james");
                    }
                });
        String message = sproxy.say("james"); // 这个是代理对象调用say方法.
        System.out.println(message);
    }

}
