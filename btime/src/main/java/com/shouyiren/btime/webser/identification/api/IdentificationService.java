package com.shouyiren.btime.webser.identification.api;


import com.shouyiren.btime.webser.commons.api.SessionData;
import com.shouyiren.btime.webser.user.api.LoginBasicRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:50
 * email:727933147@qq.com
 */

public interface IdentificationService {
    /**
     * 绑定 Email
     *
     * @param paramLong
     * @param paramString1
     * @param paramString2
     * @param paramString3
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    IdentUserBasicDataRes bindEmail(Long paramLong, String paramString1, String paramString2, String paramString3, SessionData paramSessionData)
            throws Exception;

    /**
     * 绑定 Phone
     *
     * @param paramLong
     * @param paramString1
     * @param paramString2
     * @param paramString3
     * @param paramString4
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    IdentUserBasicDataRes bindPhone(Long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, SessionData paramSessionData)
            throws Exception;

    /**
     * 手机登录
     *
     * @param paramString1
     * @param paramString2
     * @param paramSessionData
     * @return
     */
    LoginBasicRes loginWithPhoneValidation(String paramString1, String paramString2, SessionData paramSessionData);

    /**
     * 手机号检测
     *
     * @param paramString1
     * @param paramString2
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    IdentUserBasicDataRes phoneCertCodeCheck(String paramString1, String paramString2, SessionData paramSessionData)
            throws Exception;

    /**
     * 发送短信验证码
     *
     * @param paramString
     * @param paramInteger
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    IdentValidationCodeRes phoneCertCodeSend(String paramString, Integer paramInteger, SessionData paramSessionData)
            throws Exception;

    /**
     * 新 发送短信验证码
     *
     * @param paramString
     * @param paramInteger1
     * @param paramSessionData
     * @param paramInteger2
     * @return
     * @throws Exception
     */
    IdentValidationCodeRes phoneCertCodeSendNew(String paramString, Integer paramInteger1, SessionData paramSessionData, Integer paramInteger2)
            throws Exception;

    /**
     * 重置密码后登录
     *
     * @param paramString1
     * @param paramString2
     * @param paramString3
     * @param paramString4
     * @param paramSessionData
     * @return
     * @throws Exception
     */
    LoginBasicRes resetPasswordWithLogin(String paramString1, String paramString2, String paramString3, String paramString4, SessionData paramSessionData)
            throws Exception;
}

