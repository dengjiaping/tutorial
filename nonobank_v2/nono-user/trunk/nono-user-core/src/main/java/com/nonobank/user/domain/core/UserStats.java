/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserDigital.java 2014-10-09 15:19
 */

package com.nonobank.user.domain.core;

import com.google.common.base.MoreObjects;

/**
 * 用户关键数据信息实体。
 *
 * @author fuchun
 * @version $Id: UserStats.java 197 2014-10-17 01:50:40Z yichuan $
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