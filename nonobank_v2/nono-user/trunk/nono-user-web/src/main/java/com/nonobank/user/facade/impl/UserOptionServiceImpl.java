/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserOptionServiceImpl.java 2014-10-23 16:23
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.repository.core.UserOptionRepository;
import com.nonobank.user.facade.UserOptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yichuan
 * @version $Id: UserOptionServiceImpl.java 265 2014-10-23 08:55:24Z yichuan $
 * @since 2.0
 */
@Service("userOptionService")
public class UserOptionServiceImpl implements UserOptionService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserOptionRepository userOptionRepository;
    // TODO
}