package cn.skyhuang.estore.utils;

/** 静态类帮助工具
 * Created by dahoufang the one on 2017/10/28.
 */
public class StringStaticUtils {

    /** 用户角色-user */
    public static final String USER_ROLE_USER = "user";

    /** 用户激活状态 0:未激活 */
    public static final int USER_STATE_0 = 0;

    /** 用户激活状态 1:激活 */
    public static final int USER_STATE_1 = 1;

    /** 订单状态 0:未支付 */
    public static final int ORDER_PAYSTATE_0 = 0;

    /** 订单状态 1:已支付 */
    public static final int ORDER_PAYSTATE_1 = 1;

    /** servlet请求参数:method */
    public static final String PARAM_METHOD = "method";

    /** jsp页面：注册页面 */
    public static final String JSP_REGIST = "regist.jsp";

    /** session:  session_checkcode */
    public static final String SESSION_CHECKCODE = "session_checkcode";

    /** cookie: 是否记住用户名  remember */
    public static final String COOKIE_REMEMBER = "remember";

    /** cookie: 是否自动登录  autologin */
    public static final String COOKIE_AUTOLOGIN = "autologin";

    /** cookie的有效时间： 10天 */
    public static final int COOKIE_MAXDAY_10 = 10 * 24 * 60 * 60;

    /** cookie的有效时间： 0天 */
    public static final int COOKIE_MAXDAY_0 = 0;

    /** 项目地址路径 */
    public static final String HOME_PATH = "http://localhost:8080";


}
