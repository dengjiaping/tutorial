/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EnumValue.java 2014-10-27 16:47
 */

package com.nonobank.common.base;

/**
 * Assign enum value to enum name mapping only.
 *
 * @author Fuchun
 * @since 2.0
 * @version $Id: EnumValue.java 290 2014-10-27 08:48:18Z fuchun $
 */
public interface EnumValue<V> {

    /**
     * Returns this enum wrapper object value.
     */
    public V getValue();
}