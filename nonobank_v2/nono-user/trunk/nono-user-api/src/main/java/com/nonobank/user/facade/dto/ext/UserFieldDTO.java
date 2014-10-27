/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserFieldDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.ext;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserFieldDTO implements Serializable {

    private static final long serialVersionUID = -5637735961414935331L;

    private final Long id;
    private final Long scoreAllocId;
    private final String fieldName;
    private final String fieldKwd;
    private final Boolean isRequired;
    private final Integer fieldMinLen;
    private final Integer fieldMaxLen;
    private final String fieldNote;
    private final Short verifyMode;
    private final Boolean isIntegrity;
    private final String fieldDesc;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public UserFieldDTO(Long id, Long scoreAllocId, String fieldName, String fieldKwd,
                        Boolean isRequired, Integer fieldMinLen, Integer fieldMaxLen,
                        String fieldNote, Short verifyMode, Boolean isIntegrity,
                        String fieldDesc, DateTime lastModifiedDate, DateTime createdDate) {
        this.id = id;
        this.scoreAllocId = scoreAllocId;
        this.fieldName = fieldName;
        this.fieldKwd = fieldKwd;
        this.isRequired = isRequired;
        this.fieldMinLen = fieldMinLen;
        this.fieldMaxLen = fieldMaxLen;
        this.fieldNote = fieldNote;
        this.verifyMode = verifyMode;
        this.isIntegrity = isIntegrity;
        this.fieldDesc = fieldDesc;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public Long getScoreAllocId() {
        return scoreAllocId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldKwd() {
        return fieldKwd;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public Integer getFieldMinLen() {
        return fieldMinLen;
    }

    public Integer getFieldMaxLen() {
        return fieldMaxLen;
    }

    public String getFieldNote() {
        return fieldNote;
    }

    public Short getVerifyMode() {
        return verifyMode;
    }

    public Boolean getIsIntegrity() {
        return isIntegrity;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("UserFieldDTO{id=%d, scoreAllocId=%d, fieldName='%s', fieldKwd='%s', isRequired='%s', fieldMinLen=%d, " +
                        "fieldMaxLen=%d, fieldNote='%s', verifyMode=%d, isIntegrity='%s', fieldDesc='%s', lastModifiedDate='%s', createdDate='%s'}",
                id, scoreAllocId, fieldName, fieldKwd, isRequired, fieldMinLen, fieldMaxLen, fieldNote, verifyMode, isIntegrity, fieldDesc, lastModifiedDate, createdDate);
    }
}