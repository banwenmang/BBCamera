package com.shouyiren.btime.baopai.service;

import com.shouyiren.btime.baopai.common.model.FarmData;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:08
 * email:727933147@qq.com
 */

public interface FarmService {
    List<FarmData> getFarm(Integer paramInteger, boolean paramBoolean);
}

