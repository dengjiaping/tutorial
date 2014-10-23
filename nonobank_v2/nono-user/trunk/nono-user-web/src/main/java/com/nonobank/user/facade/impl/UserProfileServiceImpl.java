/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserProfileServiceImpl.java 2014-10-23 15:17
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.repository.core.UserProfileRepository;
import com.nonobank.user.facade.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yichuan
 * @version $Id: UserProfileServiceImpl.java 265 2014-10-23 08:55:24Z yichuan $
 * @since 2.0
 */
@Service("userProfileService")
public class UserProfileServiceImpl implements UserProfileService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserProfileRepository userProfileRepository;
    // TODO
}
