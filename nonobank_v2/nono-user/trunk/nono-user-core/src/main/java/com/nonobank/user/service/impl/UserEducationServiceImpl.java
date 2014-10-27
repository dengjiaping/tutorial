/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserEducationServiceImpl.java 2014-10-27 16:41
 */

package com.nonobank.user.service.impl;

import com.nonobank.user.domain.ext.UserEducation;
import com.nonobank.user.domain.repository.ext.UserEducationRepository;
import com.nonobank.user.service.UserEducationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author Yichuan
 * @version $Id: UserEducationServiceImpl.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Service("userEducationService")
@Transactional(readOnly = true)
public class UserEducationServiceImpl implements UserEducationService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserEducationRepository userEducationRepository;

    @Nonnull
    @Override
    public List<UserEducation> findByUserId(Long userId) {
        return userEducationRepository.findByUserId(userId,
                new Sort(Sort.Direction.DESC, UserEducation.PROP_START_YEAR));
    }

    @Nonnull
    @Override
    public UserEducation saveEducation(Long userId, UserEducation userEducation) {
        userEducation.setUserId(userId);
        userEducationRepository.save(userEducation);
        return userEducation;
    }

    @Override
    public void saveEducations(Long userId, List<UserEducation> userEducationList) {
        for (UserEducation userEducation: userEducationList) {
            userEducation.setUserId(userId);
        }
        userEducationRepository.save(userEducationList);
    }
}