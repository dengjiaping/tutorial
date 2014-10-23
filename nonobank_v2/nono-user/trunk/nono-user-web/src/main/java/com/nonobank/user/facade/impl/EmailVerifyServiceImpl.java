/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) EmailVerifyServiceImpl.java 2014-10-23 17:16
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.repository.message.EmailVerifySourceRepository;
import com.nonobank.user.facade.EmailVerifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Yichuan
 * @version $Id: EmailVerifyServiceImpl.java 267 2014-10-23 09:18:45Z yichuan $
 * @since 2.0
 */
@Service("emailVerifyService")
public class EmailVerifyServiceImpl implements EmailVerifyService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private EmailVerifySourceRepository emailVerifySourceRepository;

    // TODO
}
