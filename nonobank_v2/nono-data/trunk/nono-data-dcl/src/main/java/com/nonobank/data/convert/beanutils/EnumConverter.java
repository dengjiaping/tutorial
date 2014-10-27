/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EnumConverter.java 2014-10-27 16:48
 */

package com.nonobank.data.convert.beanutils;

import com.nonobank.common.base.EnumValue;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fuchun
 * @version $Id: EnumConverter.java 291 2014-10-27 08:49:07Z fuchun $
 * @since 2.0
 */
public class EnumConverter<E extends Enum<E>> implements Converter {

    private transient Logger logger;
    private final E defaultValue;
    private final E[] enums;

    public EnumConverter(Class<E> enumClass, E defaultValue) {
        this.defaultValue = defaultValue;
        this.enums = enumClass.getEnumConstants();
    }

    Logger getLogger() {
        if (logger == null) {
            logger = LoggerFactory.getLogger(getClass());
        }
        return logger;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T convert(Class<T> type, Object value) {
        if (value == null) {
            return defaultValue != null ? type.cast(defaultValue) : null;
        }
        if (value instanceof Number) {
            Number code = (Number) value;

            if (isEnumValue(type)) {
                for (E e : enums) {
                    if (((EnumValue<Number>) e).getValue().intValue() == code.intValue()) {
                        return type.cast(e);
                    }
                }
            } else {
                for (E e : enums) {
                    if (e.ordinal() == code.intValue()) {
                        return type.cast(e);
                    }
                }
            }
        } else if (value instanceof String) {
            String name = (String) value;

            for (E e : enums) {
                if (e.name().equals(name)) {
                    return type.cast(e);
                }
            }
        }
        String msg = String.format("%s cannot handle conversion to '%s'",
                getClass().getSimpleName(), type);
        if (getLogger().isWarnEnabled()) {

            getLogger().warn("    {}", msg);
        }

        throw new ConversionException(msg);
    }

    private boolean isEnumValue(Class<?> type) {
        Class<?>[] interfaces = type.getInterfaces();
        if (interfaces == null || interfaces.length == 0) {
            return false;
        }
        for (Class<?> i : interfaces) {
            if (EnumValue.class.equals(i)) {
                return true;
            }
        }
        return false;
    }
}
