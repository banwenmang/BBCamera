package com.shouyiren.btime.webser.user.api;

import java.io.Serializable;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:52
 * email:727933147@qq.com
 */

public class PasswordParam
        implements Serializable {
    private static final long serialVersionUID = 6414544084408043207L;
    private String newPwd;
    private String oldPwd;

    public String getNewPwd() {
        return this.newPwd;
    }

    public String getOldPwd() {
        return this.oldPwd;
    }

    public void setNewPwd(String paramString) {
        this.newPwd = paramString;
    }

    public void setOldPwd(String paramString) {
        this.oldPwd = paramString;
    }
}
