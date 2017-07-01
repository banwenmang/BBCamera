package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:05
 * email:727933147@qq.com
 */

public class V2DirectoryDataRes
        extends CommonRes {
    private static final long serialVersionUID = 1344919419754258180L;
    private V2DirectoryData data;

    public V2DirectoryData getData() {
        return this.data;
    }

    public void setData(V2DirectoryData paramV2DirectoryData) {
        this.data = paramV2DirectoryData;
    }
}

