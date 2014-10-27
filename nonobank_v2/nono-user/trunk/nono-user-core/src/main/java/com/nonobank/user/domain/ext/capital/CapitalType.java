/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) CapitalType.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext.capital;

import com.google.common.base.MoreObjects;
import com.nonobank.common.base.EnumValue;

/**
 * @author Yichuan
 * @version $Id: CapitalType.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public enum CapitalType implements EnumValue<String> {

    /**
     * 等额本息
     */
    ACPI(1, "等额本息", "acpi"),

    /**
     * 等本等息
     */
    ACAI(2, "等本等息", "acai");

    final short code;
    final String name;
    final String alias;

    private CapitalType(int code, String name, String alias) {
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
    public String toString() {
         return MoreObjects.toStringHelper(this)
                .add("code", getCode())
                .add("name", getName())
                .add("alias", getAlias()).toString();
    }

    @Override
    public String getValue() {
        return alias;
    }

    /**
     * 返回指定标识的 {@link CapitalType} 枚举对象，如果标识为 {@code null}，
     * 或者不存在，则返回 {@link null}。
     *
     * @param code 标识。
     * @param <N>  标识的类型。
     * @return 返回指定标识的 {@link CapitalType} 枚举对象。
     */
    public static <N extends Number> CapitalType of(N code) {
        if (code == null) {
            return null;
        }
        for (CapitalType e : values()) {
            if (e.code == code.shortValue()) {
                return e;
            }
        }
        return null;
    }

    /**
     * 返回指定字符串标识（名称）的枚举对象。
     * 如果 {@code sign == null || sign.length() == 0}，返回 {@link null}。
     *
     * @param sign 字符串标识（名称）。
     * @return 返回指定字符串标识（名称）的枚举对象。
     */
    public static CapitalType of(String sign) {
        if (sign == null || sign.length() == 0) {
            return null;
        }
        for (CapitalType e : values()) {
            if (sign.equals(e.name) || sign.equals(e.alias)) {
                return e;
            }
        }
        return null;
    }
}
