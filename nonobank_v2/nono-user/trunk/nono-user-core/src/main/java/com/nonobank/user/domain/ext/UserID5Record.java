/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserID5Record.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractEntity;
import org.joda.time.DateTime;

/**
 * 国政通(第三方)查询结果记录
 *
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserID5Record extends AbstractEntity<Long, UserID5Record> {

    public static final String PROP_REAL_NAME = "realName";
    public static final String PROP_ID_CARD = "idCard";
    public static final String PROP_SCHOOL_NAME = "schoolName";
    public static final String PROP_EDUCATION = "education";
    public static final String PROP_ENTRANCE_TIME = "entranceTime";
    public static final String PROP_PROFESSION = "profession";
    public static final String PROP_GRADUATION = "graduation";
    public static final String PROP_STUDY_RESULT = "studyResult";
    public static final String PROP_STUDY_CHANNEL = "studyChannel";
    public static final String PROP_CREATED_DATE = "createdDate";

    private static final long serialVersionUID = -5791384123655751957L;

    private Long userId;
    private String realName;
    private String idCard;
    private String schoolName;
    private String education;
    private String entranceTime;
    private String profession;
    private String graduation;
    private String studyResult;
    private String studyChannel;
    private DateTime createdDate;

    public UserID5Record() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(String entranceTime) {
        this.entranceTime = entranceTime;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getStudyResult() {
        return studyResult;
    }

    public void setStudyResult(String studyResult) {
        this.studyResult = studyResult;
    }

    public String getStudyChannel() {
        return studyChannel;
    }

    public void setStudyChannel(String studyChannel) {
        this.studyChannel = studyChannel;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId())
                .add(PROP_REAL_NAME, getRealName())
                .add(PROP_ID_CARD, getIdCard())
                .add(PROP_SCHOOL_NAME, getSchoolName())
                .add(PROP_EDUCATION, getEducation())
                .add(PROP_ENTRANCE_TIME, getEntranceTime())
                .add(PROP_PROFESSION, getProfession())
                .add(PROP_GRADUATION, getGraduation())
                .add(PROP_STUDY_RESULT, getStudyResult())
                .add(PROP_STUDY_CHANNEL, getStudyChannel())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }
}
