package com.shouyiren.btime.webser.commons.api;


import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:48
 * email:727933147@qq.com
 */

public class SessionData
        implements Serializable {
    private static final long serialVersionUID = -7145308212723411150L;
    private Integer appCode;
    private String appKey;
    private String appName;
    private String appSecret;
    private Integer appid;
    private Integer channelId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     *
     */
    private Long deviceid;
    private String token;
    private Long uid;

    /**
     * 更新时间
     */
    private Date updateTime;
    private Integer versionCode;

    public Integer getAppCode() {
        return this.appCode;
    }

    public Integer getAppID() {
        return this.appid;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public Integer getChannelId() {
        return this.channelId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Long getDeviceID() {
        return this.deviceid;
    }

    public String getToken() {
        return this.token;
    }

    public Long getUID() {
        return this.uid;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public Integer getVersionCode() {
        return this.versionCode;
    }

    public void setAppCode(Integer paramInteger) {
        this.appCode = paramInteger;
    }

    public void setAppID(Integer paramInteger) {
        this.appid = paramInteger;
    }

    public void setAppKey(String paramString) {
        this.appKey = paramString;
    }

    public void setAppName(String paramString) {
        this.appName = paramString;
    }

    public void setAppSecret(String paramString) {
        this.appSecret = paramString;
    }

    public void setChannelId(Integer paramInteger) {
        this.channelId = paramInteger;
    }

    public void setCreateTime(Date paramDate) {
        this.createTime = paramDate;
    }

    public void setDeviceID(Long paramLong) {
        this.deviceid = paramLong;
    }

    public void setToken(String paramString) {
        this.token = paramString;
    }

    public void setUID(Long paramLong) {
        this.uid = paramLong;
    }

    public void setUpdateTime(Date paramDate) {
        this.updateTime = paramDate;
    }

    public void setVersionCode(Integer paramInteger) {
        this.versionCode = paramInteger;
    }
}

