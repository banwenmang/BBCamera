package com.shouyiren.btime.webser.user.api;

import com.shouyiren.btime.webser.commons.api.CommonRes;
import com.shouyiren.btime.webser.commons.api.SessionData;
import com.shouyiren.btime.webser.file.api.FileData;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:53
 * email:727933147@qq.com
 */

public interface UserBasicService {
    CommonRes bindWithSNS(SnsAccount paramSnsAccount, SessionData paramSessionData)
            throws Exception;

    /**
     * 更改密码
     *
     * @param paramPasswordParam
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    CommonRes changePassword(PasswordParam paramPasswordParam, SessionData paramSessionData)
            throws Exception;

    /**
     * 检测账号
     *
     * @param paramString
     * @param paramInteger
     * @return
     */
    CommonRes checkAccount(String paramString, Integer paramInteger);

    /**
     * 检测 Email
     *
     * @param paramString
     * @param paramLong
     * @return
     */
    CommonRes checkEmail(String paramString, Long paramLong);

    /**
     * 检测手机号
     *
     * @param paramString
     * @param paramLong
     * @return
     */
    CommonRes checkPhone(String paramString, Long paramLong);

    /**
     * 重新检测邮箱
     *
     * @param paramString
     * @return
     */
    String checkResetEmailInfo(String paramString);

    /**
     * 检测 用户名
     *
     * @param paramString
     * @param paramLong
     * @return
     */
    CommonRes checkUserName(String paramString, Long paramLong);

    /**
     * 清除用户 Email
     *
     * @param paramLong
     */
    void cleanUserEmail(Long paramLong);

    /**
     * 清除手机号
     *
     * @param paramLong
     */
    void cleanUserPhone(Long paramLong);

    /**
     * 登录
     *
     * @param paramUserBasicData
     * @param paramBoolean
     * @param paramSessionData
     * @return
     */
    LoginBasicRes doLogin(UserBasicData paramUserBasicData, boolean paramBoolean, SessionData paramSessionData);

    /**
     * 注册并登录
     *
     * @param paramSnsAccount
     * @param paramSessionData
     * @param paramBoolean
     * @return
     * @throws Exception
     */
    LoginBasicRes doLoginRegisterWithSNS(SnsAccount paramSnsAccount, SessionData paramSessionData, Boolean paramBoolean)
            throws Exception;

    /**
     * 账号登录
     *
     * @param paramLoginParam
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    LoginBasicRes doLoginWithAccount(LoginParam paramLoginParam, SessionData paramSessionData)
            throws Exception;

    /**
     * 验证码登录
     *
     * @param paramSnsAccount
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    LoginBasicRes doLoginWithSNS(SnsAccount paramSnsAccount, SessionData paramSessionData)
            throws Exception;

    /**
     * 获取用户信息
     *
     * @param paramLong
     * @return
     */
    List<UserBasicData> getDeviceUserBasicDatabyDeviceId(Long paramLong);

    /**
     * @param paramLong
     * @return
     */
    UserBasicDataRes getProfile(Long paramLong);

    /**
     * @param paramLong
     * @return
     */
    SnsAccountListRes getSNSList(Long paramLong);

    /**
     * @param paramLong
     * @return
     */
    ArrayList<SnsAccount> getSnsAccountList(Long paramLong);

    /**
     * @param paramLong
     * @return
     */
    UserBasicData getUserBasicDatabyId(Long paramLong);

    /**
     * @param paramList
     * @return
     */
    List<UserBasicData> getUserBasicDatabyIds(List<Long> paramList);

    /**
     * @param paramString
     * @return
     */
    UserBasicData getUserDatabyEmail(String paramString);

    /**
     * @param paramString
     * @return
     */
    UserBasicData getUserDatabyPhone(String paramString);

    /**
     * @param paramString
     * @param paramInteger
     * @return
     */
    Long getUserUidbyAccount(String paramString, Integer paramInteger);

    /**
     * 是否存在密码
     *
     * @param paramLong
     * @return
     */
    CommonRes hasPassword(Long paramLong);

    /**
     * 注册
     *
     * @param paramUserBasicData
     * @param paramString
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    LoginBasicRes register(UserBasicData paramUserBasicData, String paramString, SessionData paramSessionData)
            throws Exception;

    /**
     * @param paramUserBasicData
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    LoginBasicRes registerDeviceUser(UserBasicData paramUserBasicData, SessionData paramSessionData)
            throws Exception;

    /**
     * @param paramPasswordParam
     * @return
     * @throws Exception
     */
    CommonRes resetPwdSubmit(PasswordParam paramPasswordParam)
            throws Exception;

    /**
     * 重置密码
     *
     * @param paramLong
     * @param paramString
     * @return
     * @throws Exception
     */
    CommonRes resetPwdSubmit(Long paramLong, String paramString)
            throws Exception;

    /**
     * 设置头像
     *
     * @param paramFileData
     * @param paramLong
     * @return
     */
    CommonRes setAvatar(FileData paramFileData, Long paramLong);

    /**
     * 设置密码
     *
     * @param paramLong
     * @param paramArrayOfByte
     */
    void setPassword(Long paramLong, byte[] paramArrayOfByte);

    /**
     * @param paramUserBasicData
     */
    void shieldPrivateData(UserBasicData paramUserBasicData);

    /**
     * 解绑 Email
     *
     * @param paramLong
     * @return
     * @throws Exception
     */
    CommonRes unbindUserEmail(Long paramLong)
            throws Exception;

    /**
     * 解绑手机
     *
     * @param paramLong
     * @return
     * @throws Exception
     */
    CommonRes unbindUserPhone(Long paramLong)
            throws Exception;

    /**
     * 解绑 SNS
     *
     * @param paramSnsAccount
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    CommonRes unbindWithSNS(SnsAccount paramSnsAccount, SessionData paramSessionData)
            throws Exception;

    /**
     * 更新 用户信息
     *
     * @param paramUserBasicData
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    CommonRes updateProfile(UserBasicData paramUserBasicData, SessionData paramSessionData)
            throws Exception;

    /**
     * 更新用户信息
     *
     * @param paramUserBasicData
     */
    void updateProfile(UserBasicData paramUserBasicData);

    /**
     * 验证用户
     *
     * @param paramLoginParam
     * @param paramSessionData
     * @return
     */
    CommonRes verifyUser(LoginParam paramLoginParam, SessionData paramSessionData);

    /**
     * 验证 用户SNS
     *
     * @param paramSnsAccount
     * @param paramSessionData
     * @return
     */
    CommonRes verifyUserSNS(SnsAccount paramSnsAccount, SessionData paramSessionData);
}

