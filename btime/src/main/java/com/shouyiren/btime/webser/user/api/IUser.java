package com.shouyiren.btime.webser.user.api;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:52
 * email:727933147@qq.com
 */

public class IUser {
    public static final int AT_DEVICE = 1;
    public static final int AT_DEVICE_OBSOLETED = 2;
    public static final int AT_NORMAL = 0;
    public static final int ERR_EMAIL_EXISTED = 2009;
    public static final int ERR_INVALID_ACCOUNT = 2006;
    public static final int ERR_INVALID_EMAIL = 2004;
    public static final int ERR_INVALID_PASSWORD = 2002;
    public static final int ERR_INVALID_PHONENUMBER = 2005;
    public static final int ERR_INVALID_USERNAME = 2001;
    public static final int ERR_NOT_CURRENT_USER = 2020;
    public static final int ERR_NO_PASSWORD = 2016;
    public static final int ERR_PASSWORD_INCORRECT = 2011;
    public static final int ERR_PHONENUMBER_EXISTED = 2012;
    public static final int ERR_REQUIRED_ACCOUNT = 2015;
    public static final int ERR_RESET_PWD_PHONE_FAILED = 2014;
    public static final int ERR_SEND_RESET_PWD_EMAIL_FAILED = 2013;
    public static final int ERR_SNS_HASBIND = 2017;
    public static final int ERR_SNS_NOT_BIND = 2021;
    public static final int ERR_TOP_ACTIVE_USER_NUM_OVER = 2010;
    public static final int ERR_TRY_UNBIND_UNIGUE_ACCOUNT = 2019;
    public static final int ERR_USERNAME_EXISTED = 2007;
    public static final int ERR_USERNAME_ILLICIT = 2008;
    public static final int ERR_USER_EXISTED = 2003;
    public static final int ERR_USER_HASBIND_SNS = 2018;
    public static final int SNS_TYPE_QQ = 2;
    public static final int SNS_TYPE_RENREN = 3;
    public static final int SNS_TYPE_SINA_WEIBO = 1;
    public static final int SNS_TYPE_WEIXIN = 4;
    public static final int USER_STATUS_ACTIVATED = 1;
    public static final int USER_STATUS_NEEDCOMPLETEINFO = 2;
    public static final int USER_STATUS_UNACTIVATED = 0;
}

