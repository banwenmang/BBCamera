package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:35
 * email:727933147@qq.com
 */

public class MvTemplateData
        implements Serializable {
    private static final long serialVersionUID = 509527987768510020L;
    private String des;
    private Short landscape;
    private String music;
    private Long order;
    private String picture;
    private String secret;
    private Short status;
    private Long templateId;
    private String title;
    private Short type;
    private Date updateTime;
    private String url;

    public MvTemplateData() {
    }

    public MvTemplateData(Long paramLong1, String paramString1, String paramString2, String paramString3, Short paramShort1, Long paramLong2, String paramString4, String paramString5, Date paramDate, Short paramShort2, String paramString6) {
        this.templateId = paramLong1;
        this.title = paramString1;
        this.picture = paramString2;
        this.url = paramString3;
        this.landscape = paramShort1;
        this.order = paramLong2;
        this.des = paramString4;
        this.secret = paramString5;
        this.updateTime = paramDate;
        this.type = paramShort2;
        this.music = paramString6;
    }

    public String getDes() {
        return this.des;
    }

    public Short getLandscape() {
        return this.landscape;
    }

    public String getMusic() {
        return this.music;
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

    public Long getTemplateId() {
        return this.templateId;
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

    public void setLandscape(Short paramShort) {
        this.landscape = paramShort;
    }

    public void setMusic(String paramString) {
        this.music = paramString;
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

    public void setTemplateId(Long paramLong) {
        this.templateId = paramLong;
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

