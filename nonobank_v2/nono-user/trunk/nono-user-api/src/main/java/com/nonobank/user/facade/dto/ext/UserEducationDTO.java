/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserEducationDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.ext;

import com.nonobank.user.facade.dto.dict.DictDTO;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserEducationDTO implements Serializable {

    private static final long serialVersionUID = 1403824003878880675L;

    private final Long id;
    private final Long userId;
    private final String userName;
    private final String schoolName;
    private final String profession;
    private final DictDTO education;
    private final Integer startYear;
    private final Integer startMonth;
    private final Integer endYear;
    private final Integer endMonth;
    private final String remarks;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public UserEducationDTO(Long id, Long userId, String userName, String schoolName,
                            String profession, DictDTO education, Integer startYear,
                            Integer startMonth, Integer endYear, Integer endMonth,
                            String remarks, DateTime lastModifiedDate, DateTime createdDate) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.schoolName = schoolName;
        this.profession = profession;
        this.education = education;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.endYear = endYear;
        this.endMonth = endMonth;
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

    public String getUserName() {
        return userName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getProfession() {
        return profession;
    }

    public DictDTO getEducation() {
        return education;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public Integer getEndMonth() {
        return endMonth;
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
        return String.format("UserEducationDTO{id=%d, userId=%d, userName='%s', schoolName='%s', profession='%s', education=%s, startYear=%d, startMonth=%d, endYear=%d, endMonth=%d, remarks='%s', lastModifiedDate='%s', createdDate='%s'}",
                id, userId, userName, schoolName, profession, education, startYear, startMonth, endYear, endMonth, remarks, lastModifiedDate, createdDate);
    }
}
