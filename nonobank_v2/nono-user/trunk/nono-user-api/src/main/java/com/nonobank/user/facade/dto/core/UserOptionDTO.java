/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserOptionDTO.java 2014-10-23 16:11
 */

package com.nonobank.user.facade.dto.core;

import java.io.Serializable;

/**
 * @author Yichuan
 * @version $Id: UserOptionDTO.java 263 2014-10-23 08:24:59Z yichuan $
 * @since 2.0
 */
public class UserOptionDTO implements Serializable {

    private static final long serialVersionUID = -4359555979312485343L;

    private final Long id;
    private final Long userId;
    private final String key;
    private final String value;
    private final String bigValue;
    private final Boolean isBig;

    public UserOptionDTO(Long id, Long userId, String key,
                         String value, String bigValue, Boolean isBig) {
        this.id = id;
        this.userId = userId;
        this.key = key;
        this.value = value;
        this.bigValue = bigValue;
        this.isBig = isBig;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getBigValue() {
        return bigValue;
    }

    public Boolean getIsBig() {
        return isBig;
    }

    @Override
    public String toString() {
        return String.format("UserOptionDTO{id=%d, userId=%d, key='%s', value='%s', bigValue='%s', isBig='%s'}",
                id, userId, key, value, bigValue, isBig);
    }
}