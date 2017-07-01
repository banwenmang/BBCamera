package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:33
 * email:727933147@qq.com
 */

public class DynamicPasterListRes
        extends CommonRes {
    private static final long serialVersionUID = -8007789584405972186L;
    private List<DynamicPasterData> pasterList = null;

    public List<DynamicPasterData> getPasterList() {
        return this.pasterList;
    }

    public void setPasterList(List<DynamicPasterData> paramList) {
        this.pasterList = paramList;
    }
}

