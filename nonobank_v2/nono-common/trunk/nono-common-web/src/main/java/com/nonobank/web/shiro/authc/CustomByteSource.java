/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CustomByteSource.java 2014-09-26 16:07
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
 * @version $Id: CustomByteSource.java 32 2014-09-26 08:16:39Z fuchun $
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