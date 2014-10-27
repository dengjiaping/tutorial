/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EmailVerifyService.java 2014-10-27 16:41
 */

package com.nonobank.user.service;

import javax.annotation.Nonnull;

/**
 * @author Yichuan
 * @version $Id: EmailVerifyService.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface EmailVerifyService {

    /**
     * 邮件链接验证
     *
     * @param token 链接token
     */
    @Nonnull
    public Boolean verifyEmail(String token);
}