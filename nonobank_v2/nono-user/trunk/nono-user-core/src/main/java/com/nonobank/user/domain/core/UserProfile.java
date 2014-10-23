/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserProfile.java 2014-10-09 15:17
 */

package com.nonobank.user.domain.core;

import com.google.common.base.MoreObjects;
import com.nonobank.common.base.Gender;
import com.nonobank.user.domain.ctx.UserCmdContext;
import com.nonobank.user.domain.dict.Dict;
import com.nonobank.user.domain.dict.Exist;
import org.joda.time.DateTime;

/**
 * 用户基本信息实体。
 *
 * @author fuchun
 * @version $Id: UserProfile.java 228 2014-10-21 07:38:59Z yichuan $
 * @since 2.0
 */
public class UserProfile extends BaseUser<UserProfile> {

    public static final String PROP_USER_NAME = "userName";
    public static final String PROP_HASHED_KEY = "hashedKey";
    public static final String PROP_ENGLISH_NAME = "englishName";
    public static final String PROP_FORMER_NAME = "formerName";
    public static final String PROP_ID_CARD = "idCard";
    public static final String PROP_REAL_NAME = "realName";
    public static final String PROP_AGE = "age";
    public static final String PROP_GENDER = "gender";
    public static final String PROP_CENSUS_PROVINCE = "censusProvince";
    public static final String PROP_CENSUS_CITY = "censusCity";
    public static final String PROP_CENSUS_ADDRESS = "censusAddress";
    public static final String PROP_LIVE_PROVINCE = "liveProvince";
    public static final String PROP_LIVE_CITY = "liveCity";
    public static final String PROP_LIVE_ADDRESS = "liveAddress";
    public static final String PROP_LIVE_CONTACT = "liveContact";
    public static final String PROP_MARRIAGE = "marriage";
    public static final String PROP_MOBILE_NO = "mobileNO";
    public static final String PROP_MOBILE_VERIFIED = "mobileVerified";
    public static final String PROP_MOBILE_NO2 = "mobileNO2";
    public static final String PROP_EMAIL = "email";
    public static final String PROP_EMAIL_VERIFIED = "emailVerified";
    public static final String PROP_QQ = "qq";
    public static final String PROP_SOCIAL_SECURITY = "socialSecurity";
    public static final String PROP_PASSPORT = "passport";
    public static final String PROP_DRIVING = "driving";
    public static final String PROP_EDUCATION = "education";
    public static final String PROP_POSITION = "position";
    public static final String PROP_SKILL_CERT =  "skillCert";
    public static final String PROP_USER_TYPE = "userType";
    public static final String PROP_USER_TYPE_TIME = "userTypeTime";

    private static final long serialVersionUID = 5857589299591918386L;

    /**
     * 获取指定用户id的用户个人信息。
     * <p />
     * 如果指定的用户id有{@code userId == null || userId <= 0}，直接返回{@code null}。
     *
     * @param userId 用户id。
     * @return 返回指定用户id的用户个人信息。
     */
    public static UserProfile get(Long userId) {
        if (userId == null || userId <= 0) {
            return null;
        }
        return UserCmdContext.userProfileRepository().findOne(userId);
    }

    /**
     * 获取指定用户名的用户个人信息。
     * <p />
     * 如果指定的用户名有{@code userName == null || userName.length() == 0}，直接返回{@code null}。
     *
     * @param userName 用户名。
     * @return 返回指定用户名的用户个人信息。
     */
    public static UserProfile get(String userName) {
        if (userName == null || userName.length() == 0) {
            return null;
        }
        return UserCmdContext.userProfileRepository().findByUserName(userName);
    }

    /**
     * 获取指定手机号的用户个人信息。
     * <p />
     * 如果指定的用手机号有{@code mobileNO == null || mobileNO.length() == 0}，直接返回{@code null}。
     *
     * @param mobileNO 手机号。
     * @return 返回指定手机号的用户个人信息。
     */
    public static UserProfile getByMobileNO(String mobileNO) {
        if (mobileNO == null || mobileNO.length() == 0) {
            return null;
        }
        return UserCmdContext.userProfileRepository().findByMobileNo(mobileNO);
    }

