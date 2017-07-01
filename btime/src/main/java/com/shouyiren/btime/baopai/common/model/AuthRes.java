package com.shouyiren.btime.baopai.common.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:37
 * email:727933147@qq.com
 */
public class AuthRes
        extends CommonRes {
    private static final long serialVersionUID = 3634828983329816540L;
    private boolean isConfigUpdated;
    private boolean lastestVersion;
    private boolean needDeviceInfo;
    private boolean newDevice;
    private String token;
    private Integer usage;

    public boolean getIsConfigUpdated() {
        return this.isConfigUpdated;
    }

    public boolean getNeedDeviceInfo() {
        return this.needDeviceInfo;
    }

    public String getToken() {
        return this.token;
    }

    public Integer getUsage() {
        return this.usage;
    }

    public boolean isLastestVersion() {
        return this.lastestVersion;
    }

    public boolean isNewDevice() {
        return this.newDevice;
    }

    public void setIsConfigUpdated(boolean paramBoolean) {
        this.isConfigUpdated = paramBoolean;
    }

    public void setLastestVersion(boolean paramBoolean) {
        this.lastestVersion = paramBoolean;
    }

    public void setNeedDeviceInfo(boolean paramBoolean) {
        this.needDeviceInfo = paramBoolean;
    }

    public void setNewDevice(boolean paramBoolean) {
        this.newDevice = paramBoolean;
    }

    public void setToken(String paramString) {
        this.token = paramString;
    }

    public void setUsage(Integer paramInteger) {
        this.usage = paramInteger;
    }
}

