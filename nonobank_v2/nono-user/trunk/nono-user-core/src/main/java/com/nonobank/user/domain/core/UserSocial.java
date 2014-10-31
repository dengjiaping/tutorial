/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserSocial.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.core;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;
import com.nonobank.user.domain.ctx.UserCmdContext;
import org.joda.time.DateTime;

import javax.annotation.Nonnull;

/**
 * 第三方平台用户来源信息实体。
 *
 * @author fuchun
 * @version $Id: UserSocial.java 317 2014-10-30 09:20:04Z yichuan $
 * @since 2.0
 */
public class UserSocial extends AbstractRecording<Long, UserSocial> {

    public static final String PROP_OPEN_ID = "openId";
    public static final String PROP_SOCIAL_SOURCE = "socialSource";
    public static final String PROP_AUTH_TOKEN = "authToken";
    public static final String PROP_PERIOD = "period";
    public static final String PROP_TOKEN_UPDATE_TIME = "tokenUpdateTime";

    private static final long serialVersionUID = -2378652570378811758L;

    private Long userId;
    /* 用户名进行冗余 */
    private String userName;
    /** 开放平台的帐号Id（openId）*/
    private String openId;
    private SocialSource socialSource;
    /** 开放平台的token。*/
    private String authToken;
    /** token过期时间（秒）。*/
    private Long period;

    private DateTime tokenUpdateTime;

    public UserSocial() {
        super();
    }

    public UserSocial(Long id) {
        this(id, null);
    }

    public UserSocial(Long id, Long userId) {
        super();
        setId(id);
        this.userId = userId;
    }

    @Nonnull
    public static UserSocial getOfUserId(Long userId, SocialSource socialSource) {
        return UserCmdContext.userSocialRepository().findByUserIdAndAccSource(userId, socialSource);
    }

    @Nonnull
    public static UserSocial getOfOpenId(String openId, SocialSource socialSource) {
        return UserCmdContext.userSocialRepository().findByOpenIdAndAccSource(openId, socialSource);
    }

    public UserSocial(Long userId, String userName, String openId, SocialSource socialSource,
                      String authToken, Long period, DateTime tokenUpdateTime) {
        this.userId = userId;
        this.userName = userName;
        this.openId = openId;
        this.socialSource = socialSource;
        this.authToken = authToken;
        this.period = period;
        this.tokenUpdateTime = tokenUpdateTime;
    }

    public static UserSocial create(Long userId, String userName, String openId, SocialSource socialSource,
                                    String authToken, Long period, DateTime tokenUpdateTime) {
        return new UserSocial(userId, userName, openId, socialSource, authToken, period, tokenUpdateTime);
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public SocialSource getSocialSource() {
        return socialSource;
    }

    public void setSocialSource(SocialSource socialSource) {
        this.socialSource = socialSource;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public DateTime getTokenUpdateTime() {
        return tokenUpdateTime;
    }

    public void setTokenUpdateTime(DateTime tokenUpdateTime) {
        this.tokenUpdateTime = tokenUpdateTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_ID, getId())
                .add(PROP_USER_ID, getUserId())
                .add(PROP_USER_NAME, getUserName())
                .add(PROP_OPEN_ID, getOpenId())
                .add(PROP_SOCIAL_SOURCE, getSocialSource())
                .add(PROP_AUTH_TOKEN, getAuthToken())
                .add(PROP_PERIOD, getPeriod())
                .add(PROP_TOKEN_UPDATE_TIME, getTokenUpdateTime())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate())
                .toString();
    }
}
