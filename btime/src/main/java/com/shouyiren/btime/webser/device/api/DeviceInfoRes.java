package com.shouyiren.btime.webser.device.api;


import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:49
 * email:727933147@qq.com
 */

public class DeviceInfoRes
        extends CommonRes {
    private static final long serialVersionUID = -8858643763287734414L;
    private DeviceInfo deviceInfo;

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo paramDeviceInfo) {
        this.deviceInfo = paramDeviceInfo;
    }
}

