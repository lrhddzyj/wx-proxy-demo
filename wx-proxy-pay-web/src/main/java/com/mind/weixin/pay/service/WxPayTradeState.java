package com.mind.weixin.pay.service;

public enum WxPayTradeState {
    SUCCESS("支付成功"), REFUND("转入退款"), NOTPAY("未支付"),
    CLOSED("已关闭"), REVOKED("已撤销") , USERPAYING("用户支付中");

    private String value;

    WxPayTradeState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}