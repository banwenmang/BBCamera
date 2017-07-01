package com.shouyiren.btime.baopai.resource.model;

import com.shouyiren.btime.webser.commons.api.CommonRes;

import java.util.List;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:35
 * email:727933147@qq.com
 */

public class MusicListRes
        extends CommonRes {
    private static final long serialVersionUID = -6967897427657859308L;
    private List<MusicData> musicList = null;

    public List<MusicData> getMusicList() {
        return this.musicList;
    }

    public void setMusicList(List<MusicData> paramList) {
        this.musicList = paramList;
    }
}

