package com.shouyiren.btime.baopai.common.model;


import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:37
 * email:727933147@qq.com
 */
public class AppVersionRes
        extends CommonRes {
    private static final long serialVersionUID = -6573594354205096143L;
    private String appName;
    private String des;
    private String downloadUrl;
    private Boolean newVersion;
    private Date releaseDate;
    private String title;
    private String version;
    private Integer versionCode;

    public String getAppName() {
        return this.appName;
    }

    public String getDes() {
        return this.des;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public Boolean getNewVersion() {
        return this.newVersion;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVersion() {
        return this.version;
    }

    public Integer getVersionCode() {
        return this.versionCode;
    }

    public void setAppName(String paramString) {
        this.appName = paramString;
    }

    public void setDes(String paramString) {
        this.des = paramString;
    }

    public void setDownloadUrl(String paramString) {
        this.downloadUrl = paramString;
    }

    public void setNewVersion(Boolean paramBoolean) {
        this.newVersion = paramBoolean;
    }

    public void setReleaseDate(Date paramDate) {
        this.releaseDate = paramDate;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public void setVersion(String paramString) {
        this.version = paramString;
    }

    public void setVersionCode(Integer paramInteger) {
        this.versionCode = paramInteger;
    }
}

