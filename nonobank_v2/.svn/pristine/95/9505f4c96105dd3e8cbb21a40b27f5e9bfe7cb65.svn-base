/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserStatus.java 2014-09-29 11:54
 */

package com.nonobank.data.domain;

import com.nonobank.common.base.EnumValue;

/**
 * @author Fuchun
 * @since 2.0
 */
public enum TUserStatus implements EnumValue<Short> {
    LOCKED(-1),
    CREATED(0),
    VALIDATED(1);

    final short status;

    TUserStatus(int status) {
        this.status = (short) status;
    }

    public short getStatus() {
        return status;
    }

    public static <T extends Number> TUserStatus of(T status) {
        if (status == null) {
            return CREATED;
        }
        for (TUserStatus s : values()) {
            if (s.status == status.shortValue()) {
                return s;
            }
        }
        return CREATED;
    }

    @Override
    public Short getValue() {
        return status;
    }
}
