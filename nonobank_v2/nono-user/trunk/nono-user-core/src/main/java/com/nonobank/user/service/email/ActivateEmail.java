/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ActivateEmail.java 2014-10-27 16:41
 */

package com.nonobank.user.service.email;

import com.nonobank.user.domain.core.UserProfile;
import com.nonobank.user.domain.ctx.UserCmdContext;
import com.nonobank.user.domain.exception.UserException;
import com.nonobank.user.domain.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 激活邮箱地址的策略
 *
 * @author Yichuan
 * @version $Id: ActivateEmail.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class ActivateEmail implements EmailVerifyStrategy {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static final ActivateEmail INSTANCE = new ActivateEmail();

    public static ActivateEmail getContext() {
        return INSTANCE;
    }

    @Override
    public void operate(Object object) {
        logger.info("邮箱地址激活");
        UserProfile userProfile = UserProfile.get((Long)object);
        if (userProfile == null)
            throw new UserNotFoundException("");
        // 邮箱地址已经验证过
        if (userProfile.isEmailVerified())
            throw new UserException("");
        userProfile.verifyEmail(true);
        UserCmdContext.userProfileRepository().save(userProfile);
    }
}
