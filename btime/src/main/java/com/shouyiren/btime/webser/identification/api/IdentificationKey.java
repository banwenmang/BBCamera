package com.shouyiren.btime.webser.identification.api;


import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:50
 * email:727933147@qq.com
 */

public class IdentificationKey
        implements Serializable {
    private static final long serialVersionUID = -4724356384716584714L;
    private Date addTime;
    private String phone;
    private String secret;
    private Date updateTime;

    public Date getAddTime() {
        return this.addTime;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getSecret() {
        return this.secret;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setAddTime(Date paramDate) {
        this.addTime = paramDate;
    }

    public void setPhone(String paramString) {
        this.phone = paramString;
    }

    public void setSecret(String paramString) {
        this.secret = paramString;
    }

    public void setUpdateTime(Date paramDate) {
        this.updateTime = paramDate;
    }
}

