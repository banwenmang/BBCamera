package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:39
 * email:727933147@qq.com
 * <p>
 * 动态贴纸
 */

public class DynamicPasterData
        implements Serializable {
    private static final long serialVersionUID = 7149255047547444819L;
    private String des;
    private Long dpId;
    private Short landscape;
    private Long order;
    private String picture;
    private String secret;
    private Short status;
    private String title;
    private Date updateTime;
    private String url;

    public DynamicPasterData() {
    }

    public DynamicPasterData(Long paramLong1, String paramString1, String paramString2, String paramString3, Long paramLong2, String paramString4, String paramString5, Short paramShort, Date paramDate) {
        this.dpId = paramLong1;
        this.title = paramString1;
        this.picture = paramString2;
        this.url = paramString3;
        this.order = paramLong2;
        this.des = paramString4;
        this.secret = paramString5;
        this.landscape = paramShort;
        this.updateTime = paramDate;
    }

    public String getDes() {
        return this.des;
    }

    public Long getDpId() {
        return this.dpId;
    }

    public Short getLandscape() {
        return this.landscape;
    }

    public Long getOrder() {
        return this.order;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getSecret() {
        return this.secret;
    }

    public Short getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public String getUrl() {
        return this.url;
    }

    public void setDes(String paramString) {
        this.des = paramString;
    }

    public void setDpId(Long paramLong) {
        this.dpId = paramLong;
    }

    public void setLandscape(Short paramShort) {
        this.landscape = paramShort;
    }

    public void setOrder(Long paramLong) {
        this.order = paramLong;
    }

    public void setPicture(String paramString) {
        this.picture = paramString;
    }

    public void setSecret(String paramString) {
        this.secret = paramString;
    }

    public void setStatus(Short paramShort) {
        this.status = paramShort;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setUpdateTime(Date paramDate) {
        this.updateTime = paramDate;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }
}

