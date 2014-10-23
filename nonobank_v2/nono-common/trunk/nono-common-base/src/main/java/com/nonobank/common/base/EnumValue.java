/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) EnumValue.java 2014-09-24 15:40
 */

package com.nonobank.common.base;

/**
 * Assign enum value to enum name mapping only.
 *
 * @author Fuchun
 * @since 2.0
 * @version $Id: EnumValue.java 22 2014-09-24 07:45:00Z fuchun $
 */
public interface EnumValue<V> {

    /**
     * Returns this enum wrapper object value.
     */
    public V getValue();
}