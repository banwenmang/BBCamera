package com.shouyiren.btime.webser.config.api;

import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:48
 * email:727933147@qq.com
 */

public class Config {
    private Integer conid;
    private Date createTime;
    private String description;
    private String name;
    private String value;
    private Integer valueType;

    public Integer getConid() {
        return this.conid;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public Integer getValueType() {
        return this.valueType;
    }

    public void setConid(Integer paramInteger) {
        this.conid = paramInteger;
    }

    public void setCreateTime(Date paramDate) {
        this.createTime = paramDate;
    }

    public void setDescription(String paramString) {
        if (paramString == null) {
        }
        for (paramString = null; ; paramString = paramString.trim()) {
            this.description = paramString;
            return;
        }
    }

    public void setName(String paramString) {
        if (paramString == null) {
        }
        for (paramString = null; ; paramString = paramString.trim()) {
            this.name = paramString;
            return;
        }
    }

    public void setValue(String paramString) {
        if (paramString == null) {
        }
        for (paramString = null; ; paramString = paramString.trim()) {
            this.value = paramString;
            return;
        }
    }

    public void setValueType(Integer paramInteger) {
        this.valueType = paramInteger;
    }
}

