/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserUploadItem.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractEntity;
import org.joda.time.DateTime;

/**
 * 用户上传文件信息实体
 *
 * @author Yichuan
 * @version $Id: UserUploadItem.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class UserUploadItem extends AbstractEntity<Long, UserUploadItem> {

    public static final String PROP_UPLOAD_ID = "uploadId";
    public static final String PROP_FILE_NAME = "fileName";
    public static final String PROP_FILE_TYPE = "fileType";
    public static final String PROP_FILE_URL = "fileUrl";
    public static final String PROP_FILE_SIZE = "fileSize";
    public static final String PROP_FILE_DESC = "fileDesc";
    public static final String PROP_CREATED_DATE = "createdDate";

    private static final long serialVersionUID = -521467668636246738L;

    // 上传批次ID(每次可能上传多个文件，数据查询显示最多的一次上传了569张银行流水的图片)
    private Long uploadId;
    // 文件名
    private String fileName;
    // 文件类型
    private String fileType;
    // 文件url地址
    private String fileUrl;
    // 文件大小
    private Integer fileSize;
    // 文件说明
    private String fileDesc;
    // 创建时间
    private DateTime createdDate;

    public UserUploadItem() {
        super();
    }

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileDesc() {
        return fileDesc;
    }

    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_UPLOAD_ID, getUploadId())
                .add(PROP_FILE_NAME, getFileName())
                .add(PROP_FILE_TYPE, getFileType())
                .add(PROP_FILE_DESC, getFileDesc())
                .add(PROP_FILE_SIZE, getFileSize())
                .add(PROP_FILE_URL, getFileUrl())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }
}
