package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 15:00
 * email:727933147@qq.com
 */

public class V2ResourceDataRes
        extends CommonRes {
    private static final long serialVersionUID = -1775985472113872191L;
    private V2ResourceData resource;

    public V2ResourceData getResource() {
        return this.resource;
    }

    public void setResource(V2ResourceData paramV2ResourceData) {
        this.resource = paramV2ResourceData;
    }
}

