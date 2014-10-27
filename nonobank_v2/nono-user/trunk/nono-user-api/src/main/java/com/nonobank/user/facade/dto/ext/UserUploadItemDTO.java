/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserUploadItemDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.ext;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserUploadItemDTO implements Serializable {

    private static final long serialVersionUID = 5657701247234506485L;

    private final Long id;
    private final Long uploadId;
    private final String fileName;
    private final String fileType;
    private final String fileUrl;
    private final Integer fileSize;
    private final String fileDesc;
    private final DateTime createdDate;

    public UserUploadItemDTO(Long id, Long uploadId, String fileName, String fileType, String fileUrl,
                             Integer fileSize, String fileDesc, DateTime createdDate) {
        this.id = id;
        this.uploadId = uploadId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileUrl = fileUrl;
        this.fileSize = fileSize;
        this.fileDesc = fileDesc;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public Long getUploadId() {
        return uploadId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public String getFileDesc() {
        return fileDesc;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("UserUploadItemDTO{id=%d, uploadId=%d, fileName='%s', fileType='%s', " +
                        "fileUrl='%s', fileSize=%d, fileDesc='%s', createdDate='%s'}",
                id, uploadId, fileName, fileType, fileUrl, fileSize, fileDesc, createdDate);
    }
}
