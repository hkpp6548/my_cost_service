package com.skuhuang.web.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.skyhuang.domain.User;
import org.apache.struts2.ServletActionContext;

/** 登录拦截器
 * Created by hk on 2017/11/18.
 */
public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation invocation) throws Exception {
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        if (user == null) {
            // 没有登录
            ActionSupport action = (ActionSupport) invocation.getAction();
            action.addActionError("用户未登录");
            return Action.LOGIN;
        } else {
            // 登录了
            return invocation.invoke();
        }
    }
}
