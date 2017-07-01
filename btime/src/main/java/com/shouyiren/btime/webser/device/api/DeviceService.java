package com.shouyiren.btime.webser.device.api;


import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.Map;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:49
 * email:727933147@qq.com
 */

public interface DeviceService {
    void addDeviceRegCount(Long paramLong);

    DeviceInfo create(String paramString);

    Map<String, Object> create(String paramString, DeviceInfo paramDeviceInfo, DeviceApps paramDeviceApps);

    DeviceInfo getByUUID(String paramString);

    DeviceInfoRes getCurrentDeviceInfo(Long paramLong);

    DeviceInfo getDeviceInfoById(Long paramLong);

    DeviceInfo getDeviceInfoByUid(Long paramLong);

    boolean isNonUniqueDeviceUUID(String paramString);

    CommonRes setDeviceInfo(DeviceInfo paramDeviceInfo, Long paramLong);

    void update(DeviceInfo paramDeviceInfo);

    void updateDeviceUsage(Integer paramInteger, Long paramLong);
}

