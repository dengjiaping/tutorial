/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ResetPassword.java 2014-10-27 16:41
 */

package com.nonobank.user.service.email;

import com.nonobank.user.domain.core.UserAccount;
import com.nonobank.user.domain.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 重置用户密码的策略
 *
 * @author Yichuan
 * @version $Id: ResetPassword.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class ResetPassword implements EmailVerifyStrategy {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static final ResetPassword INSTANCE = new ResetPassword();

    public static ResetPassword getContext() {
        return INSTANCE;
    }

    @Override
    public void operate(Object object) {
        logger.info("reset password business.");
        UserAccount userAccount = UserAccount.getIfPresent((Long) object);
        if (userAccount == null)
            throw new UserNotFoundException("");
        // TODO
    }
}
