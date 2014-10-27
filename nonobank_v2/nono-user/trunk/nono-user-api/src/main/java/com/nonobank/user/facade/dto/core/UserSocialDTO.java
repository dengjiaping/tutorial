/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserSocialDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.core;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id: UserSocialDTO.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class UserSocialDTO implements Serializable {

    private static final long serialVersionUID = -7726089883594042861L;

    private final Long id;
    private final Long userId;
    private final String userName;
    private final String openId;
    private final String socialSource;
    private final String authToken;
    private final Long period;
    private final DateTime tokenUpdateTime;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public UserSocialDTO(Long id, Long userId, String userName, String openId, String socialSource,
                         String authToken, Long period, DateTime tokenUpdateTime,
                         DateTime lastModifiedDate, DateTime createdDate) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.openId = openId;
        this.socialSource = socialSource;
        this.authToken = authToken;
        this.period = period;
        this.tokenUpdateTime = tokenUpdateTime;
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

    public String getOpenId() {
        return openId;
    }

    public String getSocialSource() {
        return socialSource;
    }

    public String getAuthToken() {
        return authToken;
    }

    public Long getPeriod() {
        return period;
    }

    public DateTime getTokenUpdateTime() {
        return tokenUpdateTime;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("UserSocialDTO{id=%d, userId=%d, userName='%s', openId='%s', socialSource='%s', authToken='%s', period=%d}",
                id, userId, userName, openId, socialSource, authToken, period);
    }
}
