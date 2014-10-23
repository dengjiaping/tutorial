/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserAuthcDTO.java 2014-10-23 15:36
 */

package com.nonobank.user.facade.dto.core;

import com.nonobank.user.facade.dto.dict.DictDTO;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id: UserAuthcDTO.java 262 2014-10-23 08:10:39Z yichuan $
 * @since 2.0
 */
public class UserAuthcDTO implements Serializable {

    private static final long serialVersionUID = -8318247228665545188L;

    private final Long userId;
    private final String userName;
    private final String email;
    private final Boolean emailVerified;
    private final String mobileNO;
    private final Boolean mobileVerified;
    private final String avatar;
    private final Short avatarStatus;
    private final String realName;
    private final String idCard;
    private final Boolean cardVerified;
    private final DictDTO education;
    private final String diploma;
    private final String eduValidCode;
    private final DateTime eduCreateTime;
    private final Boolean eduVerified;
    private final String profession; // 专业
    private final String stuNumber; // 学号
    private final String univLocation; // 学校所在省市
    private final String univName; // 院校名
    private final String campus; // 校区
    private final Integer entranceYear; // 入学年份
    private final Boolean stuVerified;
    private final Boolean faceVerified;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public UserAuthcDTO(Long userId, String userName, String email, Boolean emailVerified,
                        String mobileNO, Boolean mobileVerified, String avatar,
                        Short avatarStatus, String realName, String idCard, Boolean cardVerified,
                        DictDTO education, String diploma, String eduValidCode,
                        DateTime eduCreateTime, Boolean eduVerified, String profession,
                        String stuNumber, String univLocation, String univName, String campus,
                        Integer entranceYear, Boolean stuVerified, Boolean faceVerified,
                        DateTime lastModifiedDate, DateTime createdDate) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.emailVerified = emailVerified;
        this.mobileNO = mobileNO;
        this.mobileVerified = mobileVerified;
        this.avatar = avatar;
        this.avatarStatus = avatarStatus;
        this.realName = realName;
        this.idCard = idCard;
        this.cardVerified = cardVerified;
        this.education = education;
        this.diploma = diploma;
        this.eduValidCode = eduValidCode;
        this.eduCreateTime = eduCreateTime;
        this.eduVerified = eduVerified;
        this.profession = profession;
        this.stuNumber = stuNumber;
        this.univLocation = univLocation;
        this.univName = univName;
        this.campus = campus;
        this.entranceYear = entranceYear;
        this.stuVerified = stuVerified;
        this.faceVerified = faceVerified;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public Boolean getMobileVerified() {
        return mobileVerified;
    }

    public String getAvatar() {
        return avatar;
    }

    public Short getAvatarStatus() {
        return avatarStatus;
    }

    public String getRealName() {
        return realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public Boolean getCardVerified() {
        return cardVerified;
    }

    public DictDTO getEducation() {
        return education;
    }

    public String getDiploma() {
        return diploma;
    }

    public String getEduValidCode() {
        return eduValidCode;
    }

    public DateTime getEduCreateTime() {
        return eduCreateTime;
    }

    public Boolean getEduVerified() {
        return eduVerified;
    }

    public String getProfession() {
        return profession;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public String getUnivLocation() {
        return univLocation;
    }

    public String getUnivName() {
        return univName;
    }

    public String getCampus() {
        return campus;
    }

    public Integer getEntranceYear() {
        return entranceYear;
    }

    public Boolean getStuVerified() {
        return stuVerified;
    }

    public Boolean getFaceVerified() {
        return faceVerified;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("UserAuthcDTO{userId=%d, userName='%s', email='%s', mobileNO='%s', " +
                "avatar='%s', realName='%s', idCard='%s', lastModifiedDate='%s', createdDate='%s'}",
                userId, userName, email, mobileNO, avatar, realName, idCard, lastModifiedDate, createdDate);
    }
}
