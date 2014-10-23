/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserStatsServiceImpl.java 2014-10-23 16:47
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.repository.core.UserStatsRepository;
import com.nonobank.user.facade.UserStatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yichuan
 * @version $Id: UserStatsServiceImpl.java 265 2014-10-23 08:55:24Z yichuan $
 * @since 2.0
 */
@Service("userStatsService")
public class UserStatsServiceImpl implements UserStatsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserStatsRepository userStatsRepository;
    // TODO
}
