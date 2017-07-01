package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:06
 * email:727933147@qq.com
 */

public class V2DirTreeData
        implements Serializable {
    private static final long serialVersionUID = 6006401887311747952L;
    private Long childId;
    private Date createTime;
    private Long id;
    private Integer orderId;
    private Long parentId;
    private Integer type;
    private Date updateTime;

    public V2DirTreeData(Long paramLong1, Long paramLong2, Long paramLong3, Integer paramInteger1, Integer paramInteger2, Date paramDate1, Date paramDate2) {
        this.id = paramLong1;
        this.parentId = paramLong2;
        this.childId = paramLong3;
        this.type = paramInteger1;
        this.orderId = paramInteger2;
        this.createTime = paramDate1;
        this.updateTime = paramDate2;
    }

    public Long getChildId() {
        return this.childId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Long getId() {
        return this.id;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public Integer getType() {
        return this.type;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setChildId(Long paramLong) {
        this.childId = paramLong;
    }

    public void setCreateTime(Date paramDate) {
        this.createTime = paramDate;
    }

    public void setId(Long paramLong) {
        this.id = paramLong;
    }

    public void setOrderId(Integer paramInteger) {
        this.orderId = paramInteger;
    }

    public void setParentId(Long paramLong) {
        this.parentId = paramLong;
    }

    public void setType(Integer paramInteger) {
        this.type = paramInteger;
    }

    public void setUpdateTime(Date paramDate) {
        this.updateTime = paramDate;
    }
}

