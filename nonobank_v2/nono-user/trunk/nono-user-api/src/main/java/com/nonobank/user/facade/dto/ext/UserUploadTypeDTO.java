/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserUploadTypeDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.ext;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserUploadTypeDTO implements Serializable {

    private static final long serialVersionUID = -1894113942443801850L;

    private final Long id;
    private final Long scoreAllocId;
    private final String typeName;
    private final String uploadNote;
    private final String uploadExample;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public UserUploadTypeDTO(Long id, Long scoreAllocId, String typeName, String uploadNote,
                             String uploadExample, DateTime lastModifiedDate, DateTime createdDate) {
        this.id = id;
        this.scoreAllocId = scoreAllocId;
        this.typeName = typeName;
        this.uploadNote = uploadNote;
        this.uploadExample = uploadExample;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public Long getScoreAllocId() {
        return scoreAllocId;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getUploadNote() {
        return uploadNote;
    }

    public String getUploadExample() {
        return uploadExample;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("UserUploadTypeDTO{id=%d, scoreAllocId=%d, typeName='%s', uploadNote='%s', uploadExample='%s', lastModifiedDate='%s', createdDate='%s'}",
                id, scoreAllocId, typeName, uploadNote, uploadExample, lastModifiedDate, createdDate);
    }
}
