/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserSocial.java 2014-10-09 15:16
 */

package com.nonobank.user.domain.core;

import com.google.common.base.MoreObjects;
import com.nonobank.data.domain.AbstractRecording;
import org.joda.time.DateTime;

/**
 * 第三方平台用户来源信息实体。
 *
 * @author fuchun
 * @version $Id: UserSocial.java 114 2014-10-13 01:51:44Z fuchun $
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
