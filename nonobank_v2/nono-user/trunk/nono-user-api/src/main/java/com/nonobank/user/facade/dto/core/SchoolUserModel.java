/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) SchoolUserModel.java 2014-10-28 10:03
 */

package com.nonobank.user.facade.dto.core;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 学生用户注册模型。
 *
 * @author fuchun
 * @version $Id: SchoolUserModel.java 308 2014-10-30 03:16:07Z fuchun $
 * @since 2.0
 */
public class SchoolUserModel extends BaseUserModel {

    public static final String PROP_SEC_CODE = "secCode";
    public static final String PROP_COLLEGE_ID = "collegeId";
    public static final String PROP_CAMPUS = "campus";
    public static final String PROP_ATTN_YEAR = "attnYear";
    public static final String PROP_EDU_CODE = "eduCode";
    public static final String PROP_STUDENT_NO = "studentNO";
    public static final String PROP_MAJOR = "major";
    public static final String PROP_REAL_NAME = "realName";
    public static final String PROP_ID_CARD = "idCard";
    public static final String PROP_SPEC_CODE = "specCode";

    private static final String[] PROPERTIES = {
            PROP_SEC_CODE, PROP_COLLEGE_ID, PROP_CAMPUS, PROP_ATTN_YEAR,
            PROP_EDU_CODE, PROP_STUDENT_NO, PROP_MAJOR, PROP_REAL_NAME,
            PROP_ID_CARD, PROP_SPEC_CODE
    };

    private static final long serialVersionUID = -5292128842889614773L;

    private static String[] properties;

    public static String[] properties() {
        if (properties == null) {
            String[] baseProperties = BaseUserModel.properties();
            Set<String> basePropSet = Sets.newHashSet(baseProperties);
            Set<String> thisPropSet = Sets.newHashSet(PROPERTIES);
            Set<String> propSet = Sets.union(basePropSet, thisPropSet);
            properties = propSet.toArray(new String[propSet.size()]);
        }
        return properties;
    }

    private String secCode;
    private Integer collegeId;
    private String campus;
    private Integer attnYear;
    private String eduCode;
    private String studentNO;
    private String major;
    private String realName;
    private String idCard;
    /* 校园大使（代码）。*/
    private Short specCode;

    public SchoolUserModel() {
        super();
    }

    public String getSecCode() {
        return secCode;
    }

    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
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

    public String getStudentNO() {
        return studentNO;
    }

    public void setStudentNO(String studentNO) {
        this.studentNO = studentNO;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public Short getSpecCode() {
        return specCode;
    }

    public void setSpecCode(Short specCode) {
        this.specCode = specCode;
    }

    @Override
    public String toString() {
        return toStringHelper()
                .add(PROP_SEC_CODE, getSecCode())
                .add(PROP_COLLEGE_ID, getCollegeId())
                .add(PROP_CAMPUS, getCampus())
                .add(PROP_ATTN_YEAR, getAttnYear())
                .add(PROP_EDU_CODE, getEduCode())
                .add(PROP_STUDENT_NO, getStudentNO())
                .add(PROP_MAJOR, getMajor())
                .add(PROP_REAL_NAME, getRealName())
                .add(PROP_ID_CARD, getIdCard())
                .add(PROP_SPEC_CODE, getSpecCode())
                .toString();
    }
}
