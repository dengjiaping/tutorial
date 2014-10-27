/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserID5RecordDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.ext;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserID5RecordDTO implements Serializable {

    private static final long serialVersionUID = -311176692119549421L;

    private final Long id;
    private final Long userId;
    private final String realName;
    private final String idCard;
    private final String schoolName;
    private final String education;
    private final String entranceTime;
    private final String profession;
    private final String graduation;
    private final String studyResult;
    private final String studyChannel;
    private final DateTime createdDate;

    public UserID5RecordDTO(Long id, Long userId, String realName, String idCard,
                            String schoolName, String education, String entranceTime,
                            String profession, String graduation, String studyResult,
                            String studyChannel, DateTime createdDate) {
        this.id = id;
        this.userId = userId;
        this.realName = realName;
        this.idCard = idCard;
        this.schoolName = schoolName;
        this.education = education;
        this.entranceTime = entranceTime;
        this.profession = profession;
        this.graduation = graduation;
        this.studyResult = studyResult;
        this.studyChannel = studyChannel;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getRealName() {
        return realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getEducation() {
        return education;
    }

    public String getEntranceTime() {
        return entranceTime;
    }

    public String getProfession() {
        return profession;
    }

    public String getGraduation() {
        return graduation;
    }

    public String getStudyResult() {
        return studyResult;
    }

    public String getStudyChannel() {
        return studyChannel;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("UserID5RecordDTO{id=%d, userId=%d, realName='%s', idCard='%s', schoolName='%s', education='%s', " +
                        "entranceTime='%s', profession='%s', graduation='%s', studyResult='%s', studyChannel='%s', createdDate='%s'}",
                id, userId, realName, idCard, schoolName, education, entranceTime, profession, graduation, studyResult, studyChannel, createdDate);
    }
}
