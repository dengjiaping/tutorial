/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserAccountDTO.java 2014-10-23 14:04
 */

package com.nonobank.user.facade.dto.core;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id: UserAccountDTO.java 262 2014-10-23 08:10:39Z yichuan $
 * @since 2.0
 */
public class UserAccountDTO implements Serializable {

    private static final long serialVersionUID = -4367086970060818219L;

    private final Long userId;
    private final String userName;
    private final String hashedKey;
    private final String avatar;
    private final String mobileNO;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public UserAccountDTO(Long userId, String userName, String hashedKey, String avatar,
                          String mobileNO, DateTime lastModifiedDate, DateTime createdDate) {
        this.userId = userId;
        this.userName = userName;
        this.hashedKey = hashedKey;
        this.avatar = avatar;
        this.mobileNO = mobileNO;
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

    public String getAvatar() {
        return avatar;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("UserAccountDTO{userId=%d, userName='%s', hashedKey='%s', avatar='%s', " +
                        "mobileNO='%s', lastModifiedDate='%s', createdDate='%s'}",
                userId, userName, hashedKey, avatar, mobileNO, lastModifiedDate, createdDate);
    }
}
