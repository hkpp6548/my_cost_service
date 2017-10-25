package com.skyhuang.study.designMode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 动态代理
 * Created by dahoufang the one on 2017/10/25.
 */
public class DProxyDemo {
    public static void main(String[] args) {
        final KingWoman woman = new Pjl();
        // 做一个Pjl的代理.

        KingWoman proxy = (KingWoman) Proxy.newProxyInstance(woman.getClass()
                        .getClassLoader(), woman.getClass().getInterfaces(),
            new InvocationHandler() {
                public Object invoke(Object proxy, Method method,
                                     Object[] args) throws Throwable {
                    return method.invoke(woman, args); //woman.方法名(参数)
                }
            });

        proxy.throwEye();
        final KingMan man = new Cgx();
        KingMan manProxy = (KingMan) Proxy.newProxyInstance(man.getClass()
                        .getClassLoader(), man.getClass().getInterfaces(),
        new InvocationHandler() {
            public Object invoke(Object proxy, Method method,
                                 Object[] args) throws Throwable {
                return method.invoke(man, args);
            }
        });
        manProxy.pz();
    }
}
