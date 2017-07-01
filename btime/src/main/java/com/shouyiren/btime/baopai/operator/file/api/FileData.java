package com.shouyiren.btime.baopai.operator.file.api;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件信息
 * 作者：ZhouJianxing on 2017/7/1 13:29
 * email:727933147@qq.com
 */

public class FileData
        implements Serializable {
    private static final long serialVersionUID = 928383845199321938L;
    private Integer duration;
    private Integer farm;
    private Long fid;
    private Integer fileType;

    /**
     * GPS
     */
    private String gpsInfo;
    private Integer height;
    private String name;
    private Date origTime;
    private Long owner;
    private String secret;
    private Long size;
    private Integer status;

    /**
     * 上传时间
     */
    private Date uploadTime;
    private Integer width;

    public Integer getDuration() {
        return this.duration;
    }

    public Integer getFarm() {
        return this.farm;
    }

    public Long getFid() {
        return this.fid;
    }

    public Integer getFileType() {
        return this.fileType;
    }

    public String getGpsInfo() {
        return this.gpsInfo;
    }

    public Integer getHeight() {
        return this.height;
    }

    public String getName() {
        return this.name;
    }

    public Date getOrigTime() {
        return this.origTime;
    }

    public Long getOwner() {
        return this.owner;
    }

    public String getSecret() {
        return this.secret;
    }

    public Long getSize() {
        return this.size;
    }

    public Integer getStatus() {
        return this.status;
    }

    public Date getUploadTime() {
        return this.uploadTime;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setDuration(Integer paramInteger) {
        this.duration = paramInteger;
    }

    public void setFarm(Integer paramInteger) {
        this.farm = paramInteger;
    }

    public void setFid(Long paramLong) {
        this.fid = paramLong;
    }

    public void setFileType(Integer paramInteger) {
        this.fileType = paramInteger;
    }

    public void setGpsInfo(String paramString) {
        this.gpsInfo = paramString;
    }

    public void setHeight(Integer paramInteger) {
        this.height = paramInteger;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOrigTime(Date paramDate) {
        this.origTime = paramDate;
    }

    public void setOwner(Long paramLong) {
        this.owner = paramLong;
    }

    public void setSecret(String paramString) {
        this.secret = paramString;
    }

    public void setSize(Long paramLong) {
        this.size = paramLong;
    }

    public void setStatus(Integer paramInteger) {
        this.status = paramInteger;
    }

    public void setUploadTime(Date paramDate) {
        this.uploadTime = paramDate;
    }

    public void setWidth(Integer paramInteger) {
        this.width = paramInteger;
    }
}

