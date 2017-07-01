package com.shouyiren.btime.baopai.service;

import com.shouyiren.btime.baopai.common.model.AppData;
import com.shouyiren.btime.baopai.common.model.AppSessionData;
import com.shouyiren.btime.baopai.common.model.AuthRes;
import com.shouyiren.btime.webser.commons.api.CommonRes;
import com.shouyiren.btime.webser.device.api.DeviceInfo;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:07
 * email:727933147@qq.com
 * <p>
 * 认证信息
 */

public interface AuthService {
    /**
     * 进行认证
     *
     * @param paramString1
     * @param paramInteger
     * @param paramString2
     * @param paramDeviceInfo
     * @param paramString3
     * @param paramString4
     * @return
     */
    AuthRes doAuth(String paramString1, Integer paramInteger, String paramString2, DeviceInfo paramDeviceInfo, String paramString3, String paramString4);

    /**
     * 最后一次版本
     *
     * @param paramString
     * @param paramBoolean
     * @return
     */
    AppData getLastVersion(String paramString, boolean paramBoolean);

    /**
     * WebAppSession
     *
     * @param paramString
     * @return
     */
    AppSessionData getWebAppSession(String paramString);

    /**
     * 加载
     *
     * @param paramString
     * @param paramInteger
     * @return
     */
    AppData loadbyAppKey(String paramString, Integer paramInteger);

    /**
     * @param paramString
     * @return
     */
    AppSessionData loadbyToken(String paramString);

    /**
     * 登出 操作
     *
     * @param paramLong1
     * @param paramLong2
     * @return
     */
    CommonRes logoutAll(Long paramLong1, Long paramLong2);
}

