/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserProfileDTO.java 2014-10-23 14:37
 */

package com.nonobank.user.facade.dto.core;

import com.nonobank.user.facade.dto.dict.DictDTO;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id: UserProfileDTO.java 260 2014-10-23 07:18:22Z yichuan $
 * @since 2.0
 */
public class UserProfileDTO implements Serializable {

    private static final long serialVersionUID = -434398701870290937L;

    private final Long userId;
    private final String userName;
    private final String hashedKey;
    private final String englishName;
    private final String formerName;
    private final String mobileNO;
    private final Boolean mobileVerified;
    private final String mobileNO2;
    private final String email;
    private final Boolean emailVerified;
    private final String idCard;
    private final String realName;
    private final Integer age;
    private final String gender;
    private final String censusProvince;
    private final String censusCity;
    private final String censusAddress;
    private final String liveProvince;
    private final String liveCity;
    private final String liveAddress;
    private final String liveContact;
    private final String qq;
    private final DictDTO marriage;
    private final DictDTO education;
    private final DictDTO position;
    private final DictDTO skillCert;
    private final Boolean socialSecurity;
    private final Boolean passport;
    private final Boolean driving;
    private final String userType;
    private final DateTime userTypeTime;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public UserProfileDTO(Long userId, String userName, String hashedKey, String englishName,
                          String formerName, String mobileNO, Boolean mobileVerified,
                          String mobileNO2, String email, Boolean emailVerified, String idCard,
                          String realName, Integer age, String gender, String censusProvince,
                          String censusCity, String censusAddress, String liveProvince, String liveCity,
                          String liveAddress, String liveContact, String qq, DictDTO marriage,
                          DictDTO education, DictDTO position, DictDTO skillCert, Boolean socialSecurity,
                          Boolean passport, Boolean driving, String userType, DateTime userTypeTime, DateTime lastModifiedDate, DateTime createdDate) {
        this.userId = userId;
        this.userName = userName;
        this.hashedKey = hashedKey;
        this.englishName = englishName;
        this.formerName = formerName;
        this.mobileNO = mobileNO;
        this.mobileVerified = mobileVerified;
        this.mobileNO2 = mobileNO2;
        this.email = email;
        this.emailVerified = emailVerified;
        this.idCard = idCard;
        this.realName = realName;
        this.age = age;
        this.gender = gender;
        this.censusProvince = censusProvince;
        this.censusCity = censusCity;
        this.censusAddress = censusAddress;
        this.liveProvince = liveProvince;
        this.liveCity = liveCity;
        this.liveAddress = liveAddress;
        this.liveContact = liveContact;
        this.qq = qq;
        this.marriage = marriage;
        this.education = education;
        this.position = position;
        this.skillCert = skillCert;
        this.socialSecurity = socialSecurity;
        this.passport = passport;
        this.driving = driving;
        this.userType = userType;
        this.userTypeTime = userTypeTime;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getFormerName() {
        return formerName;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public Boolean isMobileVerified() {
        return mobileVerified;
    }

    public String getMobileNO2() {
        return mobileNO2;
    }

    public String getEmail() {
        return email;
    }

    public Boolean isEmailVerified() {
        return emailVerified;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getRealName() {
        return realName;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getCensusProvince() {
        return censusProvince;
    }

    public String getCensusCity() {
        return censusCity;
    }

    public String getCensusAddress() {
        return censusAddress;
    }

    public String getLiveProvince() {
        return liveProvince;
    }

    public String getLiveCity() {
        return liveCity;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public String getLiveContact() {
        return liveContact;
    }

    public String getQq() {
        return qq;
    }

    public DictDTO getMarriage() {
        return marriage;
    }

    public DictDTO getEducation() {
        return education;
    }

    public DictDTO getPosition() {
        return position;
    }

    public DictDTO getSkillCert() {
        return skillCert;
    }

    public Boolean isSocialSecurity() {
        return socialSecurity;
    }

    public Boolean isPassport() {
        return passport;
    }

    public Boolean isDriving() {
        return driving;
    }

    public String getUserType() {
        return userType;
    }

    public DateTime getUserTypeTime() {
        return userTypeTime;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("UserProfileDTO{userId=%d, userName='%s', hashedKey='%s', englishName='%s', formerName='%s', " +
                        "mobileNO='%s', mobileNO2='%s', email='%s', idCard='%s', realName='%s', age=%d, gender='%s'}",
                userId, userName, hashedKey, englishName, formerName, mobileNO, mobileNO2, email, idCard, realName, age, gender);
    }
}
