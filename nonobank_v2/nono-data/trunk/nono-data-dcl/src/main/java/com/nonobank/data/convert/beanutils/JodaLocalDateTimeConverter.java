/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JodaLocalDateTimeConverter.java 2014-10-27 16:48
 */

package com.nonobank.data.convert.beanutils;

import org.joda.time.LocalDateTime;

/**
 * @author fuchun
 * @version $Id: JodaLocalDateTimeConverter.java 291 2014-10-27 08:49:07Z fuchun $
 * @since 2.0
 */
public class JodaLocalDateTimeConverter extends JodaDateTimeConverter {

    protected JodaLocalDateTimeConverter() {
        super();
    }

    protected JodaLocalDateTimeConverter(Object defaultValue) {
        super(defaultValue);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected Class<?> getDefaultType() {
        return LocalDateTime.class;
    }
}
