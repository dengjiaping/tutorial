/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EntityNotFoundException.java 2014-10-27 16:48
 */

package com.nonobank.data.domain;

/**
 * The entity not found Exception.
 *
 * @author Fuchun
 * @since 2.0
 * @version $Id: EntityNotFoundException.java 291 2014-10-27 08:49:07Z fuchun $
 */
public class EntityNotFoundException extends EntityException {

    private static final long serialVersionUID = 3155244529192086351L;

    /**
     * Constructs a new entity exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public EntityNotFoundException() {
        super();
    }

    /**
     * Constructs a new entity exception with the specified {@code code}.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param code the exception code.
     */
    public EntityNotFoundException(Integer code) {
        super(code);
    }

    /**
     * Constructs a new entity exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public EntityNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new entity exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param code    the exception code.
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public EntityNotFoundException(Integer code, String message) {
        super(code, message);
    }
}
