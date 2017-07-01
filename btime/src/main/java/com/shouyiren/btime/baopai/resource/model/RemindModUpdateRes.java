package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:02
 * email:727933147@qq.com
 */

public class RemindModUpdateRes
        extends CommonRes {
    private static final long serialVersionUID = 5060032213470796601L;
    private List<RemindModUpdateData> modUpdateDatas = null;

    public List<RemindModUpdateData> getModUpdateDatas() {
        return this.modUpdateDatas;
    }

    public void setModUpdateDatas(List<RemindModUpdateData> paramList) {
        this.modUpdateDatas = paramList;
    }
}

