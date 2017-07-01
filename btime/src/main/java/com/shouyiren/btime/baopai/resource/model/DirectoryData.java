package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:31
 * email:727933147@qq.com
 */

public class DirectoryData
        implements Serializable {
    private static final long serialVersionUID = 8720406648513065311L;
    private String avatar;
    private List<DirectoryData> childDirectories;
    private Date createTime;
    private String description;
    private Integer focused;
    private Long id;
    private String name;
    private Long parentId;
    private Integer sortBy;
    private List<StaticPasterNewData> staticPasters;
    private Integer status;
    private Integer type;
    private Date updateTime;

    public DirectoryData() {
    }

    public DirectoryData(Long paramLong1, String paramString1, String paramString2, String paramString3, Integer paramInteger1, Date paramDate1, Date paramDate2, Long paramLong2, Integer paramInteger2, Integer paramInteger3) {
        this.id = paramLong1;
        this.name = paramString1;
        this.description = paramString2;
        this.avatar = paramString3;
        this.sortBy = paramInteger1;
        this.createTime = paramDate1;
        this.updateTime = paramDate2;
        this.parentId = paramLong2;
        this.type = paramInteger2;
        this.focused = paramInteger3;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public List<DirectoryData> getChildDirectories() {
        return this.childDirectories;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getFocused() {
        return this.focused;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public Integer getSortBy() {
        return this.sortBy;
    }

    public List<StaticPasterNewData> getStaticPasters() {
        return this.staticPasters;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Integer getType() {
        return this.type;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setAvatar(String paramString) {
        this.avatar = paramString;
    }

    public void setChildDirectories(List<DirectoryData> paramList) {
        this.childDirectories = paramList;
    }

    public void setCreateTime(Date paramDate) {
        this.createTime = paramDate;
    }

    public void setDescription(String paramString) {
        this.description = paramString;
    }

    public void setFocused(Integer paramInteger) {
        this.focused = paramInteger;
    }

    public void setId(Long paramLong) {
        this.id = paramLong;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setParentId(Long paramLong) {
        this.parentId = paramLong;
    }

    public void setSortBy(Integer paramInteger) {
        this.sortBy = paramInteger;
    }

    public void setStaticPasters(List<StaticPasterNewData> paramList) {
        this.staticPasters = paramList;
    }

    public void setStatus(Integer paramInteger) {
        this.status = paramInteger;
    }

    public void setType(Integer paramInteger) {
        this.type = paramInteger;
    }

    public void setUpdateTime(Date paramDate) {
        this.updateTime = paramDate;
    }
}

