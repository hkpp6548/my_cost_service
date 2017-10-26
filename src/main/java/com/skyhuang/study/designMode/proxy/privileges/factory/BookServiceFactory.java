package com.skyhuang.study.designMode.proxy.privileges.factory;

import com.skyhuang.study.designMode.proxy.privileges.annotation.BookprivilegesAnnotation;
import com.skyhuang.study.designMode.proxy.privileges.service.BookPrivilegesService;
import com.skyhuang.study.designMode.proxy.privileges.service.BookPrivilegesServiceImpl;
import com.skyhuang.study.jdbc.DataSourceUtils;
import com.skyhuang.study.program.weightRecord.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/** bookPrivilegesService生产工厂
 * Created by dahoufang the one on 2017/10/26.
 */
public class BookServiceFactory {

    private static BookPrivilegesService bookPrivilegesService = new BookPrivilegesServiceImpl();

    public static BookPrivilegesService getBookPrivilegesService(){

        BookPrivilegesService ProxyBookPrivilegesService = (BookPrivilegesService)Proxy.newProxyInstance(
                bookPrivilegesService.getClass().getClassLoader(), bookPrivilegesService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 真实行为访问前--判断用户是否有权限执行当前行为

                // 1.得到Method方法要想访问需要的权限名称.
                BookprivilegesAnnotation annotation = method.getAnnotation(BookprivilegesAnnotation.class);
                if(annotation == null){
                    return method.invoke(bookPrivilegesService, args);
                }
                //注解的值
                String value = annotation.value();
                // 2.得到当前用户，
                User user = (User)args[0];

                //去获取权限
                String sql = "SELECT p.name FROM user u, privileges p, userprivilege up WHERE u.username = up.username AND up.privilege_id = p.id AND u.username = ?";
                QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
                List<String> query = runner.query(sql, new ColumnListHandler<String>(), user.getUsername());
                if(query.contains(value)){
                    // 真实行为访问 后
                    return method.invoke(bookPrivilegesService, args);
                }else{
                    throw new RuntimeException("用户权限不够！");
                }
            }
        });
        //返回代理对象
        return ProxyBookPrivilegesService;
    }

}
