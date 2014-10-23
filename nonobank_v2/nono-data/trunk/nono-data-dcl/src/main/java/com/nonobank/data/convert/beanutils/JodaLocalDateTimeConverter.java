/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JodaLocalDateTimeConverter.java 2014-10-08 12:40
 */

package com.nonobank.data.convert.beanutils;

import org.joda.time.LocalDateTime;

/**
 * @author fuchun
 * @version $Id: JodaLocalDateTimeConverter.java 45 2014-10-08 06:46:55Z fuchun $
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
