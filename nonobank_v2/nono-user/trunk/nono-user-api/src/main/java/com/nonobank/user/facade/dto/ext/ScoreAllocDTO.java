/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ScoreAllocDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.ext;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class ScoreAllocDTO implements Serializable {

    private static final long serialVersionUID = 8082247945142558718L;

    private final Long id;
    private final String allocName;
    private final Short allocType;
    private final String keyword;
    private final String allocDesc;
    private final Integer minScore;
    private final Integer maxScore;
    private final Boolean isEnabled;
    private final String refuseReason;
    private final Integer orderNum;
    private final Boolean isAutoAssign;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public ScoreAllocDTO(Long id, String allocName, Short allocType, String keyword,
                         String allocDesc, Integer minScore, Integer maxScore,
                         Boolean isEnabled, String refuseReason, Integer orderNum,
                         Boolean isAutoAssign, DateTime lastModifiedDate, DateTime createdDate) {
        this.id = id;
        this.allocName = allocName;
        this.allocType = allocType;
        this.keyword = keyword;
        this.allocDesc = allocDesc;
        this.minScore = minScore;
        this.maxScore = maxScore;
        this.isEnabled = isEnabled;
        this.refuseReason = refuseReason;
        this.orderNum = orderNum;
        this.isAutoAssign = isAutoAssign;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public String getAllocName() {
        return allocName;
    }

    public Short getAllocType() {
        return allocType;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getAllocDesc() {
        return allocDesc;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public Boolean getIsAutoAssign() {
        return isAutoAssign;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("ScoreAllocDTO{id=%d, allocName='%s', allocType=%d, keyword='%s', allocDesc='%s', minScore=%d, " +
                "maxScore=%d, isEnabled='%s', refuseReason='%s', orderNum=%d, isAutoAssign='%s', lastModifiedDate='%s', createdDate='%s'}",
                id, allocName, allocType, keyword, allocDesc, minScore, maxScore, isEnabled, refuseReason, orderNum, isAutoAssign, lastModifiedDate, createdDate);
    }
}
