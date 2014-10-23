/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserAuthcServiceImpl.java 2014-10-23 16:09
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.repository.core.UserAuthcRepository;
import com.nonobank.user.facade.UserAuthcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yichuan
 * @version $Id: UserAuthcServiceImpl.java 265 2014-10-23 08:55:24Z yichuan $
 * @since 2.0
 */
@Service("userAuthcService")
public class UserAuthcServiceImpl implements UserAuthcService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserAuthcRepository userAuthcRepository;
    // TODO
}
