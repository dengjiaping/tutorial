/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) Education.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.dict;

import com.google.common.base.MoreObjects;
import com.nonobank.common.base.EnumValue;

/**
 * @author Yichuan
 * @version $Id: Education.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public enum Education implements EnumValue<Number> {

    UNKNOWN(-1, "未知", null),

    /**
     * 高中以下
     */
    BASIS(1, "高中以下", "basis"),

    /**
     * 中专及高中
     */
    MIDDLE_SCHOOL(2, "中专及高中", "middle school"),

    /**
     * 大专
     */
    JUNIOR_COLLEGE(3, "大专", "junior college"),

    /**
     * 本科(学士)
     */
    BACHELOR(4, "本科", "bachelor"),

    /**
     * 硕士研究生
     */
    MASTER(5, "硕士研究生", "master"),

    /**
     * 博士研究生
     */
    DOCTOR(6, "博士研究生", "doctor");

    final short code;
    final String name;
    final String ename;

    private Education(int code, String name, String ename) {
        this.code = (short)code;
        this.name = name;
        this.ename = ename;
    }

    public short getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getEname() {
        return ename;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", getCode())
                .add("name", getName())
                .add("ename", getEname()).toString();
    }

    @Override
    public Number getValue() {
        return (int)code;
    }

    /**
     * 返回指定标识的 {@link Education} 枚举对象，如果标识为 {@code null}，
     * 或者不存在，则返回 {@link null}。
     *
     * @param code 标识。
     * @param <N>  标识的类型。
     * @return 返回指定标识的 {@link Education} 枚举对象。
     */
    public static <N extends Number> Education of(N code) {
        if (code == null) {
            return UNKNOWN;
        }
        for (Education e : values()) {
            if (e.code == code.shortValue()) {
                return e;
            }
        }
        return UNKNOWN;
    }

    /**
     * 返回指定字符串标识（名称、英文名称）的枚举对象。
     * 如果 {@code sign == null || sign.length() == 0}，返回 {@link null}。
     *
     * @param sign 字符串标识（名称、英文名称）。
     * @return 返回指定字符串标识（名称、英文名称）的枚举对象。
     */
    public static Education of(String sign) {
        if (sign == null || sign.length() == 0) {
            return UNKNOWN;
        }
        for (Education e : values()) {
            if (sign.equals(e.name) || sign.equals(e.ename)) {
                return e;
            }
        }
        return UNKNOWN;
    }
}
