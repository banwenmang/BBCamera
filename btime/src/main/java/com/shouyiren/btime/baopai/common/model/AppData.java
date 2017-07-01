package com.shouyiren.btime.baopai.common.model;


import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:37
 * email:727933147@qq.com
 */
public class AppData
        implements Serializable {
    private static final long serialVersionUID = 4623783125431230731L;
    private String appKey;
    private String appName;
    private String appSecret;
    private Integer appid;
    private String description;
    private String downloadUrl;
    private Date releaseDate;
    private Long rootId;
    private Integer status;
    private String title;
    private String version;
    private Integer versionCode;

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public Integer getAppid() {
        return this.appid;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public Long getRootId() {
        return this.rootId;
    }

    public Integer getStatus() {
        return this.status;
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

    public void setAppKey(String paramString) {
        this.appKey = paramString;
    }

    public void setAppName(String paramString) {
        this.appName = paramString;
    }

    public void setAppSecret(String paramString) {
        this.appSecret = paramString;
    }

    public void setAppid(Integer paramInteger) {
        this.appid = paramInteger;
    }

    public void setDescription(String paramString) {
        this.description = paramString;
    }

    public void setDownloadUrl(String paramString) {
        this.downloadUrl = paramString;
    }

    public void setReleaseDate(Date paramDate) {
        this.releaseDate = paramDate;
    }

    public void setRootId(Long paramLong) {
        this.rootId = paramLong;
    }

    public void setStatus(Integer paramInteger) {
        this.status = paramInteger;
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

