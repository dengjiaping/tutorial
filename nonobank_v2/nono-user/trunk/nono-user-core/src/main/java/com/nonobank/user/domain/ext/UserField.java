/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserField.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;
import com.nonobank.user.domain.ext.common.VerifyMode;

/**
 * 用户属性设置信息实体
 *
 * @author Yichuan
 * @version $Id: UserField.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class UserField extends AbstractRecording<Long, UserField> {

    public static final String PROP_SCORE_ALLOC_ID = "scoreAllocId";
    public static final String PROP_FIELD_NAME = "fieldName";
    public static final String PROP_FIELD_KWD = "fieldKwd";
    public static final String PROP_IS_REQUIRED = "isRequired";
    public static final String PROP_FIELD_MIN_LEN = "fieldMinLen";
    public static final String PROP_FIELD_MAX_LEN = "fieldMaxLen";
    public static final String PROP_FIELD_NOTE = "fieldNote";
    public static final String PROP_VERIFY_MODE = "verifyMode";
    public static final String PROP_IS_INTEGRITY = "isIntegrity";
    public static final String PROP_FIELD_DESC = "fieldDesc";

    private static final long serialVersionUID = -3139293358436198936L;

    // 积分类型ID
    private Long scoreAllocId;
    // 属性名
    private String fieldName;
    // 属性关键字
    private String fieldKwd;
    // 是否必填
    private boolean isRequired;
    // 属性最小长度
    private Integer fieldMinLen;
    // 属性最大长度
    private Integer fieldMaxLen;
    // 属性旁注
    private String fieldNote;
    // 属性验证模式
    private VerifyMode verifyMode;
    // 属性是否属于信息完整性范畴
    private boolean isIntegrity;
    // 属性描述
    private String fieldDesc;

    public UserField() {
        super();
    }

    public Long getScoreAllocId() {
        return scoreAllocId;
    }

    public void setScoreAllocId(Long scoreAllocId) {
        this.scoreAllocId = scoreAllocId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldKwd() {
        return fieldKwd;
    }

    public void setFieldKwd(String fieldKwd) {
        this.fieldKwd = fieldKwd;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Integer getFieldMinLen() {
        return fieldMinLen;
    }

    public void setFieldMinLen(Integer fieldMinLen) {
        this.fieldMinLen = fieldMinLen;
    }

    public Integer getFieldMaxLen() {
        return fieldMaxLen;
    }

    public void setFieldMaxLen(Integer fieldMaxLen) {
        this.fieldMaxLen = fieldMaxLen;
    }

    public String getFieldNote() {
        return fieldNote;
    }

    public void setFieldNote(String fieldNote) {
        this.fieldNote = fieldNote;
    }

    public VerifyMode getVerifyMode() {
        return verifyMode;
    }

    public void setVerifyMode(VerifyMode verifyMode) {
        this.verifyMode = verifyMode;
    }

    public boolean isIntegrity() {
        return isIntegrity;
    }

    public void setIntegrity(boolean isIntegrity) {
        this.isIntegrity = isIntegrity;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_SCORE_ALLOC_ID, getScoreAllocId())
                .add(PROP_FIELD_NAME, getFieldName())
                .add(PROP_FIELD_KWD, getFieldKwd())
                .add(PROP_IS_REQUIRED, isRequired())
                .add(PROP_FIELD_MIN_LEN, getFieldMinLen())
                .add(PROP_FIELD_MAX_LEN, getFieldMaxLen())
                .add(PROP_FIELD_NOTE, getFieldNote())
                .add(PROP_VERIFY_MODE, getVerifyMode())
                .add(PROP_IS_INTEGRITY, isIntegrity())
                .add(PROP_FIELD_DESC, getFieldDesc())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }
}
