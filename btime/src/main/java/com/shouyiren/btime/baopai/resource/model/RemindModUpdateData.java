package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:02
 * email:727933147@qq.com
 */

public class RemindModUpdateData
        implements Serializable {
    private static final long serialVersionUID = 4535969728230653073L;
    private Integer modId;
    private String name;
    private Byte status;
    private Date updateTime;

    public RemindModUpdateData() {
    }

    public RemindModUpdateData(Integer paramInteger, Byte paramByte, String paramString, Date paramDate) {
        this.modId = paramInteger;
        this.status = paramByte;
        this.name = paramString;
        this.updateTime = paramDate;
    }

    public Integer getModId() {
        return this.modId;
    }

    public String getName() {
        return this.name;
    }

    public Byte getStatus() {
        return this.status;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setModId(Integer paramInteger) {
        this.modId = paramInteger;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setStatus(Byte paramByte) {
        this.status = paramByte;
    }

    public void setUpdateTime(Date paramDate) {
        this.updateTime = paramDate;
    }
}

