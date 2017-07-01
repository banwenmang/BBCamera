package com.shouyiren.btime.webser.identification.api;


import com.shouyiren.btime.webser.commons.api.CommonRes;
import com.shouyiren.btime.webser.user.api.UserBasicData;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:51
 * email:727933147@qq.com
 */

public class IdentUserBasicDataRes
        extends CommonRes {
    private static final long serialVersionUID = 1894284520400857107L;
    private String code = null;
    private Integer existPassword;
    private UserBasicData userBasicData = null;

    public String getCode() {
        return this.code;
    }

    public Integer getExistPassword() {
        return this.existPassword;
    }

    public UserBasicData getUserBasicData() {
        return this.userBasicData;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setExistPassword(Integer paramInteger) {
        this.existPassword = paramInteger;
    }

    public void setUserBasicData(UserBasicData paramUserBasicData) {
        this.userBasicData = paramUserBasicData;
    }
}

