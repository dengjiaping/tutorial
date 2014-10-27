/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EmailVerifyServiceImpl.java 2014-10-27 16:41
 */

package com.nonobank.user.service.impl;

import com.nonobank.user.domain.exception.UserNotFoundException;
import com.nonobank.user.domain.message.BusinessType;
import com.nonobank.user.domain.message.EmailVerifySource;
import com.nonobank.user.domain.repository.message.EmailVerifySourceRepository;
import com.nonobank.user.service.EmailVerifyService;
import com.nonobank.user.service.email.ActivateEmail;
import com.nonobank.user.service.email.EmailContext;
import com.nonobank.user.service.email.ResetPassword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import javax.annotation.Resource;

import static com.nonobank.user.domain.message.BusinessType.EMAIL_ACTIVATE;
import static com.nonobank.user.domain.message.BusinessType.RESET_PASSWORD;


/**
 * @author Yichuan
 * @version $Id: EmailVerifyServiceImpl.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Service("emailVerifyService")
@Transactional(readOnly = true)
public class EmailVerifyServiceImpl implements EmailVerifyService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private EmailVerifySourceRepository emailVerifySourceRepository;

    @Nonnull
    @Override
    @Transactional
    public Boolean verifyEmail(String token) {
        EmailVerifySource verifySource = emailVerifySourceRepository.findByToken(token);
        if (verifySource == null) {
            throw new UserNotFoundException("");
        }
        verifySource.verify();
        // 根据业务类型做相应的业务选择
        Long userId = verifySource.getUserId();
        BusinessType type = verifySource.getType();
        if (type.equals(EMAIL_ACTIVATE)) {
            EmailContext.context(ActivateEmail.INSTANCE).operate(userId);
        } else if (type.equals(RESET_PASSWORD)) {
            EmailContext.context(ResetPassword.INSTANCE).operate(userId);
        }
        // TODO
        emailVerifySourceRepository.save(verifySource);
        return true;
    }
}
