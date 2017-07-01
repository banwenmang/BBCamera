package com.shouyiren.btime.baopai.common.model;

import java.io.Serializable;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:39
 * email:727933147@qq.com
 */

public class UserContentData
        implements Serializable {
    private static final long serialVersionUID = 368199571192986069L;
    private Long id;
    private Integer type;
    private Long uid;
    private String wenku;

    public Long getId() {
        return this.id;
    }

    public Integer getType() {
        return this.type;
    }

    public Long getUid() {
        return this.uid;
    }

    public String getWenku() {
        return this.wenku;
    }

    public void setId(Long paramLong) {
        this.id = paramLong;
    }

    public void setType(Integer paramInteger) {
        this.type = paramInteger;
    }

    public void setUid(Long paramLong) {
        this.uid = paramLong;
    }

    public void setWenku(String paramString) {
        this.wenku = paramString;
    }
}

