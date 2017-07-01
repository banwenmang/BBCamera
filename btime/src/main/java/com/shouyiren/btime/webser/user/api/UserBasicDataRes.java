package com.shouyiren.btime.webser.user.api;

import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:53
 * email:727933147@qq.com
 */

public class UserBasicDataRes
        extends CommonRes {
    private static final long serialVersionUID = -1220395688614328785L;
    private UserBasicData userBasicData;

    public UserBasicData getUserBasicData() {
        return this.userBasicData;
    }

    public void setUserBasicData(UserBasicData paramUserBasicData) {
        this.userBasicData = paramUserBasicData;
    }
}

