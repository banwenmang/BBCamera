package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:03
 * email:727933147@qq.com
 */

public class RemindRes
        extends CommonRes {
    private static final long serialVersionUID = -7817461599695718749L;
    private String modSwitch;
    private String modUpdate;

    public String getModSwitch() {
        return this.modSwitch;
    }

    public String getModUpdate() {
        return this.modUpdate;
    }

    public void setModSwitch(String paramString) {
        this.modSwitch = paramString;
    }

    public void setModUpdate(String paramString) {
        this.modUpdate = paramString;
    }
}

