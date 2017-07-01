package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:34
 * email:727933147@qq.com
 */

public class FilterDataListRes
        extends CommonRes {
    private static final long serialVersionUID = -4611357088907290219L;
    private List<FilterData> filterData = null;

    public List<FilterData> getFilterData() {
        return this.filterData;
    }

    public void setFilterData(List<FilterData> paramList) {
        this.filterData = paramList;
    }
}

