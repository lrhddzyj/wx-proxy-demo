package com.mind.weixin.pay.vo;

import java.io.Serializable;

/**
 * Created by lrh on 2015/12/14.
 */
public class SendRedPackVo implements Serializable {


    /**
     * 企业id
     */
    private String companyId;

    /**
     * 企业的appid
     */
    private String appId;

    /**
     * 发送用户的openId
     */
    private String openId;

    /**
     * 金额（单位 分）
     */
    private int totalAmount;


    /**
     * 活动名称
     */
    private String actName;


    /**
     * 祝福语
     */
    private String wishing;


    /**
     * 应用标示
     */
    private String appCode;

    /**
     * 业务标示
     */
    private String businessId;


    /**
     * 备注
     */
    private String remark;


    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getWishing() {
        return wishing;
    }

    public void setWishing(String wishing) {
        this.wishing = wishing;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
}
