/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserAuthc.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.core;

import com.google.common.base.MoreObjects;
import com.nonobank.user.domain.ctx.UserCmdContext;
import com.nonobank.user.domain.dict.Dict;
import org.joda.time.DateTime;

import javax.annotation.Nonnull;

/**
 * 用户认证信息实体。
 *
 * @author fuchun
 * @version $Id: UserAuthc.java 296 2014-10-28 09:34:19Z yichuan $
 * @since 2.0
 */
public class UserAuthc extends BaseUser<UserAuthc> {

    public static final String PROP_EMAIL = "email";
    public static final String PROP_EMAIL_VERIFIED = "emailVerified";
    public static final String PROP_MOBILE_NO = "mobileNO";
    public static final String PROP_MOBILE_VERIFIED = "mobileVerified";
    public static final String PROP_AVATAR = "avatar";
    public static final String PROP_AVATAR_STATUS = "avatarStatus";
    public static final String PROP_REAL_NAME = "realName";
    public static final String PROP_ID_CARD = "idCard";
    public static final String PROP_CARD_VERIFIED = "cardVerified";
    public static final String PROP_EDUCATION = "education";
    public static final String PROP_DIPLOMA = "diploma";
    public static final String PROP_EDU_VALID_CODE = "eduValidCode";
    public static final String PROP_EDU_CREATE_TIME = "eduCreateTime";
    public static final String PROP_EDU_VERIFIED = "eduVerified";
    public static final String PROP_PROFESSION = "profession";
    public static final String PROP_STU_NUMBER = "stuNumber";
    public static final String PROP_UNIV_LOCATION = "univLocation";
    public static final String PROP_UNIV_NAME = "univName";
    public static final String PROP_CAMPUS = "campus";
    public static final String PROP_ENTRANCE_YEAR = "entranceYear";
    public static final String PROP_STU_VERIFIED = "stuVerified";
    public static final String PROP_FACE_VERIFIED = "faceVerified";

    private static final long serialVersionUID = -1186241685636499132L;

    private String userName;
    // 邮箱认证
    private String email;
    private boolean emailVerified;
    // 手机认证
    private String mobileNO;
    private boolean mobileVerified;
    // 照片(视频)认证
    private String avatar; // 上传的真实头像地址d
    private AvatarAuthcStatus avatarStatus; // 认证状态:0还没有认证,1为请求,2返回重新上传,3通过
    // 身份认证
    private String realName;
    private String idCard;
    private boolean cardVerified;
    // 学历认证
    private Dict education;
    private String diploma; // 上传的毕业证图片地址
    private String eduValidCode;
    private DateTime eduCreateTime;
    private boolean eduVerified;
    // 学籍认证
    private String profession; // 专业
    private String stuNumber; // 学号
    private String univLocation; // 学校所在省市
    private String univName; // 院校名
    private String campus; // 校区
    private Integer entranceYear; // 入学年份
    private boolean stuVerified;
    // 脸纹认证
    private boolean faceVerified;

