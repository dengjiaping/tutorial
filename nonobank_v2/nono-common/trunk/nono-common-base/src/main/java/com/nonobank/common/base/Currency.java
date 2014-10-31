/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) Currency.java 2014-10-30 11:24
 */

package com.nonobank.common.base;

/**
 * 流通货币种类
 *
 * @author Yichuan
 * @version $Id: Currency.java 309 2014-10-30 03:35:51Z yichuan $
 * @since 2.0
 */
public enum Currency implements EnumValue<Integer> {

    /**
     * 现金
     */
    CASH(1, "现金", "Cash"),

    /**
     * 诺币
     */
    NONOBANK(2, "诺币", "Nonobank"),

    /**
     * 积分
     */
    SCORE(3, "积分", "Score");

    private final short code;
    private final String name;
    private final String alias;

    private Currency(int code, String name, String alias) {
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

    public static <N extends Number> Currency of(N code) {
        if (code == null) return null;
        for (Currency c: values()) {
            if (c.code == code.shortValue())
                return c;
        }
        return null;
    }
}