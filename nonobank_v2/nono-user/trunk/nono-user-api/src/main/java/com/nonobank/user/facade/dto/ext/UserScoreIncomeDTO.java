/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserScoreIncomeDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.ext;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserScoreIncomeDTO implements Serializable {

    private static final long serialVersionUID = 4892287638452692103L;

    private final Long id;
    private final Long userId;
    private final Long scoreAllocId;
    private final Integer score;
    private final Integer auditScore;
    private final Integer auditorId;
    private final DateTime auditTime;
    private final Boolean isConfirm;
    private final String remarks;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public UserScoreIncomeDTO(Long id, Long userId, Long scoreAllocId, Integer score,
                              Integer auditScore, Integer auditorId, DateTime auditTime,
                              Boolean isConfirm, String remarks, DateTime lastModifiedDate, DateTime createdDate) {
        this.id = id;
        this.userId = userId;
        this.scoreAllocId = scoreAllocId;
        this.score = score;
        this.auditScore = auditScore;
        this.auditorId = auditorId;
        this.auditTime = auditTime;
        this.isConfirm = isConfirm;
        this.remarks = remarks;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getScoreAllocId() {
        return scoreAllocId;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getAuditScore() {
        return auditScore;
    }

    public Integer getAuditorId() {
        return auditorId;
    }

    public DateTime getAuditTime() {
        return auditTime;
    }

    public Boolean getIsConfirm() {
        return isConfirm;
    }

    public String getRemarks() {
        return remarks;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("UserScoreIncomeDTO{id=%d, userId=%d, scoreAllocId=%d, score=%d, " +
                        "auditScore=%d, auditorId=%d, auditTime='%s', isConfirm='%s', remarks='%s', lastModifiedDate='%s', createdDate='%s'}",
                id, userId, scoreAllocId, score, auditScore, auditorId, auditTime, isConfirm, remarks, lastModifiedDate, createdDate);
    }
}
