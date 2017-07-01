package com.shouyiren.btime.baopai.operator.file.api;

/**
 * 作者：ZhouJianxing on 2017/7/1 13:29
 * email:727933147@qq.com
 */

public interface IFile {
    int ERR_BLOCK_FILE_ASSEMBL_FAILED = 6011;
    int ERR_BLOCK_FILE_NOT_EXISTED = 6010;
    int ERR_CLOUDSPACE_FULL = 6002;
    int ERR_FARM_NOT_EXISTED = 6005;
    int ERR_FILE_NOT_EXISTED = 6003;
    int ERR_FILE_PARSE_IMAGE_ERROR = 6009;
    int ERR_THUMBNAIL_FILE_CREATE_FAILED = 6012;
    int ERR_UNSUPPORTED_FILETYPE = 6004;
    int ERR_UPLOADFAILURE = 6001;
    int ERR_UPLOAD_FILE_TOO_SMALL = 6007;
    int ERR_UPLOAD_INVALID_FILE_TO_FARM = 6006;
    int ERR_UPLOAD_OSS_FAILURE = 6008;
    int FILE_STATUS_CREATED = 0;
    int FILE_STATUS_DELETED = 2;
    int FILE_STATUS_UPLOADED = 1;
    int MEDIA_TS_CONTENT_ACTIVITY = 0;
    int MEDIA_TS_CONTENT_EVENT = 1;
    int MEDIA_TS_CONTENT_FORUM = 2;
    int MEDIA_TYPE_ALL = 0;
    int MEDIA_TYPE_AUDIO = 3;
    int MEDIA_TYPE_PHOTO = 1;
    int MEDIA_TYPE_PV = 4;
    int MEDIA_TYPE_VIDEO = 2;
}

