package com.shouyiren.btime.baopai.resource.model;

import java.io.Serializable;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:07
 * email:727933147@qq.com
 */

public class V2UserData
        implements Serializable {
    private static final long serialVersionUID = 6626500071533382445L;
    private Integer alignment;
    private Integer aspect;
    private Long fontId;
    private Long musicId;
    private String text = null;
    private Integer windowCount;

    public Integer getAlignment() {
        return this.alignment;
    }

    public Integer getAspect() {
        return this.aspect;
    }

    public Long getFontId() {
        return this.fontId;
    }

    public Long getMusicId() {
        return this.musicId;
    }

    public String getText() {
        return this.text;
    }

    public Integer getWindowCount() {
        return this.windowCount;
    }

    public void setAlignment(Integer paramInteger) {
        this.alignment = paramInteger;
    }

    public void setAspect(Integer paramInteger) {
        this.aspect = paramInteger;
    }

    public void setFontId(Long paramLong) {
        this.fontId = paramLong;
    }

    public void setMusicId(Long paramLong) {
        this.musicId = paramLong;
    }

    public void setText(String paramString) {
        this.text = paramString;
    }

    public void setWindowCount(Integer paramInteger) {
        this.windowCount = paramInteger;
    }
}

