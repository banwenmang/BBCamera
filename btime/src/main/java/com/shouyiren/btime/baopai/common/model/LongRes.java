package com.shouyiren.btime.baopai.common.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:38
 * email:727933147@qq.com
 */

public class LongRes
        extends CommonRes {
    private static final long serialVersionUID = -3632761194071185397L;
    private Long value;

    public Long getValue() {
        return this.value;
    }

    public void setValue(Long paramLong) {
        this.value = paramLong;
    }
}

