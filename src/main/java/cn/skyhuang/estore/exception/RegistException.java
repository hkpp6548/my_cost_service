package cn.skyhuang.estore.exception;

/** 注册自定义异常
 * Created by dahoufang the one on 2017/10/30.
 */
public class RegistException extends Exception{
    public RegistException() {
        super();
    }

    public RegistException(String message) {
        super(message);
    }

    public RegistException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistException(Throwable cause) {
        super(cause);
    }

    protected RegistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
