package com.shouyiren.btime.webser.device.api;

import java.io.Serializable;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:48
 * email:727933147@qq.com
 */

public class DeviceApps
        implements Serializable {
    private static final long serialVersionUID = -1980133438953125911L;
    private Integer appCode;
    private Integer appid;

    /**
     * 区分 android / ios
     */
    private Integer channel;
    private Long deviceid;

    public Integer getAppCode() {
        return this.appCode;
    }

    public Integer getAppid() {
        return this.appid;
    }

    public Integer getChannel() {
        return this.channel;
    }

    public Long getDeviceid() {
        return this.deviceid;
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

    public void setDeviceid(Long paramLong) {
        this.deviceid = paramLong;
    }
}

