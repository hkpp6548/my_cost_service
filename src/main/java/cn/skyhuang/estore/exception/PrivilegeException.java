package cn.skyhuang.estore.exception;

/**
 * Created by hk on 2017/11/1.
 */
public class PrivilegeException extends RuntimeException {
    public PrivilegeException() {
        super();
    }

    public PrivilegeException(String message) {
        super(message);
    }

    public PrivilegeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrivilegeException(Throwable cause) {
        super(cause);
    }

    protected PrivilegeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
