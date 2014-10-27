/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserScoreIncome.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;
import org.joda.time.DateTime;

/**
 * 用户积分收入详细
 *
 * @author Yichuan
 * @version $Id: UserScoreIncome.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class UserScoreIncome extends AbstractRecording<Long, UserScoreIncome> {

    public static final String PROP_SCORE_ALLOC_ID = "scoreTypeId";
    public static final String PROP_SCORE = "score";
    public static final String PROP_AUDIT_SCORE = "auditScore";
    public static final String PROP_AUDITOR_ID = "auditorId";
    public static final String PROP_AUDIT_TIME = "auditTime";
    public static final String PROP_IS_CONFIRM = "isConfirm";
    public static final String PROP_REMARKS = "remarks";

    private static final long serialVersionUID = -4908835459098974399L;

    private Long userId;
    private Long scoreAllocId;
    private Integer score;
    private Integer auditScore;
    private Integer auditorId;
    private DateTime auditTime;
    private boolean isConfirm;
    private String remarks;

    public UserScoreIncome() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getScoreAllocId() {
        return scoreAllocId;
    }

    public void setScoreAllocId(Long scoreAllocId) {
        this.scoreAllocId = scoreAllocId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getAuditScore() {
        return auditScore;
    }

    public void setAuditScore(Integer auditScore) {
        this.auditScore = auditScore;
    }

    public Integer getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Integer auditorId) {
        this.auditorId = auditorId;
    }

    public DateTime getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(DateTime auditTime) {
        this.auditTime = auditTime;
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean isConfirm) {
        this.isConfirm = isConfirm;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId())
                .add(PROP_SCORE_ALLOC_ID, getScoreAllocId())
                .add(PROP_SCORE, getScore())
                .add(PROP_AUDIT_SCORE, getAuditScore())
                .add(PROP_AUDITOR_ID, getAuditorId())
                .add(PROP_AUDIT_TIME, getAuditTime())
                .add(PROP_IS_CONFIRM, isConfirm())
                .add(PROP_REMARKS, getRemarks())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }
}
