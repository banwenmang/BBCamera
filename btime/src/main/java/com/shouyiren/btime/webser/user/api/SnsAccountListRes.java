package com.shouyiren.btime.webser.user.api;


import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.ArrayList;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:52
 * email:727933147@qq.com
 */

public class SnsAccountListRes
        extends CommonRes {
    private static final long serialVersionUID = 8778158852055718409L;
    ArrayList<SnsAccount> list;

    public ArrayList<SnsAccount> getList() {
        return this.list;
    }

    public void setList(ArrayList<SnsAccount> paramArrayList) {
        this.list = paramArrayList;
    }
}

