/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EmailContext.java 2014-10-27 16:41
 */

package com.nonobank.user.service.email;

/**
 * @author Yichuan
 * @version $Id: EmailContext.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public final class EmailContext {

    private EmailVerifyStrategy verifyStrategy;

    public EmailContext(EmailVerifyStrategy verifyStrategy) {
        this.verifyStrategy = verifyStrategy;
    }

    public static EmailContext context(EmailVerifyStrategy verifyStrategy) {
        return new EmailContext(verifyStrategy);
    }

    public void operate(Object object){
        this.verifyStrategy.operate(object);
    }
}
