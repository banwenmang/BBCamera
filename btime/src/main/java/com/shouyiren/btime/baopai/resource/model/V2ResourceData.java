package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:06
 * email:727933147@qq.com
 */

public class V2ResourceData
        implements Serializable {
    private static final long serialVersionUID = -4394364336802260888L;
    private String avatar;
    private Date createTime;
    private String desc;
    private String name;
    private Integer orderId;
    private Long resId;
    private String secret;
    private Integer status;
    private String title;
    private Integer type;
    private Date updateTime;
    private String url;
    private String userData;

    public V2ResourceData() {
    }

    public V2ResourceData(Long paramLong, Integer paramInteger1, String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger2, String paramString5, Date paramDate1, Date paramDate2) {
        this.resId = paramLong;
        this.type = paramInteger1;
        this.name = paramString1;
        this.avatar = paramString2;
        this.url = paramString3;
        this.userData = paramString4;
        this.status = paramInteger2;
        this.secret = paramString5;
        this.createTime = paramDate1;
        this.updateTime = paramDate2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public Long getResId() {
        return this.resId;
    }

    public String getSecret() {
        return this.secret;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getType() {
        return this.type;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserData() {
        return this.userData;
    }

    public void setAvatar(String paramString) {
        this.avatar = paramString;
    }

    public void setCreateTime(Date paramDate) {
        this.createTime = paramDate;
    }

    public void setDesc(String paramString) {
        this.desc = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOrderId(Integer paramInteger) {
        this.orderId = paramInteger;
    }

    public void setResId(Long paramLong) {
        this.resId = paramLong;
    }

    public void setSecret(String paramString) {
        this.secret = paramString;
    }

    public void setStatus(Integer paramInteger) {
        this.status = paramInteger;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setType(Integer paramInteger) {
        this.type = paramInteger;
    }

    public void setUpdateTime(Date paramDate) {
        this.updateTime = paramDate;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }

    public void setUserData(String paramString) {
        this.userData = paramString;
    }
}

