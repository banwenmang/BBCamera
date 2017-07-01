package com.shouyiren.btime.baopai.common.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:38
 * email:727933147@qq.com
 */

public class StringRes
        extends CommonRes {
    private static final long serialVersionUID = -1707084777209669585L;
    private String content = null;

    public String getContent() {
        return this.content;
    }

    public void setContent(String paramString) {
        this.content = paramString;
    }
}

