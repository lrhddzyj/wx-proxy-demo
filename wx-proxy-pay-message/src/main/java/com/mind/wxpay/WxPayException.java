package com.mind.wxpay;

/**
 * Created by serv on 2014/12/3.
 */
public class WxPayException extends RuntimeException {

    private final int errorCode;

    public WxPayException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public WxPayException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
