/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JodaLocalTimeConverter.java 2014-10-27 16:48
 */

package com.nonobank.data.convert.beanutils;

import org.joda.time.LocalTime;

/**
 * @author fuchun
 * @version $Id: JodaLocalTimeConverter.java 291 2014-10-27 08:49:07Z fuchun $
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
