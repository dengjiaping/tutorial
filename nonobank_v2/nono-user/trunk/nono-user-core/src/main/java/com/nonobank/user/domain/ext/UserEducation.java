/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserEducation.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;
import com.nonobank.user.domain.dict.Dict;

/**
 * @author Yichuan
 * @version $Id: UserEducation.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class UserEducation extends AbstractRecording<Long, UserEducation> {

    public static final String PROP_SCHOOL_NAME = "schoolName";
    public static final String PROP_PROFESSION = "profession";
    public static final String PROP_EDUCATION = "education";
    public static final String PROP_START_YEAR = "startYear";
    public static final String PROP_START_MONTH = "startMonth";
    public static final String PROP_END_YEAR = "endYear";
    public static final String PROP_END_MONTH = "endMonth";
    public static final String PROP_REMARKS = "remarks";

    private static final long serialVersionUID = -7978503068933958440L;

    // 用户ID
    private Long userId;
    // 用户名
    private String userName;
    // 学校名称
    private String schoolName;
    // 专业
    private String profession;
    // 学历
    private Dict education;
    // 开始-年
    private Integer startYear;
    // 开始-月
    private Integer startMonth;
    // 截止-年
    private Integer endYear;
    // 截止-月
    private Integer endMonth;
    // 备注
    private String remarks;

    public UserEducation() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Dict getEducation() {
        return education;
    }

    public void setEducation(Dict education) {
        this.education = education;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
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
                .add(PROP_USER_NAME, getUserName())
                .add(PROP_SCHOOL_NAME, getSchoolName())
                .add(PROP_PROFESSION, getProfession())
                .add(PROP_EDUCATION, getEducation())
                .add(PROP_START_YEAR, getStartYear())
                .add(PROP_START_MONTH, getStartMonth())
                .add(PROP_END_YEAR, getEndYear())
                .add(PROP_END_MONTH, getEndMonth())
                .add(PROP_REMARKS, getRemarks()).toString();
    }
}
