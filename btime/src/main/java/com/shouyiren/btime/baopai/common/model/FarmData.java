package com.shouyiren.btime.baopai.common.model;

import java.io.Serializable;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:43
 * email:727933147@qq.com
 */

public class FarmData
        implements Serializable {
    private static final long serialVersionUID = 6644402334042584917L;
    private Integer cacheType;
    private String className;
    private String config;
    private Integer fileScope;
    private Integer id;
    private String url;

    public FarmData() {
    }

    public FarmData(Integer paramInteger1, String paramString1, String paramString2, String paramString3, Integer paramInteger2, Integer paramInteger3) {
        this.id = paramInteger1;
        this.url = paramString1;
        this.className = paramString2;
        this.config = paramString3;
        this.cacheType = paramInteger2;
        this.fileScope = paramInteger3;
    }

    public Integer getCacheType() {
        return this.cacheType;
    }

    public String getClassName() {
        return this.className;
    }

    public String getConfig() {
        return this.config;
    }

    public Integer getFileScope() {
        return this.fileScope;
    }

    public Integer getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public void setCacheType(Integer paramInteger) {
        this.cacheType = paramInteger;
    }

    public void setClassName(String paramString) {
        this.className = paramString;
    }

    public void setConfig(String paramString) {
        this.config = paramString;
    }

    public void setFileScope(Integer paramInteger) {
        this.fileScope = paramInteger;
    }

    public void setId(Integer paramInteger) {
        this.id = paramInteger;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }
}

