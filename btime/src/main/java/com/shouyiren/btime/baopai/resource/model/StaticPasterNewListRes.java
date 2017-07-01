package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:04
 * email:727933147@qq.com
 */

public class StaticPasterNewListRes
        extends CommonRes {
    private static final long serialVersionUID = -6173608582808471451L;
    private List<StaticPasterNewData> pasterList = null;

    public List<StaticPasterNewData> getPasterList() {
        return this.pasterList;
    }

    public void setPasterList(List<StaticPasterNewData> paramList) {
        this.pasterList = paramList;
    }
}

