/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserAccountServiceImpl.java 2014-10-23 14:35
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.repository.core.UserAccountRepository;
import com.nonobank.user.facade.UserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yichuan
 * @version $Id: UserAccountServiceImpl.java 265 2014-10-23 08:55:24Z yichuan $
 * @since 2.0
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserAccountRepository userAccountRepository;
}