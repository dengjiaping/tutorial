/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JodaLocalDateConverter.java 2014-10-08 12:43
 */

package com.nonobank.data.convert.beanutils;

import org.joda.time.LocalDate;

/**
 * @author fuchun
 * @version $Id: JodaLocalDateConverter.java 45 2014-10-08 06:46:55Z fuchun $
 * @since 2.0
 */
public class JodaLocalDateConverter extends JodaDateTimeConverter {

    public JodaLocalDateConverter() {
        super();
    }

    public JodaLocalDateConverter(LocalDate defaultValue) {
        super(defaultValue);
    }

    @Override
    protected Class<?> getDefaultType() {
        return LocalDate.class;
    }
}