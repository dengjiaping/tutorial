/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserStudent.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.user.domain.core.BaseUser;
import com.nonobank.user.domain.dict.College;
import com.nonobank.user.domain.dict.Dict;

/**
 * 在校学生用户信息。
 *
 * @author fuchun
 * @version $Id: UserStudent.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class UserStudent extends BaseUser<UserStudent> {

    public static final String PROP_COLLEGE_ID = "collegeId";
    public static final String PROP_COLLEGE_NAME = "collegeName";
    public static final String PROP_CAMPUS = "campus";
    public static final String PROP_MAJOR = "major";
    public static final String PROP_STUDENT_NO = "studentNO";
    public static final String PROP_ATTN_YEAR = "attnYear";
    public static final String PROP_EDU_CODE = "eduCode";

    private static final long serialVersionUID = -4745862581893507159L;

    private Integer collegeId;
    private String collegeName;
    private String campus;
    private String major;
    private String studentNO;
    private Integer attnYear;
    private String eduCode;

    // with the collegeId if exists
    private College college;
    // with the eduCode if exists
    private Dict education;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStudentNO() {
        return studentNO;
    }

    public void setStudentNO(String studentNO) {
        this.studentNO = studentNO;
    }

    public Integer getAttnYear() {
        return attnYear;
    }

    public void setAttnYear(Integer attnYear) {
        this.attnYear = attnYear;
    }

    public String getEduCode() {
        return eduCode;
    }

    public void setEduCode(String eduCode) {
        this.eduCode = eduCode;
    }

    public Dict getEducation() {
        return education;
    }

    public void setEducation(Dict education) {
        this.education = education;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId())
                .add(PROP_COLLEGE_ID, getCollegeId())
                .add(PROP_COLLEGE_NAME, getCollegeName())
                .add(PROP_CAMPUS, getCampus())
                .add(PROP_MAJOR, getMajor())
                .add(PROP_STUDENT_NO, getStudentNO())
                .add(PROP_ATTN_YEAR, getAttnYear())
                .add(PROP_EDU_CODE, getEduCode())
                .toString();
    }
}
