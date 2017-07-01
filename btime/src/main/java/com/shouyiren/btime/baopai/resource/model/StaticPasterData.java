package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:03
 * email:727933147@qq.com
 */

public class StaticPasterData
        implements Serializable {
    private static final long serialVersionUID = 3766440526733630632L;
    private String des;
    private Short landscape;
    private Long order;
    private String picture;
    private String secret;
    private Long spId;
    private String thumbnail;
    private String title;
    private Date updateTime;
    private String url;

    public StaticPasterData() {
    }

    public StaticPasterData(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong2, String paramString5, String paramString6, Short paramShort, Date paramDate) {
        this.spId = paramLong1;
        this.title = paramString1;
        this.picture = paramString2;
        this.url = paramString3;
        this.thumbnail = paramString4;
        this.order = paramLong2;
        this.des = paramString5;
        this.secret = paramString6;
        this.landscape = paramShort;
        this.updateTime = paramDate;
    }

    public String getDes() {
        return this.des;
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

    public Long getSpId() {
        return this.spId;
    }

    public String getThumbnail() {
        return this.thumbnail;
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

    public void setSpId(Long paramLong) {
        this.spId = paramLong;
    }

    public void setThumbnail(String paramString) {
        this.thumbnail = paramString;
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

