package com.shouyiren.btime.webser.identification.api;

import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:51
 * email:727933147@qq.com
 */

public class IdentValidationCodeRes
        extends CommonRes {
    private static final long serialVersionUID = 235204268166877943L;
    private String code = null;
    private Boolean isRegister = null;

    public String getCode() {
        return this.code;
    }

    public Boolean getIsRegister() {
        return this.isRegister;
    }

    public void setCode(String paramString) {
        this.code = paramString;
    }

    public void setIsRegister(Boolean paramBoolean) {
        this.isRegister = paramBoolean;
    }
}

