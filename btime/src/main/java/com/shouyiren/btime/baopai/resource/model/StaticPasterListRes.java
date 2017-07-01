package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:03
 * email:727933147@qq.com
 */

public class StaticPasterListRes
        extends CommonRes {
    private static final long serialVersionUID = 2754093297591342465L;
    private List<StaticPasterData> pasterList = null;

    public List<StaticPasterData> getPasterList() {
        return this.pasterList;
    }

    public void setPasterList(List<StaticPasterData> paramList) {
        this.pasterList = paramList;
    }
}

