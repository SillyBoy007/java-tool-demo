package com.example.excel.domain;

import com.example.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

/**
 * @author wangxiayun
 * @since 2019-04-09
 */
public class FollowBaseVO {
    /**
     * 用户编码
     */
    @Excel(name = "用户编号")
    private Long userCode;

    /**
     * 店铺编码
     */
    @Excel(name = "店铺编码")
    private Long storeCode;

    /**
     * 店铺名称
     */
    @Excel(name = "店铺名称")
    private String storeName;

    /**
     * 店铺logo
     */
    @Excel(name = "店铺logo")
    private String storeLogo;

    /**
     * 商家编码
     */
    @Excel(name = "商家编码")
    private Long sellerCode;

    /**
     * 店铺店主的用户编码
     */
    @Excel(name = "店铺店主的用户编码")
    private Long followUserCode;

    /**
     * 是否被对方关注
     */
    @Excel(name = "是否被对方关注")
    private Boolean isBoth;

    /**
     * 关注用户头像
     */
    @Excel(name = "关注用户头像")
    private String followAvatar;

    /**
     * 关注用户昵称
     */
    @Excel(name = "关注用户昵称")
    private String followNickName;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Excel(name = "加好友时间")
    private Date createTime;


    public Long getUserCode() {
        return userCode;
    }

    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    public Long getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(Long storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo;
    }

    public Long getSellerCode() {
        return sellerCode;
    }

    public void setSellerCode(Long sellerCode) {
        this.sellerCode = sellerCode;
    }

    public Long getFollowUserCode() {
        return followUserCode;
    }

    public void setFollowUserCode(Long followUserCode) {
        this.followUserCode = followUserCode;
    }

    public Boolean getBoth() {
        return isBoth;
    }

    public void setBoth(Boolean both) {
        isBoth = both;
    }



    public String getFollowAvatar() {
        return followAvatar;
    }

    public void setFollowAvatar(String followAvatar) {
        this.followAvatar = followAvatar;
    }

    public String getFollowNickName() {
        return followNickName;
    }

    public void setFollowNickName(String followNickName) {
        this.followNickName = followNickName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
