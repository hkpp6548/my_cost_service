package cn.skyhuang.estore.exception;

/** 激活码自定义异常
 * Created by dahoufang the one on 2017/10/30.
 */
public class ActiveCodeException extends RuntimeException{
    public ActiveCodeException() {
        super();
    }

    public ActiveCodeException(String message) {
        super(message);
    }

    public ActiveCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActiveCodeException(Throwable cause) {
        super(cause);
    }

    protected ActiveCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
