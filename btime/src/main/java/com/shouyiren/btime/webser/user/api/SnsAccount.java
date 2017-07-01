package com.shouyiren.btime.webser.user.api;


import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:52
 * email:727933147@qq.com
 */

public class SnsAccount
        implements Serializable {
    private static final long serialVersionUID = -5257249249567365056L;
    private Date expireDate;
    private String screenName;
    private String snsToken;
    private Integer snsType;
    private String snsUid;
    private Long uid;

    public Date getExpireDate() {
        return this.expireDate;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public String getSnsToken() {
        return this.snsToken;
    }

    public Integer getSnsType() {
        return this.snsType;
    }

    public String getSnsUid() {
        return this.snsUid;
    }

    public Long getUid() {
        return this.uid;
    }

    public void setExpireDate(Date paramDate) {
        this.expireDate = paramDate;
    }

    public void setScreenName(String paramString) {
        this.screenName = paramString;
    }

    public void setSnsToken(String paramString) {
        this.snsToken = paramString;
    }

    public void setSnsType(Integer paramInteger) {
        this.snsType = paramInteger;
    }

    public void setSnsUid(String paramString) {
        this.snsUid = paramString;
    }

    public void setUid(Long paramLong) {
        this.uid = paramLong;
    }
}


