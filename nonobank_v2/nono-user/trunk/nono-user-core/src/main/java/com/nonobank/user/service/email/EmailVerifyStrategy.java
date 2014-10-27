/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EmailVerifyStrategy.java 2014-10-27 16:41
 */

package com.nonobank.user.service.email;

/**
 * 邮件相关业务的策略
 *
 * @author Yichuan
 * @version $Id: EmailVerifyStrategy.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface EmailVerifyStrategy {

    public void operate(Object object);
}
