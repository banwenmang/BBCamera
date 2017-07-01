package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:03
 * email:727933147@qq.com
 */

public class StaticPasterNewData
        implements Serializable {
    private static final long serialVersionUID = 2060876449306992346L;
    private String author;
    private String des;
    private String example;
    private Integer order;
    private String picture;
    private String secret;
    private String series;
    private Long spId;
    private Integer status;
    private Integer subtype;
    private String title;
    private Integer type;
    private Date updateTime;
    private String url;

    public StaticPasterNewData() {
    }

    public StaticPasterNewData(Long paramLong, Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger3, String paramString5, String paramString6, Integer paramInteger4, String paramString7, Date paramDate, String paramString8) {
        this.spId = paramLong;
        this.type = paramInteger1;
        this.subtype = paramInteger2;
        this.series = paramString1;
        this.title = paramString2;
        this.author = paramString3;
        this.example = paramString4;
        this.status = paramInteger3;
        this.picture = paramString5;
        this.url = paramString6;
        this.order = paramInteger4;
        this.des = paramString7;
        this.updateTime = paramDate;
        this.secret = paramString8;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getDes() {
        return this.des;
    }

    public String getExample() {
        return this.example;
    }

    public Integer getOrder() {
        return this.order;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getSeries() {
        return this.series;
    }

    public Long getSpId() {
        return this.spId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer getSubtype() {
        return this.subtype;
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

    public int hashCode() {
        return super.hashCode();
    }

    public void setAuthor(String paramString) {
        this.author = paramString;
    }

    public void setDes(String paramString) {
        this.des = paramString;
    }

    public void setExample(String paramString) {
        this.example = paramString;
    }

    public void setOrder(Integer paramInteger) {
        this.order = paramInteger;
    }

    public void setPicture(String paramString) {
        this.picture = paramString;
    }

    public void setSecret(String paramString) {
        this.secret = paramString;
    }

    public void setSeries(String paramString) {
        this.series = paramString;
    }

    public void setSpId(Long paramLong) {
        this.spId = paramLong;
    }

    public void setStatus(Integer paramInteger) {
        this.status = paramInteger;
    }

    public void setSubtype(Integer paramInteger) {
        this.subtype = paramInteger;
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

    public String toString() {
        return super.toString();
    }
}

