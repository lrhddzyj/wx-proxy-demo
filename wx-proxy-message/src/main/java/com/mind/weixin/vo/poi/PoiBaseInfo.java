package com.mind.weixin.vo.poi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2015/6/10.
 */
public class PoiBaseInfo implements Serializable {

    /**
     * 商户自己的id，用于后续审核通过收到poi_id 的通知时，做对应关系。请商户自己保证唯一识别性
     * 是否必填 否
     */
    @JsonProperty("sid")
    private String sid;

    /**
     * 门店名称（仅为商户名，如：国美、麦当劳，不应包含地区、店号等信息，错误示例：北京国美）
     * 是否必填 是
     */
    @JsonProperty("business_name")
    private String businessName ;
    /**
     * 分店名称（不应包含地区信息、不应与门店名重复，错误示例：北京王府井店）
     是否必填 否
     */
    @JsonProperty("branch_name")
    private String branchName;

    /**
     *  门店所在的省份（直辖市填城市名,如：北京市）
     *  是否必填 是
     */
    @JsonProperty("province")
    private String province ;
    /**
     *  门店所在的城市
     *  是否必填 是
     */
    @JsonProperty("city")
    private String city;
    /**
     *  门店所在地区
     *  是否必填 否
     */
    @JsonProperty("district")
    private String district;
    /**
     * 门店所在的详细街道地址（不要填写省市信息）
     * 是否必填 是
     */
    @JsonProperty("address")
    private String address ;
    /**
     *  门店的电话（纯数字，区号、分机号均由“-”隔开）
     *  是否必填 是
     */
    @JsonProperty("telephone")
    private String telephone ;

    /**
     * 门店的类型（详细分类参见分类附表，不同级分类用“,”隔开，如：美食，川菜，火锅）
     * 是否必填 是
     */
    @JsonProperty("categories")
    private String[] categories;

    /**
     *  坐标类型，1 为火星坐标（目前只能选1）
     *  是否必填 是
     */
    @JsonProperty("offset_type")
    private String offsetType;
    /**
     * 门店所在地理位置的经度
     * 是否必填 是
     */
    @JsonProperty("longitude")
    private String longitude ;

    /**
     * 门店所在地理位置的纬度（经纬度均为火星坐标，最好选用腾讯地图标记的坐标）
     * 是否必填 是
     */
    @JsonProperty("latitude")
    private String latitude;

    /**
     * 图片列表，url 形式，可以有多张图片，尺寸为640*340px。必须为上一接口生成的url
     * 是否必填 是
     */
    @JsonProperty("photo_list")
    private List<PoiPhoto> photoList ;

    /**
     * 推荐品，餐厅可为推荐菜；酒店为推荐套房；景点为推荐游玩景点等，针对自己行业的推荐内容
     * 是否必填 否
     */
    @JsonProperty("recommend")
    private String recommend;

    /**
     * 特色服务，如免费wifi，免费停车，送货上门等商户 能提供的特色功能或服务
     * 是否必填是
     */
    @JsonProperty("special")
    private String special;

    /**
     *  商户简介，主要介绍商户信息等
     *  是否必填 否
     */
    @JsonProperty("introduction")
    private String introduction ;
    /**
     *  营业时间，24 小时制表示，用“-”连接，如8:00-20:00
     *  是否必填 是
     */
    @JsonProperty("open_time")
    private String openTime ;

    /**
     * 人均价格，大于0 的整数
     * 是否必填 否
     */
    @JsonProperty("avg_price")
    private String avgPrice ;

    /**
     * 获取列表时的字段
     * 门店是否可用状态。1 表示系统错误、2 表示审核中、3 审核通过、4 审核驳回。当该字段为1、2、4 状态时，poi_id 为空
     */
    @JsonProperty("available_state")
    private String availableState ;

    /**
     * 获取列表时的字段
     * 扩展字段是否正在更新中。1 表示扩展字段正在更新中，尚未生效，不允许再次更新； 0 表示扩展字段没有在更新中或更新已生效，可以再次更新
     */
    @JsonProperty("update_status")
    private String updateStatus;

    @JsonProperty("poi_id")
    private String poiId;


    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getOffsetType() {
        return offsetType;
    }

    public void setOffsetType(String offsetType) {
        this.offsetType = offsetType;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public List<PoiPhoto> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PoiPhoto> photoList) {
        this.photoList = photoList;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getAvailableState() {
        return availableState;
    }

    public void setAvailableState(String availableState) {
        this.availableState = availableState;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }
}
