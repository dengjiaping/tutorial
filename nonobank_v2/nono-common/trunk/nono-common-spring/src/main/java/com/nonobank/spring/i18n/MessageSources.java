/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) MessageSources.java 2014-10-29 16:29
 */

package com.nonobank.spring.i18n;

import java.io.Serializable;

/**
 * {@code CustomMessageSource} simple factory.
 *
 * @author fuchun
 * @version $Id: MessageSources.java 301 2014-10-30 00:42:26Z fuchun $
 * @since 2.0
 */
public final class MessageSources implements Serializable {

    private static final MessageSources INSTANCE = new MessageSources();

    private static final long serialVersionUID = 2712150473180538656L;

    public static CustomMessageSource getMessageSource() {
        return INSTANCE.messageSource;
    }

    private CustomMessageSource messageSource;

    private MessageSources() {}

    public static MessageSources getInstance() {
        return INSTANCE;
    }

    public void setMessageSource(CustomMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}