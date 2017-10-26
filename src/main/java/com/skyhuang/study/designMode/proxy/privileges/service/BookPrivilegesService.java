package com.skyhuang.study.designMode.proxy.privileges.service;

import com.skyhuang.study.designMode.proxy.privileges.annotation.BookprivilegesAnnotation;
import com.skyhuang.study.program.weightRecord.domain.User;

/** book-service 接口
 * Created by dahoufang the one on 2017/10/26.
 */
public interface BookPrivilegesService {

    @BookprivilegesAnnotation("新增图书") //用于判断用户是否有权限进行这个方法的访问
    public void add(User user);
    @BookprivilegesAnnotation("删除图书")
    public void delete(User user);
    @BookprivilegesAnnotation("更新图书")
    public void update(User user);
    //@BookprivilegesAnnotation("查询图书")
    public void search(User user);

}
