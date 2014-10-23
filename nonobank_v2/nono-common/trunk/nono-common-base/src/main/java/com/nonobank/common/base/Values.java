/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) Values.java 2014-10-16 13:17
 */

package com.nonobank.common.base;

import com.google.common.collect.ImmutableList;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.IllegalFormatFlagsException;
import java.util.List;
import java.util.Objects;

/**
 * 此接口只有一个字符串值，并提供基本类型的转换方式。
 * <p />
 * 此接口中的字符串值的长度是有限制的：{@code 0 ~ 250}。
 *
 * @author fuchun
 * @version $Id: Values.java 185 2014-10-16 06:15:41Z fuchun $
 * @since 2.0
 */
public interface Values {

    List<String> BOOL_TRUE_SIGN = ImmutableList.of("true", "1", "yes", "on");
    List<String> BOOL_FALSE_SIGN = ImmutableList.of("false", "0", "no", "off");

    String getValue();

    default Long longValue() {
        return getValue() != null ? Long.valueOf(getValue()) : null;
    }

    default Integer toInt() {
        return getValue() != null ? Integer.parseInt(getValue()) : null;
    }

    default Short toShort() {
        return getValue() != null ? Short.parseShort(getValue()) : null;
    }

    default Byte toByte() {
        return getValue() != null ? Byte.parseByte(getValue()) : null;
    }

    default BigDecimal toDecimal() {
        return getValue() != null ? new BigDecimal(getValue()) : null;
    }

    default BigInteger toBigInt() {
        return getValue() != null ? new BigInteger(getValue()) : null;
    }

    default Boolean toBool() {
        if (getValue() == null) {
            return null;
        }
        final String v = getValue().toLowerCase();
        if (BOOL_TRUE_SIGN.contains(v)) {
            return Boolean.TRUE;
        } else if (BOOL_FALSE_SIGN.contains(v)) {
            return Boolean.FALSE;
        }
        throw new IllegalFormatFlagsException(getValue());
    }

    default DateTime toDateTime(String pattern) {
        return toDateTime(DateTimeFormat.forPattern(pattern));
    }

    default DateTime toDateTime(DateTimeFormatter formatter) {
        if (getValue() == null) {
            return null;
        }
        return DateTime.parse(getValue(), formatter);
    }

    default <E extends Enum<E>> E toEnum(Class<E> enumClass) {
        Objects.requireNonNull(enumClass, "enumClass");
        if (getValue() == null) {
            return null;
        }
        return Enum.valueOf(enumClass, getValue());
    }
}