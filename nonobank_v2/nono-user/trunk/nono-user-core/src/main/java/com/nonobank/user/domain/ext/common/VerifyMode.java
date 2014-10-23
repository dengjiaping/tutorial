/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) VerifyMode.java 2014-10-16 14:42
 */

package com.nonobank.user.domain.ext.common;

import com.nonobank.common.base.EnumValue;

/**
 * 验证模式枚举
 *
 * @author Yichuan
 * @version $Id: VerifyMode.java 188 2014-10-16 07:00:31Z yichuan $
 * @since 2.0
 */
public enum VerifyMode implements EnumValue<Integer> {

    /**
     * 无需验证
     */
    NO(0, "无验证", "no"),

    /**
     * 整数
     */
    INTEGER(1, "整数", "integer"),

    /**
     * 浮点数
     */
    FLOAT(2, "浮点数", "float"),

    /**
     * 数字序列
     */
    NUM_SEQUENCE(3, "数字序列", "number sequence"),

    /**
     * 座机号码
     */
    PHONE_NUM(4, "座机号码", "telephone number"),

    /**
     * 手机号码
     */
    MOBILE_NUM(5, "手机号码", "mobile number"),

    /**
     * 身份证号码
     */
    ID_CARD_NUM(6, "身份证号码", "id card number"),

    /**
     * 邮箱
     */
    EMAIL(7, "邮箱", "email address"),

    /**
     * 网址
     */
    WEBSITE(8, "网址", "website"),

    /**
     * 自定义
     */
    CUSTOM(9, "自定义", "custom");

    final short code;
    final String name;
    final String alias;

    private VerifyMode(int code, String name, String alias) {
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
        return super.toString();
    }

    @Override
    public Integer getValue() {
        return (int)code;
    }

    /**
     * 返回指定标识的 {@link VerifyMode} 枚举对象，如果标识为 {@code null}，
     * 或者不存在，则返回 {@link null}。
     *
     * @param code 标识。
     * @param <N>  标识的类型。
     * @return 返回指定标识的 {@link VerifyMode} 枚举对象。
     */
    public static <N extends Number> VerifyMode of(N code) {
        if (code == null) {
            return null;
        }
        for (VerifyMode e : values()) {
            if (e.code == code.shortValue()) {
                return e;
            }
        }
        return null;
    }
}
