package com.mind.wxpay.response;

import java.io.Serializable;
import java.util.List;

/**
 * 退款详情
 * Created by serv on 2015/1/27.
 */
public class Refund implements Serializable {

    /** 微信退款单号 */
    private String refundId ;

    /** 商户退款单号 */
    private String outRefundNo ;

    /** 退款渠道 */
    private String refundChannel ;

    /** 退款金额 */
    private String refundFee ;

    /** 退款状态 */
    private String refundStatus ;

    /** 代金券或立减优惠 退款金额 */
    private String couponRefundFee ;

    /** 代金券或立减优惠 使用数量  */
    private int couponRefundCount ;

    /** 代金券或立减优惠 列表  */
    private List<Coupon> couponRefundList ;

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel(String refundChannel) {
        this.refundChannel = refundChannel;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getCouponRefundFee() {
        return couponRefundFee;
    }

    public void setCouponRefundFee(String couponRefundFee) {
        this.couponRefundFee = couponRefundFee;
    }

    public int getCouponRefundCount() {
        return couponRefundCount;
    }

    public void setCouponRefundCount(int couponRefundCount) {
        this.couponRefundCount = couponRefundCount;
    }

    public List<Coupon> getCouponRefundList() {
        return couponRefundList;
    }

    public void setCouponRefundList(List<Coupon> couponRefundList) {
        this.couponRefundList = couponRefundList;
    }
}
