/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) TimestampToDateTimeConverter.java 2014-09-29 14:20
 */

package com.nonobank.data.convert.spring;

import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

/**
 * The {@link java.sql.Timestamp} convert to {@link org.joda.time.DateTime} function interface implementation.
 *
 * @author Fuchun
 * @since 2.0
 * @version $Id: TimestampToDateTimeConverter.java 43 2014-09-29 08:33:44Z fuchun $
 */
public enum TimestampToDateTimeConverter implements Converter<Timestamp, DateTime> {

    INSTANCE;

    public static TimestampToDateTimeConverter getInstance() {
        return INSTANCE;
    }

    @Override
    public DateTime convert(Timestamp source) {
        return source == null ? null : new DateTime(source);
    }
}