    // 用户名
    private String userName;
    // 用户名的hash
    private String hashedKey;
    // 英文名
    private String englishName;
    // 曾用名
    private String formerName;
    // 手机号码
    private String mobileNO;
    // 手机是否验证
    private boolean mobileVerified;
    // 手机号码2
    private String mobileNO2;
    // 邮箱地址
    private String email;
    // 邮箱是否验证
    private boolean emailVerified;
    // 身份证号码
    private String idCard;
    // 真实姓名
    private String realName;
    // 年龄(保持身份证一致)
    private Integer age;
    // 性别(保持身份证一致)
    private Gender gender;
    // 户籍省
    private String censusProvince;
    // 户籍市
    private String censusCity;
    // 户籍地址
    private String censusAddress;
    // 居住省
    private String liveProvince;
    // 居住市
    private String liveCity;
    // 居住地址
    private String liveAddress;
    // 居住联系方式(手机号码或固定电话号码)
    private String liveContact;
    // qq号码
    private String qq;
    // 婚姻状况
    private Dict marriage;
    // 学历
    private Dict education;
    // 职位
    private Dict position;
    // 职称
    private Dict skillCert;
    // 社保、养老金或公积金
    private Exist socialSecurity;
    // 护照
    private Exist passport;
    // 驾照
    private Exist driving;
    // 用户类型
    private String userType;
    // 用户类型更新时间
    private DateTime userTypeTime;

    public UserProfile() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCensusProvince() {
        return censusProvince;
    }

    public void setCensusProvince(String censusProvince) {
        this.censusProvince = censusProvince;
    }

    public String getCensusCity() {
        return censusCity;
    }

    public void setCensusCity(String censusCity) {
        this.censusCity = censusCity;
    }

    public String getCensusAddress() {
        return censusAddress;
    }

    public void setCensusAddress(String censusAddress) {
        this.censusAddress = censusAddress;
    }

    public String getLiveProvince() {
        return liveProvince;
    }

    public void setLiveProvince(String liveProvince) {
        this.liveProvince = liveProvince;
    }

    public String getLiveCity() {
        return liveCity;
    }

    public void setLiveCity(String liveCity) {
        this.liveCity = liveCity;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getLiveContact() {
        return liveContact;
    }

    public void setLiveContact(String liveContact) {
        this.liveContact = liveContact;
    }

    public Dict getMarriage() {
        return marriage;
    }

    public void setMarriage(Dict marriage) {
        this.marriage = marriage;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public void setMobileNO(String mobileNO) {
        this.mobileNO = mobileNO;
    }

    public boolean isMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Exist getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(Exist socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public Exist getPassport() {
        return passport;
    }

    public void setPassport(Exist passport) {
        this.passport = passport;
    }

    public Exist getDriving() {
        return driving;
    }

    public void setDriving(Exist driving) {
        this.driving = driving;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Dict getPosition() {
        return position;
    }

    public void setPosition(Dict position) {
        this.position = position;
    }

    public Dict getSkillCert() {
        return skillCert;
    }

    public void setSkillCert(Dict skillCert) {
        this.skillCert = skillCert;
    }

    public Dict getEducation() {
        return education;
    }

    public void setEducation(Dict education) {
        this.education = education;
    }

    public String getMobileNO2() {
        return mobileNO2;
    }

    public void setMobileNO2(String mobileNO2) {
        this.mobileNO2 = mobileNO2;
    }

    public DateTime getUserTypeTime() {
        return userTypeTime;
    }

    public void setUserTypeTime(DateTime userTypeTime) {
        this.userTypeTime = userTypeTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId())
                .add(PROP_USER_NAME, getUserName())
                .add(PROP_HASHED_KEY, getHashedKey())
                .add(PROP_ENGLISH_NAME, getEnglishName())
                .add(PROP_FORMER_NAME, getFormerName())
                .add(PROP_MOBILE_NO, getMobileNO())
                .add(PROP_MOBILE_VERIFIED, isMobileVerified())
                .add(PROP_MOBILE_NO2, getMobileNO2())
                .add(PROP_EMAIL, getEmail())
                .add(PROP_EMAIL_VERIFIED, isEmailVerified())
                .add(PROP_ID_CARD, getIdCard())
                .add(PROP_REAL_NAME, getRealName())
                .add(PROP_AGE, getAge())
                .add(PROP_GENDER, getGender())
                .add(PROP_CENSUS_PROVINCE, getCensusProvince())
                .add(PROP_CENSUS_CITY, getCensusCity())
                .add(PROP_CENSUS_ADDRESS, getCensusAddress())
                .add(PROP_LIVE_PROVINCE, getLiveProvince())
                .add(PROP_LIVE_CITY, getLiveCity())
                .add(PROP_LIVE_ADDRESS, getLiveAddress())
                .add(PROP_LIVE_CONTACT, getLiveContact())
                .add(PROP_QQ, getQq())
                .add(PROP_MARRIAGE, getMarriage())
                .add(PROP_EDUCATION, getEducation())
                .add(PROP_POSITION, getPosition())
                .add(PROP_SKILL_CERT, getSkillCert())
                .add(PROP_SOCIAL_SECURITY, getSocialSecurity())
                .add(PROP_PASSPORT, getPassport())
                .add(PROP_DRIVING, getDriving())
                .add(PROP_USER_TYPE, getUserType())
                .add(PROP_USER_TYPE_TIME, getUserTypeTime())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }
}
