/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserSocialServiceImpl.java 2014-10-27 16:41
 */

package com.nonobank.user.service.impl;

import com.nonobank.user.domain.repository.core.UserSocialRepository;
import com.nonobank.user.service.UserSocialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yichuan
 * @version $Id: UserSocialServiceImpl.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Service("userSocialService")
public class UserSocialServiceImpl implements UserSocialService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserSocialRepository userSocialRepository;
    // TODO
}
