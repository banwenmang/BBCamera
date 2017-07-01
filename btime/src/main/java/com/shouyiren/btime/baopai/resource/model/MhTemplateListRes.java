package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:34
 * email:727933147@qq.com
 */

public class MhTemplateListRes
        extends CommonRes {
    private static final long serialVersionUID = 2998015857912522841L;
    private List<MhTemplateData> templateRes = null;

    public List<MhTemplateData> getTemplateRes() {
        return this.templateRes;
    }

    public void setTemplateRes(List<MhTemplateData> paramList) {
        this.templateRes = paramList;
    }
}

