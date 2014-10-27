/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) StringToDateTimeConverter.java 2014-10-27 16:48
 */

package com.nonobank.data.convert.spring;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.core.convert.converter.Converter;

/**
 * 转换字符串{@code String} 为{@code DateTime} 类型。
 *
 * @author Fuchun
 * @since 2.0
 * @version $Id: StringToDateTimeConverter.java 291 2014-10-27 08:49:07Z fuchun $
 */
public enum  StringToDateTimeConverter implements Converter<String, DateTime> {
    INSTANCE;

    /**
     * 返回{@code StringToDateTimeConverter} 的实例。
     */
    public static StringToDateTimeConverter getInstance() {
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
    public DateTime convert(String source) {
        String src;
        if (source == null || (src = source.trim()).length() == 0) {
            return null;
        }
        switch (src.length()) {
            case 19: // standard yyyy-MM-dd HH:mm:ss
                return DateTime.parse(src, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
            case 16:
                return DateTime.parse(src, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm"));
            case 10: // just date yyyy-MM-dd
                return DateTime.parse(src, DateTimeFormat.forPattern("yyyy-MM-dd"));
            default:
                return DateTime.parse(src, ISODateTimeFormat.dateTime());
        }
    }
}