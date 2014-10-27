/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) CustomByteSource.java 2014-10-27 16:47
 */

package com.nonobank.web.shiro.authc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.shiro.util.SimpleByteSource;

/**
 * The custom implementation for {@code ByteSource}.
 *
 * @author Fuchun
 * @version $Id: CustomByteSource.java 290 2014-10-27 08:48:18Z fuchun $
 * @since 2.0
 */
public class CustomByteSource extends SimpleByteSource {

    public static CustomByteSource of(String source) {
        return new CustomByteSource(source, null);
    }

    @JsonCreator
    @SuppressWarnings("unused")
    public CustomByteSource(
            @JsonProperty("bytes") String string,
            @JsonProperty("empty") Boolean empty) {
        super(string);
    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return super.isEmpty();
    }
}