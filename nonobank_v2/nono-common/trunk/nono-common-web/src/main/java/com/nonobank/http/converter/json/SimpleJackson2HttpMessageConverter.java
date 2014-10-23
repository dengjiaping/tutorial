/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) SimpleJackson2HttpMessageConverter.java 2014-09-26 15:43
 */

package com.nonobank.http.converter.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.Map;

/**
 * Extends jackson2 {@code ObjectMapper} settings.
 * Does not contain {@code null} property, empty property({@code Map} {@code Collection}) etc.
 * Auto find and register modules (joda, guava, jsr310 ...).
 *
 * @author fuchun
 * @version $Id: SimpleJackson2HttpMessageConverter.java 31 2014-09-26 07:55:11Z fuchun $
 * @since 2.0
 */
public class SimpleJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public SimpleJackson2HttpMessageConverter() {
        super();
        getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        getObjectMapper().findAndRegisterModules();
    }

    public void setSerializationFeatures(Map<SerializationFeature, Boolean> features) {
        if (features == null || features.isEmpty()) {
            return;
        }
        for (Map.Entry<SerializationFeature, Boolean> entry : features.entrySet()) {
            getObjectMapper().configure(entry.getKey(), entry.getValue());
        }
    }

    public void setDeserializationFeatures(Map<DeserializationFeature, Boolean> features) {
        if (features == null || features.isEmpty()) {
            return;
        }
        for (Map.Entry<DeserializationFeature, Boolean> entry : features.entrySet()) {
            getObjectMapper().configure(entry.getKey(), entry.getValue());
        }
    }
}
