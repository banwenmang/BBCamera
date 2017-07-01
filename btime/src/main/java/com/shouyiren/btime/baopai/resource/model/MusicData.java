package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:35
 * email:727933147@qq.com
 */

public class MusicData
        implements Serializable {
    private static final long serialVersionUID = -6643192643889333515L;
    private String des;
    private Long musicId;
    private Long order;
    private String picture;
    private String secret;
    private Short status;
    private String style;
    private String title;
    private Short type;
    private Date updateTime;
    private String url;

    public MusicData() {
    }

    public MusicData(Long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong2, String paramString5, Date paramDate, String paramString6, Short paramShort) {
        this.musicId = paramLong1;
        this.title = paramString1;
        this.picture = paramString2;
        this.url = paramString3;
        this.des = paramString4;
        this.order = paramLong2;
        this.secret = paramString5;
        this.updateTime = paramDate;
        this.style = paramString6;
        this.type = paramShort;
    }

    public String getDes() {
        return this.des;
    }

    public Long getMusicId() {
        return this.musicId;
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

    public String getStyle() {
        return this.style;
    }

    public String getTitle() {
        return this.title;
    }

    public Short getType() {
        return this.type;
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

    public void setMusicId(Long paramLong) {
        this.musicId = paramLong;
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

    public void setStyle(String paramString) {
        this.style = paramString;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setType(Short paramShort) {
        this.type = paramShort;
    }

    public void setUpdateTime(Date paramDate) {
        this.updateTime = paramDate;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }
}

