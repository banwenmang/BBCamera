package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:57
 * email:727933147@qq.com
 */

public class MvTemplateListRes
        extends CommonRes {
    private static final long serialVersionUID = 7689835482018180989L;
    private List<MvTemplateData> templateRes = null;

    public List<MvTemplateData> getTemplateRes() {
        return this.templateRes;
    }

    public void setTemplateRes(List<MvTemplateData> paramList) {
        this.templateRes = paramList;
    }
}

