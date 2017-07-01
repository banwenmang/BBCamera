package com.shouyiren.btime.webser.commons.api;


import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:48
 * email:727933147@qq.com
 */

public class CommonRes
        implements Serializable {
    public static final int RES_AUTH_FAILED = 1007;
    public static final int RES_DAOEXCEPTION = 1003;
    public static final int RES_INVALID_PARAM = 1002;
    public static final int RES_INVALID_TOKEN = 1008;
    public static final int RES_NEED_AUTH = 1009;
    public static final int RES_NEED_SIGNIN = 1006;
    public static final int RES_NOT_ALLOW = 1011;
    public static final int RES_NO_RIGHT = 1005;
    public static final int RES_OK = 0;
    public static final int RES_RUNTIME_EXCEPTION = 1004;
    public static final int RES_TIMEOUT = 1010;
    public static final int RES_UNKNOW_ERROR = 1000;
    public static final int RES_UNSUPPORT = 1001;
    private static final long serialVersionUID = 6094615237599920640L;
    private Integer ccdVersion;

    /**
     * 错误信息
     */
    private String errorInfo;

    /**
     * 信息
     */
    private String msgInfo;

    /**
     * 返回码
     */
    private int rc = 0;

    /**
     * 重定向
     */
    private String redirect;

    /**
     * 重定向标志
     */
    private String redirectSign;

    /**
     * 服务器时间
     */
    private Date serverTime;

    public static void fillCommonResData(CommonRes paramCommonRes1, CommonRes paramCommonRes2) {
        paramCommonRes1.setCcdVersion(paramCommonRes2.getCcdVersion());
        paramCommonRes1.setErrorInfo(paramCommonRes2.getErrorInfo());
        paramCommonRes1.setMsgInfo(paramCommonRes2.getMsgInfo());
        paramCommonRes1.setRc(paramCommonRes2.getRc());
        paramCommonRes1.setRedirect(paramCommonRes2.getRedirect());
        paramCommonRes1.setRedirectSign(paramCommonRes2.getRedirectSign());
        paramCommonRes1.setServerTime(paramCommonRes2.getServerTime());
    }

    public static CommonRes retError(int paramInt, String paramString) {
        CommonRes localCommonRes = new CommonRes();
        localCommonRes.rc = paramInt;
        localCommonRes.errorInfo = paramString;
        return localCommonRes;
    }

    public static CommonRes retOK() {
        return new CommonRes();
    }

    public Integer getCcdVersion() {
        return this.ccdVersion;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public String getMsgInfo() {
        return this.msgInfo;
    }

    public int getRc() {
        return this.rc;
    }

    public String getRedirect() {
        return this.redirect;
    }

    public String getRedirectSign() {
        return this.redirectSign;
    }

    public Date getServerTime() {
        return this.serverTime;
    }

    public void setCcdVersion(Integer paramInteger) {
        this.ccdVersion = paramInteger;
    }

    public void setErrorInfo(String paramString) {
        this.errorInfo = paramString;
    }

    public void setMsgInfo(String paramString) {
        this.msgInfo = paramString;
    }

    public void setRc(int paramInt) {
        this.rc = paramInt;
    }

    public void setRedirect(String paramString) {
        this.redirect = paramString;
    }

    public void setRedirectSign(String paramString) {
        this.redirectSign = paramString;
    }

    public void setServerTime(Date paramDate) {
        this.serverTime = paramDate;
    }
}

