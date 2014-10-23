/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JodaLocalTimeConverter.java 2014-10-08 12:45
 */

package com.nonobank.data.convert.beanutils;

import org.joda.time.LocalTime;

/**
 * @author fuchun
 * @version $Id: JodaLocalTimeConverter.java 45 2014-10-08 06:46:55Z fuchun $
 * @since 2.0
 */
public class JodaLocalTimeConverter extends JodaDateTimeConverter {

    public JodaLocalTimeConverter() {
        super();
    }

    public JodaLocalTimeConverter(LocalTime defaultValue) {
        super(defaultValue);
    }

    @Override
    protected Class<?> getDefaultType() {
        return LocalTime.class;
    }
}