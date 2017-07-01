package com.shouyiren.btime.baopai.operator.file.api;

/**
 * 文件类型
 * 作者：ZhouJianxing on 2017/7/1 13:29
 * email:727933147@qq.com
 */

public class FileType {
    private String ext;
    private String fileContentType;
    private Integer fileType;
    private String thumbContentType;
    private String thumbExt;

    public String getExt() {
        return this.ext;
    }

    public String getFileContentType() {
        return this.fileContentType;
    }

    public Integer getFileType() {
        return this.fileType;
    }

    public String getThumbContentType() {
        return this.thumbContentType;
    }

    public String getThumbExt() {
        return this.thumbExt;
    }

    public void setExt(String paramString) {
        this.ext = paramString;
    }

    public void setFileContentType(String paramString) {
        this.fileContentType = paramString;
    }

    public void setFileType(Integer paramInteger) {
        this.fileType = paramInteger;
    }

    public void setThumbContentType(String paramString) {
        this.thumbContentType = paramString;
    }

    public void setThumbExt(String paramString) {
        this.thumbExt = paramString;
    }
}


