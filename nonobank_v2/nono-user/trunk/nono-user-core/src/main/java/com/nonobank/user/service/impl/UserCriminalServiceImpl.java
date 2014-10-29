/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserCriminalServiceImpl.java 2014-10-29 15:09
 */

package com.nonobank.user.service.impl;

import com.nonobank.user.domain.ext.UserCriminal;
import com.nonobank.user.domain.repository.ext.UserCriminalRepository;
import com.nonobank.user.service.UserCriminalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.nonobank.user.domain.ext.UserCriminal.PROP_CREATED_DATE;

/**
 * @author Yichuan
 * @version $Id: UserCriminalServiceImpl.java 300 2014-10-29 08:32:39Z yichuan $
 * @since 2.0
 */
@Service("userCriminalService")
@Transactional(readOnly = true)
public class UserCriminalServiceImpl implements UserCriminalService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserCriminalRepository userCriminalRepository;

    @Override
    public List<UserCriminal> findByUserId(Long userId) {
        return userCriminalRepository.findByUserId(userId,
                new Sort(Sort.Direction.DESC, PROP_CREATED_DATE));
    }
}