package com.mind.wxpay.response;

import java.io.Serializable;

/**
 * 代金券
 * Created by serv on 2015/1/27.
 */
public class Coupon implements Serializable{

    /** 代金券或立减优惠 批次 ID */
    private String couponBatchId;

    /** 代金券或立减优惠 ID */
    private String couponId ;

    /** 代金券或立减优惠 支付金额  */
    private String couponFee ;

    public String getCouponBatchId() {
        return couponBatchId;
    }

    public void setCouponBatchId(String couponBatchId) {
        this.couponBatchId = couponBatchId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(String couponFee) {
        this.couponFee = couponFee;
    }
}
