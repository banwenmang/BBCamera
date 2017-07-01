package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:04
 * email:727933147@qq.com
 */

public class V2DirectoryDataList
        extends CommonRes {
    private static final long serialVersionUID = -7406685907978751297L;
    private List<V2DirectoryData> directories;

    public List<V2DirectoryData> getDirectories() {
        return this.directories;
    }

    public void setDirectories(List<V2DirectoryData> paramList) {
        this.directories = paramList;
    }
}

