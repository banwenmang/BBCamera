package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:04
 * email:727933147@qq.com
 */

public class V2DirectoryData
        implements Serializable {
    private static final long serialVersionUID = 8473196709876890245L;
    private String avatar;
    private List<V2DirectoryData> childrenDirectories;
    private List<V2ResourceData> childrenResource;
    private Date createTime;
    private String desc;
    private Long dirId;
    private String name;
    private Integer orderId;
    private Integer status;
    private Date updateTime;

    public V2DirectoryData(Long paramLong, Integer paramInteger, String paramString1, String paramString2, String paramString3, Date paramDate1, Date paramDate2) {
        this.dirId = paramLong;
        this.status = paramInteger;
        this.name = paramString1;
        this.desc = paramString2;
        this.avatar = paramString3;
        this.createTime = paramDate1;
        this.updateTime = paramDate2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public List<V2DirectoryData> getChildrenDirectories() {
        return this.childrenDirectories;
    }

    public List<V2ResourceData> getChildrenResource() {
        return this.childrenResource;
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

    public String getName() {
        return this.name;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setAvatar(String paramString) {
        this.avatar = paramString;
    }

    public void setChildrenDirectories(List<V2DirectoryData> paramList) {
        this.childrenDirectories = paramList;
    }

    public void setChildrenResource(List<V2ResourceData> paramList) {
        this.childrenResource = paramList;
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

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOrderId(Integer paramInteger) {
        this.orderId = paramInteger;
    }

    public void setStatus(Integer paramInteger) {
        this.status = paramInteger;
    }

    public void setUpdateTime(Date paramDate) {
        this.updateTime = paramDate;
    }
}

