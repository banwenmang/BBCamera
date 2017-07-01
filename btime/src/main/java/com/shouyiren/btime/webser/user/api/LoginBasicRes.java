package com.shouyiren.btime.webser.user.api;

import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:52
 * email:727933147@qq.com
 */

public class LoginBasicRes
        extends CommonRes {
    private static final long serialVersionUID = -2561769159294401072L;
    private Boolean newUser;
    private Long uid;
    private UserBasicData userBasicData;

    public Long getUID() {
        return this.uid;
    }

    public UserBasicData getUserBasicData() {
        return this.userBasicData;
    }

    public Boolean isNewUser() {
        return this.newUser;
    }

    public void setNewUser(Boolean paramBoolean) {
        this.newUser = paramBoolean;
    }

    public void setUID(Long paramLong) {
        this.uid = paramLong;
    }

    public void setUserBasicData(UserBasicData paramUserBasicData) {
        this.userBasicData = paramUserBasicData;
    }
}

