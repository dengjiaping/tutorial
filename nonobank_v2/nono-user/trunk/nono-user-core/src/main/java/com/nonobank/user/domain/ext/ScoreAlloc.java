/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) ScoreAlloc.java 2014-10-16 09:34
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;
import com.nonobank.user.domain.ext.common.ScoreAllocType;

/**
 * 用户属性积分关联信息实体
 *
 * @author Yichuan
 * @version $Id: ScoreAlloc.java 212 2014-10-20 01:48:43Z yichuan $
 * @since 2.0
 */
public class ScoreAlloc extends AbstractRecording<Long, ScoreAlloc> {

    public static final String PROP_ALLOC_NAME = "allocName";
    public static final String PROP_ALLOC_TYPE = "allocType";
    public static final String PROP_KEYWORD = "keyword";
    public static final String PROP_ALLOC_DESC = "allocDesc";
    public static final String PROP_MIN_SCORE = "minScore";
    public static final String PROP_MAX_SCORE = "maxScore";
    public static final String PROP_IS_ENABLED = "isEnabled";
    public static final String PROP_REFUSE_REASON = "refuseReason";
    public static final String PROP_ORDER_NUM = "orderNum";
    public static final String PROP_IS_AUTO_ASSIGN = "isAutoAssign";

    private static final long serialVersionUID = -130068228036929353L;

    private String allocName;
    private ScoreAllocType allocType;
    private String keyword;
    private String allocDesc;
    private Integer minScore;
    private Integer maxScore;
    private boolean isEnabled;
    private String refuseReason;
    private Integer orderNum;
    private boolean isAutoAssign;

    public ScoreAlloc() {
        super();
    }

    public String getAllocName() {
        return allocName;
    }

    public void setAllocName(String allocName) {
        this.allocName = allocName;
    }

    public ScoreAllocType getAllocType() {
        return allocType;
    }

    public void setAllocType(ScoreAllocType allocType) {
        this.allocType = allocType;
    }

    public String getAllocDesc() {
        return allocDesc;
    }

    public void setAllocDesc(String allocDesc) {
        this.allocDesc = allocDesc;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public boolean isAutoAssign() {
        return isAutoAssign;
    }

    public void setAutoAssign(boolean isAutoAssign) {
        this.isAutoAssign = isAutoAssign;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_ID, getId())
                .add(PROP_ALLOC_NAME, getAllocName())
                .add(PROP_ALLOC_TYPE, getAllocType())
                .add(PROP_ALLOC_DESC, getAllocDesc())
                .add(PROP_KEYWORD, getKeyword())
                .add(PROP_MIN_SCORE, getMinScore())
                .add(PROP_MAX_SCORE, getMaxScore())
                .add(PROP_IS_ENABLED, isEnabled())
                .add(PROP_REFUSE_REASON, getRefuseReason())
                .add(PROP_ORDER_NUM, getOrderNum())
                .add(PROP_IS_AUTO_ASSIGN, isAutoAssign())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }
}
