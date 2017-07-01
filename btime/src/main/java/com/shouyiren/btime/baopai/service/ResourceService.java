package com.shouyiren.btime.baopai.service;

import com.shouyiren.btime.baopai.common.model.UserContentData;
import com.shouyiren.btime.baopai.resource.model.DirectoryData;
import com.shouyiren.btime.baopai.resource.model.DynamicPasterData;
import com.shouyiren.btime.baopai.resource.model.FilterData;
import com.shouyiren.btime.baopai.resource.model.MhTemplateData;
import com.shouyiren.btime.baopai.resource.model.MusicData;
import com.shouyiren.btime.baopai.resource.model.MvTemplateData;
import com.shouyiren.btime.baopai.resource.model.StaticPasterData;
import com.shouyiren.btime.baopai.resource.model.StaticPasterNewData;
import com.shouyiren.btime.baopai.resource.model.V2DirectoryData;
import com.shouyiren.btime.baopai.resource.model.V2ResourceData;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 14:09
 * email:727933147@qq.com
 * <p>
 * 资源
 */

public interface ResourceService {
    /**
     * 获取所有资源信息
     *
     * @param paramInteger
     * @return
     */
    Object getAllResourceByType(Integer paramInteger);

    /**
     * @param paramLong
     * @return
     */
    List<DirectoryData> getChildDirectory(Long paramLong);

    /**
     * @param paramLong
     * @return
     */
    DirectoryData getDirectory(Long paramLong);

    /**
     * @param paramShort
     * @param paramLong1
     * @param paramInteger
     * @param paramLong2
     * @param paramLong3
     * @return
     */
    List<DynamicPasterData> getDynamicPasterList(Short paramShort, Long paramLong1, Integer paramInteger, Long paramLong2, Long paramLong3);

    List<FilterData> getFilterList(Short paramShort, Long paramLong1, Integer paramInteger, Long paramLong2, Long paramLong3);

    /**
     * 模板列表
     *
     * @param paramShort
     * @param paramLong1
     * @param paramInteger
     * @param paramLong2
     * @param paramLong3
     * @return
     */
    List<MhTemplateData> getMhTemplateList(Short paramShort, Long paramLong1, Integer paramInteger, Long paramLong2, Long paramLong3);

    /**
     * Music
     *
     * @param paramLong1
     * @param paramInteger
     * @param paramLong2
     * @param paramLong3
     * @return
     */
    List<MusicData> getMusicList(Long paramLong1, Integer paramInteger, Long paramLong2, Long paramLong3);

    /**
     * @param paramList
     * @return
     */
    List<MusicData> getMusics(List<Long> paramList);

    /**
     * MV 模板
     *
     * @param paramShort
     * @param paramLong1
     * @param paramInteger
     * @param paramLong2
     * @param paramLong3
     * @return
     */
    List<MvTemplateData> getMvTemplateList(Short paramShort, Long paramLong1, Integer paramInteger, Long paramLong2, Long paramLong3);

    /**
     * 单个资源
     *
     * @param paramLong
     * @param paramInteger
     * @return
     */
    Object getSingleResource(Long paramLong, Integer paramInteger);

    List<StaticPasterNewData> getStaticPasterByType(Integer paramInteger);

    List<StaticPasterData> getStaticPasterList(Short paramShort, Long paramLong1, Integer paramInteger, Long paramLong2, Long paramLong3);

    List<StaticPasterNewData> getStaticPasterNewList(Integer paramInteger1, Long paramLong1, Integer paramInteger2, Long paramLong2, Long paramLong3);

    List<DirectoryData> getTopDirectory(Long paramLong1, Long paramLong2);

    List<V2DirectoryData> getV2ChildDirectory(Integer paramInteger, Long paramLong);

    List<V2ResourceData> getV2ChildResource(Long paramLong);

    V2DirectoryData getV2Directory(Long paramLong);

    V2ResourceData getV2Resource(Long paramLong);

    Long saveResource(Integer paramInteger, String paramString, Long paramLong);

    Long uploadUserContent(UserContentData paramUserContentData);
}

