/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserProfileRepository.java 2014-10-13 10:11
 */

package com.nonobank.user.domain.repository.core;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.core.QUserProfile;
import com.nonobank.user.domain.core.UserProfile;

import java.util.Objects;

import static com.nonobank.user.domain.core.UserProfile.*;

/**
 * {@code UserProfile} 实体的仓储接口。
 *
 * @author fuchun
 * @version $Id$
 * @since 2.0
 */
public interface UserProfileRepository extends QueryDslRepository<UserProfile, Long> {

    public default UserProfile findByUserId(Long userId) {
        Objects.requireNonNull(userId, PROP_USER_ID);
        return findOne(QUserProfile.qup.userId.eq(userId));
    }

    public default UserProfile findByUserName(String userName) {
        Objects.requireNonNull(userName, PROP_USER_NAME);
        return findOne(QUserProfile.qup.userName.eq(userName));
    }

    public default UserProfile findByMobileNo(String mobileNo) {
        Objects.requireNonNull(mobileNo, PROP_MOBILE_NO);
        return findOne(QUserProfile.qup.mobileNO.eq(mobileNo));
    }
}
