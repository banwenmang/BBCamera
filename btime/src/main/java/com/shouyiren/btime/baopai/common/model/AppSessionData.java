package com.shouyiren.btime.baopai.common.model;


import com.shouyiren.btime.webser.commons.api.SessionData;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:37
 * email:727933147@qq.com
 */
public class AppSessionData
        implements Serializable {
    private static final long serialVersionUID = -6640227395002040289L;
    private AppData appData;
    private Integer appid;
    private Date createtime;
    private Long deviceid;
    private Long id;
    private boolean signin = false;
    private String token;
    private Long uid;
    private Date updatetime;

    public static SessionData makeSessionData(AppSessionData paramAppSessionData) {
        SessionData localSessionData = new SessionData();
        localSessionData.setAppCode(Integer.valueOf(1));
        localSessionData.setAppID(paramAppSessionData.getAppid());
        localSessionData.setCreateTime(paramAppSessionData.getCreatetime());
        localSessionData.setDeviceID(paramAppSessionData.getDeviceid());
        localSessionData.setToken(paramAppSessionData.getToken());
        localSessionData.setUID(paramAppSessionData.getUid());
        if (paramAppSessionData.getAppData() != null) {
            localSessionData.setAppKey(paramAppSessionData.getAppData().getAppKey());
            localSessionData.setAppName(paramAppSessionData.getAppData().getAppName());
            localSessionData.setAppSecret(paramAppSessionData.getAppData().getAppSecret());
            localSessionData.setVersionCode(paramAppSessionData.getAppData().getVersionCode());
        }
        return localSessionData;
    }

    public void InitData(AppSessionData paramAppSessionData) {
        this.id = paramAppSessionData.id;
        this.uid = paramAppSessionData.uid;
        this.appid = paramAppSessionData.appid;
        this.deviceid = paramAppSessionData.deviceid;
        this.token = paramAppSessionData.token;
        this.createtime = paramAppSessionData.createtime;
        this.appData = paramAppSessionData.appData;
    }

    public AppData getAppData() {
        return this.appData;
    }

    public Integer getAppid() {
        return this.appid;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public Long getDeviceid() {
        return this.deviceid;
    }

    public Long getId() {
        return this.id;
    }

    public String getToken() {
        return this.token;
    }

    public Long getUid() {
        return this.uid;
    }

    public Date getUpdatetime() {
        return this.updatetime;
    }

    public boolean isSignin() {
        return this.signin;
    }

    public void setAppData(AppData paramAppData) {
        this.appData = paramAppData;
    }

    public void setAppid(Integer paramInteger) {
        this.appid = paramInteger;
    }

    public void setCreatetime(Date paramDate) {
        this.createtime = paramDate;
    }

    public void setDeviceid(Long paramLong) {
        this.deviceid = paramLong;
    }

    public void setId(Long paramLong) {
        this.id = paramLong;
    }

    public void setSignin(boolean paramBoolean) {
        this.signin = paramBoolean;
    }

    public void setToken(String paramString) {
        this.token = paramString;
    }

    public void setUid(Long paramLong) {
        this.uid = paramLong;
    }

    public void setUpdatetime(Date paramDate) {
        this.updatetime = paramDate;
    }
}

