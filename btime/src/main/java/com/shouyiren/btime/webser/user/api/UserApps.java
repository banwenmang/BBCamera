package com.shouyiren.btime.webser.user.api;

import java.io.Serializable;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:53
 * email:727933147@qq.com
 */

public class UserApps
        implements Serializable {
    private static final long serialVersionUID = 2853328042749866581L;
    private Integer appCode;
    private Integer appid;
    private Integer channel;
    private Long uid;

    public Integer getAppCode() {
        return this.appCode;
    }

    public Integer getAppid() {
        return this.appid;
    }

    public Integer getChannel() {
        return this.channel;
    }

    public Long getUid() {
        return this.uid;
    }

    public void setAppCode(Integer paramInteger) {
        this.appCode = paramInteger;
    }

    public void setAppid(Integer paramInteger) {
        this.appid = paramInteger;
    }

    public void setChannel(Integer paramInteger) {
        this.channel = paramInteger;
    }

    public void setUid(Long paramLong) {
        this.uid = paramLong;
    }
}

