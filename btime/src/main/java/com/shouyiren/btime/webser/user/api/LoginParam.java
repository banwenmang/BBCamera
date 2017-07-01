package com.shouyiren.btime.webser.user.api;


import java.io.Serializable;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:52
 * email:727933147@qq.com
 */

public class LoginParam
        implements Serializable {
    private static final long serialVersionUID = 6484239939817177909L;
    private String account;
    private Integer accountType;
    private Boolean permanent;
    private String pwd;

    public String getAccount() {
        return this.account;
    }

    public Integer getAccountType() {
        return this.accountType;
    }

    public Boolean getPermanent() {
        if (this.permanent == null) {
            this.permanent = new Boolean(false);
        }
        return this.permanent;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setAccount(String paramString) {
        this.account = paramString;
    }

    public void setAccountType(Integer paramInteger) {
        this.accountType = paramInteger;
    }

    public void setPermanent(Boolean paramBoolean) {
        this.permanent = paramBoolean;
    }

    public void setPwd(String paramString) {
        this.pwd = paramString;
    }
}

