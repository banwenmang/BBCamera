package com.shouyiren.btime.webser.identification.api;


import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:51
 * email:727933147@qq.com
 */

public class IdentificationSmsLog
        implements Serializable {
    private static final long serialVersionUID = -6425455354358738376L;
    private Date addTime;
    private Long id;
    private String phone;
    private String secret;

    public Date getAddTime() {
        return this.addTime;
    }

    public Long getId() {
        return this.id;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setAddTime(Date paramDate) {
        this.addTime = paramDate;
    }

    public void setId(Long paramLong) {
        this.id = paramLong;
    }

    public void setPhone(String paramString) {
        this.phone = paramString;
    }

    public void setSecret(String paramString) {
        this.secret = paramString;
    }
}

