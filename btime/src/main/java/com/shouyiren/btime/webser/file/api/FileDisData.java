package com.shouyiren.btime.webser.file.api;

/**
 * 作者：ZhouJianxing on 2017/7/1 10:50
 * email:727933147@qq.com
 */

public class FileDisData
        extends FileData {
    private static final long serialVersionUID = 3551713972931464582L;
    private String table;

    public FileDisData() {
    }

    public FileDisData(FileData paramFileData) {
        setDuration(paramFileData.getDuration());
        setFarm(paramFileData.getFarm());
        setFid(paramFileData.getFid());
        setFileType(paramFileData.getFileType());
        setGpsInfo(paramFileData.getGpsInfo());
        setHeight(paramFileData.getHeight());
        setName(paramFileData.getName());
        setOrigTime(paramFileData.getOrigTime());
        setOwner(paramFileData.getOwner());
        setSecret(paramFileData.getSecret());
        setSize(paramFileData.getSize());
        setStatus(paramFileData.getStatus());
        setUploadTime(paramFileData.getUploadTime());
        setWidth(paramFileData.getWidth());
    }

    public FileData asFileData() {
        FileData localFileData = new FileData();
        localFileData.setDuration(getDuration());
        localFileData.setFarm(getFarm());
        localFileData.setFid(getFid());
        localFileData.setFileType(getFileType());
        localFileData.setGpsInfo(getGpsInfo());
        localFileData.setHeight(getHeight());
        localFileData.setName(getName());
        localFileData.setOrigTime(getOrigTime());
        localFileData.setOwner(getOwner());
        localFileData.setSecret(getSecret());
        localFileData.setSize(getSize());
        localFileData.setStatus(getStatus());
        localFileData.setUploadTime(getUploadTime());
        localFileData.setWidth(getWidth());
        return localFileData;
    }

    public String getTable() {
        return this.table;
    }

    public void setTable(String paramString) {
        this.table = paramString;
    }
}

