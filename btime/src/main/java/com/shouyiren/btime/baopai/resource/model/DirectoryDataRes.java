package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:33
 * email:727933147@qq.com
 */

public class DirectoryDataRes
        extends CommonRes {
    private static final long serialVersionUID = 8007159413061999859L;
    private DirectoryData directoryData;

    public DirectoryData getDirectoryData() {
        return this.directoryData;
    }

    public void setDirectoryData(DirectoryData paramDirectoryData) {
        this.directoryData = paramDirectoryData;
    }
}

