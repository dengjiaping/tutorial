/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserAuthcServiceImpl.java 2014-10-27 16:41
 */

package com.nonobank.user.service.impl;

import com.nonobank.user.domain.repository.core.UserAuthcRepository;
import com.nonobank.user.service.UserAuthcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Yichuan
 * @version $Id: UserAuthcServiceImpl.java 293 2014-10-28 06:01:08Z yichuan $
 * @since 2.0
 */
@Service("userAuthcService")
@Transactional(readOnly = true)
public class UserAuthcServiceImpl implements UserAuthcService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserAuthcRepository userAuthcRepository;
    // TODO
}
