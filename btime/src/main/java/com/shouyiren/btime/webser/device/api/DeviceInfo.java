package com.shouyiren.btime.webser.device.api;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:49
 * email:727933147@qq.com
 */

public class DeviceInfo
        implements Serializable {
    public static final int SIZE_DEVICEUUID = 36;
    private static final long serialVersionUID = -1019833925228477374L;
    private Integer channel;
    private Date createTime;
    private Long deviceid;
    private Integer dh;
    private Integer dw;
    private String model;
    private String name;
    private String os;
    private Integer usage;

    /**
     * Imei
     */
    private String uuid;
    private String version;

    public Integer getChannel() {
        return this.channel;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Integer getDH() {
        return this.dh;
    }

    public Integer getDW() {
        return this.dw;
    }

    public Long getDeviceID() {
        return this.deviceid;
    }

    public String getModel() {
        return this.model;
    }

    public String getName() {
        return this.name;
    }

    public String getOS() {
        return this.os;
    }

    public String getUUID() {
        return this.uuid;
    }

    public Integer getUsage() {
        return this.usage;
    }

    public String getVersion() {
        return this.version;
    }

    public void setChannel(Integer paramInteger) {
        this.channel = paramInteger;
    }

    public void setCreateTime(Date paramDate) {
        this.createTime = paramDate;
    }

    public void setDH(Integer paramInteger) {
        this.dh = paramInteger;
    }

    public void setDW(Integer paramInteger) {
        this.dw = paramInteger;
    }

    public void setDeviceID(Long paramLong) {
        this.deviceid = paramLong;
    }

    public void setModel(String paramString) {
        this.model = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOS(String paramString) {
        this.os = paramString;
        if ((this.os != null) && (this.os.length() > 64)) {
            this.os = this.os.substring(0, 63);
        }
    }

    public void setUUID(String paramString) {
        this.uuid = paramString;
    }

    public void setUsage(Integer paramInteger) {
        this.usage = paramInteger;
    }

    public void setVersion(String paramString) {
        this.version = paramString;
    }
}