    public UserAuthc() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public void setMobileNO(String mobileNO) {
        this.mobileNO = mobileNO;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public AvatarAuthcStatus getAvatarStatus() {
        return avatarStatus;
    }

    public void setAvatarStatus(AvatarAuthcStatus avatarStatus) {
        this.avatarStatus = avatarStatus;
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

    public Dict getEducation() {
        return education;
    }

    public void setEducation(Dict education) {
        this.education = education;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getEduValidCode() {
        return eduValidCode;
    }

    public void setEduValidCode(String eduValidCode) {
        this.eduValidCode = eduValidCode;
    }

    public DateTime getEduCreateTime() {
        return eduCreateTime;
    }

    public void setEduCreateTime(DateTime eduCreateTime) {
        this.eduCreateTime = eduCreateTime;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getUnivLocation() {
        return univLocation;
    }

    public void setUnivLocation(String univLocation) {
        this.univLocation = univLocation;
    }

    public String getUnivName() {
        return univName;
    }

    public void setUnivName(String univName) {
        this.univName = univName;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public Integer getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(Integer entranceYear) {
        this.entranceYear = entranceYear;
    }

    public boolean isFaceVerified() {
        return faceVerified;
    }

    public void setFaceVerified(boolean faceVerified) {
        this.faceVerified = faceVerified;
    }

    public boolean isStuVerified() {
        return stuVerified;
    }

    public void setStuVerified(boolean stuVerified) {
        this.stuVerified = stuVerified;
    }

    public boolean isEduVerified() {
        return eduVerified;
    }

    public void setEduVerified(boolean eduVerified) {
        this.eduVerified = eduVerified;
    }

    public boolean isCardVerified() {
        return cardVerified;
    }

    public void setCardVerified(boolean cardVerified) {
        this.cardVerified = cardVerified;
    }

    public boolean isMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId())
                .add(PROP_USER_NAME, getUserName())
                .add(PROP_EMAIL, getEmail())
                .add(PROP_EMAIL_VERIFIED, isEmailVerified())
                .add(PROP_MOBILE_NO, getMobileNO())
                .add(PROP_MOBILE_VERIFIED, isMobileVerified())
                .add(PROP_AVATAR, getAvatar())
                .add(PROP_AVATAR_STATUS, getAvatarStatus())
                .add(PROP_REAL_NAME, getRealName())
                .add(PROP_ID_CARD, getIdCard())
                .add(PROP_CARD_VERIFIED, isCardVerified())
                .add(PROP_EDUCATION, getEducation())
                .add(PROP_EDU_VALID_CODE, getEduValidCode())
                .add(PROP_DIPLOMA, getDiploma())
                .add(PROP_EDU_CREATE_TIME, getEduCreateTime())
                .add(PROP_EDU_VERIFIED, isEduVerified())
                .add(PROP_PROFESSION, getProfession())
                .add(PROP_STU_NUMBER, getStuNumber())
                .add(PROP_UNIV_NAME, getUnivName())
                .add(PROP_UNIV_LOCATION, getUnivLocation())
                .add(PROP_CAMPUS, getCampus())
                .add(PROP_ENTRANCE_YEAR, getEntranceYear())
                .add(PROP_STU_VERIFIED, isStuVerified())
                .add(PROP_FACE_VERIFIED, isFaceVerified()).toString();
    }

    @Nonnull
    public static UserAuthc get(Long userId) {
        return UserCmdContext.userAuthcRepository().findOne(userId);
    }

    /**
     * 创建用户认证信息
     *
     * @param userId    用户ID
     * @param userName  用户名
     */
    public static UserAuthc create(Long userId, String userName) {
        UserAuthc userAuthc = new UserAuthc();
        userAuthc.setUserId(userId);
        userAuthc.setUserName(userName);
        DateTime now = DateTime.now();
        userAuthc.setLastModifiedDate(now);
        userAuthc.setCreatedDate(now);
        return userAuthc;
    }

    /**
     * 更新手机认证信息
     *
     * @param mobileNO  手机号码
     * @param isVerify  是否通过验证
     */
    public UserAuthc updateMobile(String mobileNO, Boolean isVerify) {
        setMobileNO(mobileNO);
        setMobileVerified(isVerify);
        return this;
    }

    /**
     * 更新邮箱地址认证信息
     *
     * @param email     邮箱地址
     * @param isVerify  是否通过验证
     */
    public UserAuthc updateEmail(String email, Boolean isVerify) {
        setEmail(email);
        setEmailVerified(isVerify);
        return this;
    }

    /**
     * 更新身份认证信息
     *
     * @param realName  真实姓名
     * @param idCard    身份证号码
     * @param isVerify  是否通过验证
     */
    public UserAuthc updateIdCard(String realName, String idCard, Boolean isVerify) {
        setRealName(realName);
        setIdCard(idCard);
        setCardVerified(isVerify);
        return this;
    }

    /**
     * 提交学历证书唯一验证码
     * <p />
     *  工作人员会在一个工作日内完成认证
     *
     * @param eduValidCode
     */
    public UserAuthc submitEduCode(String eduValidCode) {
        setEduValidCode(eduValidCode);
        setEduCreateTime(DateTime.now());
        setEduVerified(false);
        return this;
    }

    /**
     * 更新学籍认证信息
     *
     * @param location      院校所在省市
     * @param univName      院校名
     * @param campus        校区
     * @param entranceYear  入学年份
     * @param stuNum        学号
     * @param profession    专业
     * @param education     学历
     */
    public UserAuthc updateSchRoll(String location, String univName, String campus,
                                   Integer entranceYear, String stuNum, String profession, Dict education) {
        setUnivLocation(location);
        setUnivName(univName);
        setCampus(campus);
        setEntranceYear(entranceYear);
        setStuNumber(stuNum);
        setProfession(profession);
        setEducation(education);
        setStuVerified(false);
        return this;
    }
}
