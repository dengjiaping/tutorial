/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserStatus.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.core;

import com.nonobank.common.base.EnumValue;

/**
 * 用户帐号状态枚举。
 *
 * @author fuchun
 * @version $Id: UserStatus.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public enum UserStatus implements EnumValue<Short> {

    /**
     * 未激活。
     */
    NOT_ACTIVE(0),

    /**
     * 正常用户。
     */
    NORMAL(1),

    /**
     * 被锁定。
     */
    LOCKED(2);

    final short code;

    UserStatus(int code) {
        this.code = (short) code;
    }

    public short getCode() {
        return code;
    }

    @Override
    public Short getValue() {
        return code;
    }

    public static <T extends Number> UserStatus of(T code) {
        return of(code, null);
    }

    public static <T extends Number> UserStatus of(T code, UserStatus def) {
        if (code == null || code.intValue() < 0) {
            return def;
        }
        for (UserStatus status : values()) {
            if (status.getCode() == code.shortValue()) {
                return status;
            }
        }
        return def;
    }
}
