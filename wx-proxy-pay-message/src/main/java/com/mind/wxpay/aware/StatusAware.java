package com.mind.wxpay.aware;

/**
 * 返回的基础状态信息
 * Created by serv on 2015/1/27.
 */
public interface StatusAware {
    public String getReturnCode() ;

    public String getReturnMsg();

    public String getResultCode();

    public String getErrCode() ;

    public String getErrCodeDes();

}
