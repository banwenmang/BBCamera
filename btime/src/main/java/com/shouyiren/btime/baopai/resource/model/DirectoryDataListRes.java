package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:32
 * email:727933147@qq.com
 */

public class DirectoryDataListRes
        extends CommonRes {
    private static final long serialVersionUID = -2729659026744823097L;
    private List<DirectoryData> directories;

    public List<DirectoryData> getDirectories() {
        return this.directories;
    }

    public void setDirectories(List<DirectoryData> paramList) {
        this.directories = paramList;
    }
}

