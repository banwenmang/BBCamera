package com.shouyiren.btime.baopai.operator.file.api;

import java.util.ArrayList;

/**
 * 图片
 * 作者：ZhouJianxing on 2017/7/1 13:29
 * email:727933147@qq.com
 */

public class FarmData {
    private ArrayList<PhotoCacheSize> cacheSizeList;
    private Integer cacheType;
    private String className;
    private String config;
    private Integer fileScope;
    private Integer id;
    private String url;

    public ArrayList<PhotoCacheSize> getCacheSizeList() {
        return this.cacheSizeList;
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

    public void setCacheSizeList(ArrayList<PhotoCacheSize> paramArrayList) {
        this.cacheSizeList = paramArrayList;
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

