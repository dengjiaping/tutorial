/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) AvatarAuthcStatus.java 2014-10-13 10:50
 */

package com.nonobank.user.domain.core;

import com.nonobank.common.base.EnumValue;

/**
 * 照片认证状态枚举
 *
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public enum AvatarAuthcStatus implements EnumValue<Short> {

    /**
     * 未认证
     */
    NOT_AUTHC(0, "未认证"),

    /**
     * 请求认证
     */
    APPLY_AUTHC(1, "请求"),

    /**
     * 返回重新上传
     */
    RETURN(2, "返回重新上传"),

    /**
     * 通过
     */
    PASS(3, "通过");

    final short code;
    final String name;

    private AvatarAuthcStatus(int code, String name) {
        this.code = (short) code;
        this.name = name;
    }

    public short getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Short getValue() {
        return code;
    }

    public static <T extends Number> AvatarAuthcStatus of(T code) {
        if (code == null || code.intValue() < 0) {
            return NOT_AUTHC;
        }
        for (AvatarAuthcStatus status : values()) {
            if (status.getCode() == code.shortValue()) {
                return status;
            }
        }
        return NOT_AUTHC;
    }
}
