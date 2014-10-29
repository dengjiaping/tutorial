/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserSocialServiceImpl.java 2014-10-27 16:41
 */

package com.nonobank.user.service.impl;

import com.nonobank.user.domain.core.SocialSource;
import com.nonobank.user.domain.core.UserSocial;
import com.nonobank.user.domain.exception.UserNotFoundException;
import com.nonobank.user.domain.repository.core.UserSocialRepository;
import com.nonobank.user.service.UserSocialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yichuan
 * @version $Id: UserSocialServiceImpl.java 300 2014-10-29 08:32:39Z yichuan $
 * @since 2.0
 */
@Service("userSocialService")
@Transactional(readOnly = true)
public class UserSocialServiceImpl implements UserSocialService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserSocialRepository userSocialRepository;

    @Override
    public List<UserSocial> findByUserId(Long userId) {
        if (userId == null)
            throw new UserNotFoundException();
        return userSocialRepository.findByUserId(userId, null);
    }

    @Override
    public UserSocial findByUserIdAndSource(Long userId, SocialSource socialSource) {
        if (userId == null || socialSource == null)
            throw new UserNotFoundException("");
        return userSocialRepository.findByUserIdAndAccSource(userId, socialSource);
    }
}
