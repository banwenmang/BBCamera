package com.shouyiren.btime.baopai.operator.file.api;

/**
 * 图片信息
 * 作者：ZhouJianxing on 2017/7/1 13:31
 * email:727933147@qq.com
 */

public class PhotoCacheSize {
    private Integer id;
    private Integer size;
    private Boolean square;
    private Integer type;

    public Integer getId() {
        return this.id;
    }

    public Integer getSize() {
        return this.size;
    }

    public Integer getType() {
        return this.type;
    }

    public Boolean isSquare() {
        return this.square;
    }

    public void setId(Integer paramInteger) {
        this.id = paramInteger;
    }

    public void setSize(Integer paramInteger) {
        this.size = paramInteger;
    }

    public void setSquare(Boolean paramBoolean) {
        this.square = paramBoolean;
    }

    public void setType(Integer paramInteger) {
        this.type = paramInteger;
    }
}

