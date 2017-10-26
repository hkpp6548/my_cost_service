package com.skyhuang.study.designMode.proxy.privileges.service;

import com.skyhuang.study.program.weightRecord.domain.User;

/** 模拟的假操作
 * Created by dahoufang the one on 2017/10/26.
 */
public class BookPrivilegesServiceImpl implements BookPrivilegesService {

    public void add(User user) {
        System.out.println(user.getUsername() + "add操作！");
    }

    public void delete(User user) {
        System.out.println(user.getUsername() + "delete操作！");
    }

    public void update(User user) {
        System.out.println(user.getUsername() + "update操作！");
    }

    public void search(User user) {
        System.out.println(user.getUsername() + "search操作！");
    }

}
