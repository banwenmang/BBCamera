package com.shouyiren.btime.baopai.service;

import com.shouyiren.btime.baopai.resource.model.RemindModUpdateData;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:09
 * email:727933147@qq.com
 * <p>
 * 更新信息
 */

public interface RemindModUpdateService {
    List<RemindModUpdateData> getAllModUpdate();

    void updateModDateTime(String paramString);
}

