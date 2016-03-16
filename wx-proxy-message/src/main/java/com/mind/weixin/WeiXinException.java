package com.mind.weixin;

/**
 * Created by rocky on 2014/7/22.
 */
public class WeiXinException extends RuntimeException {

    private int errorCode;

    public WeiXinException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public WeiXinException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public WeiXinException(Throwable throwable) {
        super(throwable);
    }

    public int getErrorCode() {
        return errorCode;
    }

}
