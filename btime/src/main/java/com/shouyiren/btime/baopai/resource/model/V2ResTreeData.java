package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:07
 * email:727933147@qq.com
 */

public class V2ResTreeData
        implements Serializable {
    private static final long serialVersionUID = -3881769493621611362L;
    private Date createTime;
    private String desc;
    private Long dirId;
    private Long id;
    private Integer orderId;
    private Long resId;
    private String title;
    private Date updateTime;

    public V2ResTreeData(Long paramLong1, Long paramLong2, Long paramLong3, Integer paramInteger, String paramString1, String paramString2, Date paramDate1, Date paramDate2) {
        this.id = paramLong1;
        this.resId = paramLong2;
        this.dirId = paramLong3;
        this.orderId = paramInteger;
        this.title = paramString1;
        this.desc = paramString2;
        this.createTime = paramDate1;
        this.updateTime = paramDate2;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getDesc() {
        return this.desc;
    }

    public Long getDirId() {
        return this.dirId;
    }

    public Long getId() {
        return this.id;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public Long getResId() {
        return this.resId;
    }

    public String getTitle() {
        return this.title;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setCreateTime(Date paramDate) {
        this.createTime = paramDate;
    }

    public void setDesc(String paramString) {
        this.desc = paramString;
    }

    public void setDirId(Long paramLong) {
        this.dirId = paramLong;
    }

    public void setId(Long paramLong) {
        this.id = paramLong;
    }

    public void setOrderId(Integer paramInteger) {
        this.orderId = paramInteger;
    }

    public void setResId(Long paramLong) {
        this.resId = paramLong;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setUpdateTime(Date paramDate) {
        this.updateTime = paramDate;
    }
}

