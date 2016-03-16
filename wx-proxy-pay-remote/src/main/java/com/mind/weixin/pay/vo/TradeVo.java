package com.mind.weixin.pay.vo;


import java.io.Serializable;

/**
 * 请求支付的参数
 */
public class TradeVo implements Serializable{

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 主平台商家id (必填)
     */
    private String shopId;
    /**
     * 门店ID(必填)
     */
    private String storeId;

    /**
     * 外部系统id，预留扩展 (必填)
     */
    private String businessSystemId;

    /**
     * 设备号 (线下支付必填)
     */
    private String deviceInfo;
    /**
     * 总金额(单位:分) (必填)
     */
    private int totalFee;
    /**
     * 商品描述 (必填)
     */
    private String body;
    /**
     * 附加数据 (必填)
     */
    private String attach;

    /** 商品标记， 代金券或立减优惠 功能的参数 */
    private String goodsTag;

    /**
     * 商品id (必填)
     */
    private String productId;

    /**
     * 操作者id
     */
    private String opUserId;
    /**
     * 用户在商户 appid 下的唯一
       标识， trade_type为JSAPI时 ，
       此参数必传
     */
    private String openId;

    /**
     * 交易类型 (必填)
     */
    private String tradeType;

    /**
     * ip地址
     */
    private String spbillCreateIp = "127.0.0.1";

    /**
     * 小额支付的授权码 (小额支付必填)
     */
    private String authCode;

    /**
     * 应用的唯一标识 (必填)
     */
    private String appCode;

    /**
     * 微信支付成功回调URL (线上支付必填)
     */
    private String successCallbackUrl;

    /**
     *  微信支付失败回调URL (线上支付必填)
     */
    private String errCallbackUrl;

    /**
     * 微信支付取消回调URL (线上支付必填)
     */
    private String cancelCallbackUrl;


    //=======================method======================================================


    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getBusinessSystemId() {
        return businessSystemId;
    }

    public void setBusinessSystemId(String businessSystemId) {
        this.businessSystemId = businessSystemId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(String opUserId) {
        this.opUserId = opUserId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getSuccessCallbackUrl() {
        return successCallbackUrl;
    }

    public void setSuccessCallbackUrl(String successCallbackUrl) {
        this.successCallbackUrl = successCallbackUrl;
    }

    public String getErrCallbackUrl() {
        return errCallbackUrl;
    }

    public void setErrCallbackUrl(String errCallbackUrl) {
        this.errCallbackUrl = errCallbackUrl;
    }

    public String getCancelCallbackUrl() {
        return cancelCallbackUrl;
    }

    public void setCancelCallbackUrl(String cancelCallbackUrl) {
        this.cancelCallbackUrl = cancelCallbackUrl;
    }
}
