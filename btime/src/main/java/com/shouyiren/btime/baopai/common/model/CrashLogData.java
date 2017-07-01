package com.shouyiren.btime.baopai.common.model;

import java.io.Serializable;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:38
 * email:727933147@qq.com
 */
public class CrashLogData
        implements Serializable {
    private static final long serialVersionUID = -907203678883049482L;
    private String data;
    private Short type;
    private Long uid;
    private String userInfo;

    public String getData() {
        return this.data;
    }

    public Short getType() {
        return this.type;
    }

    public Long getUid() {
        return this.uid;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public void setData(String paramString) {
        this.data = paramString;
    }

    public void setType(Short paramShort) {
        this.type = paramShort;
    }

    public void setUid(Long paramLong) {
        this.uid = paramLong;
    }

    public void setUserInfo(String paramString) {
        this.userInfo = paramString;
    }
}

