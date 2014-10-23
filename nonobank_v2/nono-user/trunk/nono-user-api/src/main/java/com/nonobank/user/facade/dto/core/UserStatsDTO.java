/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserStatsDTO.java 2014-10-23 16:39
 */

package com.nonobank.user.facade.dto.core;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id: UserStatsDTO.java 264 2014-10-23 08:48:26Z yichuan $
 * @since 2.0
 */
public class UserStatsDTO implements Serializable {

    private static final long serialVersionUID = 69607370133016167L;

    public final Long userId;
    private final Integer totalScore;
    private final Integer currScore;
    private final Integer borrowCount;
    private final Integer rejectedCount;
    private final Integer biddingCount;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public UserStatsDTO(Long userId, Integer totalScore, Integer currScore, Integer borrowCount,
                        Integer rejectedCount, Integer biddingCount, DateTime lastModifiedDate, DateTime createdDate) {
        this.userId = userId;
        this.totalScore = totalScore;
        this.currScore = currScore;
        this.borrowCount = borrowCount;
        this.rejectedCount = rejectedCount;
        this.biddingCount = biddingCount;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public Integer getCurrScore() {
        return currScore;
    }

    public Integer getBorrowCount() {
        return borrowCount;
    }

    public Integer getRejectedCount() {
        return rejectedCount;
    }

    public Integer getBiddingCount() {
        return biddingCount;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("UserStatsDTO{userId=%d, totalScore=%d, currScore=%d, borrowCount=%d, rejectedCount=%d, biddingCount=%d, lastModifiedDate='%s', createdDate='%s'}",
                userId, totalScore, currScore, borrowCount, rejectedCount, biddingCount, lastModifiedDate, createdDate);
    }
}
