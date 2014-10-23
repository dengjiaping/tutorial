/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) SimpleFormHttpMessageConverter.java 2014-09-26 15:49
 */

package com.nonobank.http.converter;

import com.nonobank.http.converter.json.SimpleJackson2HttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.util.ClassUtils;

/**
 * 此类与{@code AllEncompassingFormHttpMessageConverter} 相似，不同的是使用
 * {@link com.nonobank.http.converter.json.SimpleJackson2HttpMessageConverter} 代替 {@code MappingJackson2HttpMessageConverter}。
 *
 * @author fuchun
 * @version $Id: SimpleFormHttpMessageConverter.java 31 2014-09-26 07:55:11Z fuchun $
 * @since 2.0
 */
public class SimpleFormHttpMessageConverter extends FormHttpMessageConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleFormHttpMessageConverter.class);

    private static final boolean jaxb2Present =
            ClassUtils.isPresent("javax.xml.bind.Binder", SimpleFormHttpMessageConverter.class.getClassLoader());

    private static final boolean jackson2Present =
            ClassUtils.isPresent("com.fasterxml.jackson.databind.ObjectMapper",
                    SimpleFormHttpMessageConverter.class.getClassLoader()) &&
                    ClassUtils.isPresent("com.fasterxml.jackson.core.JsonGenerator",
                            SimpleFormHttpMessageConverter.class.getClassLoader());

    /**
     * Default constructor.
     */
    public SimpleFormHttpMessageConverter() {
        addPartConverter(new SourceHttpMessageConverter<>());
        if (jaxb2Present) {
            LOGGER.trace("Add Jaxb2RootElementHttpMessageConverter to FormHttpMessageConverter");
            addPartConverter(new Jaxb2RootElementHttpMessageConverter());
        }
        if (jackson2Present) {
            LOGGER.trace("Add SimpleJackson2HttpMessageConverter to FormHttpMessageConverter");
            addPartConverter(new SimpleJackson2HttpMessageConverter());
        }
    }
}
