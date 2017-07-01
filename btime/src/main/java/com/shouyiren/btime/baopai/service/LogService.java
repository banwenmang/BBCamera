package com.shouyiren.btime.baopai.service;

import com.shouyiren.btime.baopai.common.model.CrashLogData;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:08
 * email:727933147@qq.com
 * <p>
 * 报错日志
 */

public interface LogService {
    void addCrashLog(CrashLogData paramCrashLogData);
}

