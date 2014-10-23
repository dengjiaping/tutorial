/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) LongToDateTimeConverter.java 2014-09-29 14:21
 */

package com.nonobank.data.convert.spring;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

/**
 * 转换长整型{@code Long} 为{@code DateTime} 类型。
 *
 * @author Fuchun
 * @since 2.0
 * @version $Id: LongToDateTimeConverter.java 43 2014-09-29 08:33:44Z fuchun $
 */
public enum LongToDateTimeConverter implements Converter<Long, DateTime> {
    INSTANCE;

    /**
     * Returns a {@code LongToDateTimeConverter} instance.
     */
    public static LongToDateTimeConverter getInstance() {
        return INSTANCE;
    }

    /**
     * Convert the source of type S to target type T.
     *
     * @param source the source object to convert, which must be an instance of S
     * @return the converted object, which must be an instance of T
     * @throws IllegalArgumentException if the source could not be converted to the desired target type
     */
    @Override
    public DateTime convert(Long source) {
        return source != null && source > 0 ? new DateTime(source) : null;
    }
}