package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:34
 * email:727933147@qq.com
 */

public class FilterData
        implements Serializable {
    private static final long serialVersionUID = 3501657127089593263L;
    private String des;
    private Long filterId;
    private Short landscape;
    private String picture;
    private String secret;
    private Long sortBy;
    private Short status;
    private String title;
    private Short type;
    private Date updateTime;
    private String url;

    public FilterData() {
    }

    public FilterData(Long paramLong1, String paramString1, String paramString2, String paramString3, Short paramShort1, Long paramLong2, String paramString4, Date paramDate, String paramString5, Short paramShort2) {
        this.filterId = paramLong1;
        this.title = paramString1;
        this.picture = paramString2;
        this.url = paramString3;
        this.landscape = paramShort1;
        this.sortBy = paramLong2;
        this.des = paramString4;
        this.updateTime = paramDate;
        this.secret = paramString5;
        this.type = paramShort2;
    }

    public String getDes() {
        return this.des;
    }

    public Long getFilterId() {
        return this.filterId;
    }

    public Short getLandscape() {
        return this.landscape;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getSecret() {
        return this.secret;
    }

    public Long getSortBy() {
        return this.sortBy;
    }

    public Short getStatus() {
        return this.status;
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

    public void setFilterId(Long paramLong) {
        this.filterId = paramLong;
    }

    public void setLandscape(Short paramShort) {
        this.landscape = paramShort;
    }

    public void setPicture(String paramString) {
        this.picture = paramString;
    }

    public void setSecret(String paramString) {
        this.secret = paramString;
    }

    public void setSortBy(Long paramLong) {
        this.sortBy = paramLong;
    }

    public void setStatus(Short paramShort) {
        this.status = paramShort;
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

