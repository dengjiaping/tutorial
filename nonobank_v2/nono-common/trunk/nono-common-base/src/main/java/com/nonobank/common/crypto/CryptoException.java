/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CryptoException.java 2014-09-24 15:40
 */

package com.nonobank.common.crypto;

/**
 * The crypto exception extension of the runtime exception.
 *
 * @author fuchun
 * @version $Id: CryptoException.java 22 2014-09-24 07:45:00Z fuchun $
 * @since 2.0
 */
public class CryptoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CryptoException() {
    }

    public CryptoException(String message) {
        super(message);
    }

    public CryptoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptoException(Throwable cause) {
        super(cause);
    }

    public CryptoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
