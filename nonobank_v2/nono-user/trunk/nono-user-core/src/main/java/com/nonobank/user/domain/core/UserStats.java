/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserStats.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.core;

import com.google.common.base.MoreObjects;

/**
 * 用户关键数据信息实体。
 *
 * @author fuchun
 * @version $Id: UserStats.java 317 2014-10-30 09:20:04Z yichuan $
 * @since 2.0
 */
public class UserStats extends BaseUser<UserStats> {

    public static final String PROP_TOTAL_SCORE = "totalScore";
    public static final String PROP_CURR_SCORE = "currScore";
    public static final String PROP_BORROW_COUNT = "borrowCount";
    public static final String PROP_REJECTED_COUNT = "rejectedCount";
    public static final String PROP_BIDDING_COUNT = "biddingCount";

    private static final long serialVersionUID = -3751329218244482384L;

    // 用户总积分
    private Integer totalScore;
    // 当前积分
    private Integer currScore;
    // 借款成功次数
    private Integer borrowCount;
    // 流标次数(原streamCount)
    private Integer rejectedCount;
    // 投标成功次数
    private Integer biddingCount;

    public UserStats() {
    }

    public UserStats(Long userId, Integer totalScore, Integer currScore,
                     Integer borrowCount, Integer rejectedCount, Integer biddingCount) {
        setUserId(userId);
        this.totalScore = totalScore;
        this.currScore = currScore;
        this.borrowCount = borrowCount;
        this.rejectedCount = rejectedCount;
        this.biddingCount = biddingCount;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getCurrScore() {
        return currScore;
    }

    public void setCurrScore(Integer currScore) {
        this.currScore = currScore;
    }

    public Integer getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(Integer borrowCount) {
        this.borrowCount = borrowCount;
    }

    public Integer getRejectedCount() {
        return rejectedCount;
    }

    public void setRejectedCount(Integer rejectedCount) {
        this.rejectedCount = rejectedCount;
    }

    public Integer getBiddingCount() {
        return biddingCount;
    }

    public void setBiddingCount(Integer biddingCount) {
        this.biddingCount = biddingCount;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId())
                .add(PROP_TOTAL_SCORE, getTotalScore())
                .add(PROP_CURR_SCORE, getCurrScore())
                .add(PROP_BORROW_COUNT, getBorrowCount())
                .add(PROP_REJECTED_COUNT, getRejectedCount())
                .add(PROP_BIDDING_COUNT, getBiddingCount()).toString();
    }
}
