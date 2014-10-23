/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) Exist.java 2014-10-10 13:54
 */

package com.nonobank.user.domain.dict;

import com.google.common.base.MoreObjects;
import com.nonobank.common.base.EnumValue;

/**
 * @author Yichuan
 * @version $Id: Exist.java 260 2014-10-23 07:18:22Z yichuan $
 * @since 2.0
 */
public enum Exist implements EnumValue<String> {

    UNKNOWN(-1, "未知", null),

    /**
     * 无
     */
    NO(0, "无", "N"),

    /**
     * 有
     */
    YES(1, "有", "Y");

    final short code;
    final String name;
    final String alias;

    private Exist(int code, String name, String alias) {
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
     * 返回指定标识的 {@link Exist} 枚举对象，如果标识为 {@code null}，
     * 或者不存在，则返回 {@link null}。
     *
     * @param code 标识。
     * @param <N>  标识的类型。
     * @return 返回指定标识的 {@link Exist} 枚举对象。
     */
    public static <N extends Number> Exist of(N code) {
        if (code == null) {
            return null;
        }
        for (Exist e : values()) {
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
    public static Exist of(String sign) {
        if (sign == null || sign.length() == 0) {
            return UNKNOWN;
        }
        for (Exist e : values()) {
            if (sign.equals(e.name) || sign.equals(e.alias)) {
                return e;
            }
        }
        return UNKNOWN;
    }

    /**
     * 返回当前对象布尔值
     */
    public Boolean getBool() {
        if (this.equals(Exist.UNKNOWN))
            return null;
        return this.equals(Exist.YES);
    }
}
