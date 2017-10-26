package com.skyhuang.study.genericsReflection;

import com.skyhuang.study.program.weightRecord.domain.User;

/** 测试泛型反射 为之后的框架做准备
 * Created by hk on 2017/10/26.
 */
public class GenericsReflectionTest {

    public static void main(String[] args) {
        BaseDao dao = new UserDaoImpl();
        dao.selectById(1);
        User user = new User();
        dao.add(user);
    }

}
