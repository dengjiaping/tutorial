/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserSocialServiceImpl.java 2014-10-23 15:34
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.repository.core.UserSocialRepository;
import com.nonobank.user.facade.UserSocialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yichuan
 * @version $Id: UserSocialServiceImpl.java 265 2014-10-23 08:55:24Z yichuan $
 * @since 2.0
 */
@Service("userSocialService")
public class UserSocialServiceImpl implements UserSocialService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserSocialRepository userSocialRepository;
    // TODO
}
