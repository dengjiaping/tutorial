/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserProfileServiceImpl.java 2014-10-27 16:41
 */

package com.nonobank.user.service.impl;

import com.nonobank.user.domain.repository.core.UserProfileRepository;
import com.nonobank.user.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Yichuan
 * @version $Id: UserProfileServiceImpl.java 293 2014-10-28 06:01:08Z yichuan $
 * @since 2.0
 */
@Service("userProfileService")
@Transactional(readOnly = true)
public class UserProfileServiceImpl implements UserProfileService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserProfileRepository userProfileRepository;
    // TODO
}
