package cn.skyhuang.estore.service;

import cn.skyhuang.estore.dao.UserDao;
import cn.skyhuang.estore.domain.User;
import cn.skyhuang.estore.exception.ActiveCodeException;
import cn.skyhuang.estore.exception.LoginException;
import cn.skyhuang.estore.exception.RegistException;
import cn.skyhuang.estore.utils.SendEmailUtil;
import cn.skyhuang.estore.utils.StringStaticUtils;
import cn.skyhuang.estore.utils.UuidUtils;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * 用户service
 * Created by dahoufang the one on 2017/10/28.
 */
public class UserService {

    /**
     * 用户注册服务
     * @param user
     * @throws RegistException
     */
    public void regist(User user) throws RegistException {
        UserDao dao = new UserDao();
        //注册
        try {
            user.setState(StringStaticUtils.USER_STATE_0);
            //设置用户的角色，注册用户全部是user
            user.setRole(StringStaticUtils.USER_ROLE_USER);
            //设置邮件校验码
            user.setActivecode(UuidUtils.getUuid());
            //设置注册时间（用于激活码时间判断）
            user.setUpdatetime(new Timestamp(System.currentTimeMillis()));
            dao.add(user);
            //邮件内容
            String emailMsg = "注册成功，请<a href='http://localhost:8080/user?method=active&activeCode="
                    + user.getActivecode() + "'>激活</a>,激活码为:" + user.getActivecode();
            //发送邮件
            SendEmailUtil.sendMail(user.getEmail(), emailMsg);
        } catch (SQLException e) {
            e.printStackTrace();
            //抛出自定义注册异常
            throw new RegistException("注册失败！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 激活用户
     * @param activeCode
     * @throws SQLException
     */
    public void activeUser(String activeCode) throws SQLException {
        UserDao dao = new UserDao();
        User user = dao.selectUserByActiveCode(activeCode);
        if (user != null) {
            long time = System.currentTimeMillis() - user.getUpdatetime().getTime();
            //时间不能超过一天
            if (time <= 24 * 60 * 1000 * 60) {
                // 激活
                dao.activeUser(activeCode);
            } else {
                throw new ActiveCodeException("激活码过期");
            }
        } else {
            throw new ActiveCodeException("用户不存在");
        }
    }

    /**
     * 根据用户名查找用户
     *
     * @param user
     * @return
     * @throws SQLException
     */
    public User selectUserByUsername(User user) throws SQLException {
        UserDao dao = new UserDao();
        return dao.selectUserByUsername(user);
    }

    /**
     *  用户登录验证操作
     * @param username
     * @param password
     * @return
     * @throws LoginException
     */
    public User login(String username, String password) throws LoginException {
        UserDao dao = new UserDao();
        try {
            User user = dao.selectUserByUsernameAndPassword(username, password);
            if (user != null) {
                // 判断用户是否激活
                if (user.getState() == 1) {
                    return user;
                } else {
                    throw new ActiveCodeException("用户未激活");
                }
            } else {
                throw new LoginException("用户名或密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginException("用户名或密码错误！");
        }
    }
}
