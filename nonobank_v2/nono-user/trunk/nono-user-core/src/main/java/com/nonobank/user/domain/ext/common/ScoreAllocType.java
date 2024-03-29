/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ScoreAllocType.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext.common;

import com.google.common.base.MoreObjects;
import com.nonobank.common.base.EnumValue;

/**
 * 积分配置分类枚举
 *
 * @author Yichuan
 * @version $Id: ScoreAllocType.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public enum ScoreAllocType implements EnumValue<Integer> {

    /**
     * 用户属性
     */
    USER_PROP(1, "用户属性", "user properties"),

    /**
     * 活动
     */
    ACTIVITY(2, "活动", "activity");

    final short code;
    final String name;
    final String alias;

    private ScoreAllocType(int code, String name, String alias) {
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
    public Integer getValue() {
        return (int)code;
    }

    /**
     * 返回指定标识的 {@link ScoreAllocType} 枚举对象，如果标识为 {@code null}，
     * 或者不存在，则返回 {@link null}。
     *
     * @param code 标识。
     * @param <N>  标识的类型。
     * @return 返回指定标识的 {@link ScoreAllocType} 枚举对象。
     */
    public static <N extends Number> ScoreAllocType of(N code) {
        if (code == null) {
            return null;
        }
        for (ScoreAllocType e : values()) {
            if (e.code == code.shortValue()) {
                return e;
            }
        }
        return null;
    }
}
