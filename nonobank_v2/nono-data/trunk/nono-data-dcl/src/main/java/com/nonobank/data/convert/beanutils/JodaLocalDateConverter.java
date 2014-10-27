/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JodaLocalDateConverter.java 2014-10-27 16:48
 */

package com.nonobank.data.convert.beanutils;

import org.joda.time.LocalDate;

/**
 * @author fuchun
 * @version $Id: JodaLocalDateConverter.java 291 2014-10-27 08:49:07Z fuchun $
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
