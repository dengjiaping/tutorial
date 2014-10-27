/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) BusinessType.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.message;

import com.nonobank.common.base.EnumValue;

/**
 * @author Yichuan
 * @version $Id: BusinessType.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public enum BusinessType implements EnumValue<Integer> {

    /**
     * 邮箱地址激活
     */
    EMAIL_ACTIVATE(1, "邮箱激活", "Activate Email"),

    /**
     * 重置密码
     */
    RESET_PASSWORD(2, "重置密码", "Reset Password");

    private final short code;
    private final String name;
    private final String alias;

    BusinessType(int code, String name, String alias) {
        this.code = (short)code;
        this.name = name;
        this.alias = alias;
    }

    public short getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public Integer getValue() {
        return (int) code;
    }
}
