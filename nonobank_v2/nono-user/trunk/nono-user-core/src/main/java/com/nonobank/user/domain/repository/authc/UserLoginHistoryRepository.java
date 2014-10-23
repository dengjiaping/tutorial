/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserLoginHistoryRepository.java 2014-10-13 14:23
 */

package com.nonobank.user.domain.repository.authc;

import com.google.common.collect.ImmutableList;
import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.authc.UserDevice;
import com.nonobank.user.domain.authc.UserLoginHistory;

import javax.annotation.Nonnull;
import java.util.List;

import static com.nonobank.user.domain.authc.QUserLoginHistory.qulh;
import static com.nonobank.user.domain.authc.UserLoginHistory.PROP_DEVICE;
import static com.nonobank.user.domain.authc.UserLoginHistory.PROP_USER_ID;
import static java.util.Objects.requireNonNull;

/**
 * The {@code UserLoginHistory} entity repository.
 *
 * @author fuchun
 * @version $Id$
 * @since 2.0
 */
public interface UserLoginHistoryRepository
        extends QueryDslRepository<UserLoginHistory, Long> {

    public default UserLoginHistory findByUserIdAndDevice(
            Long userId, UserDevice device) {
        requireNonNull(userId, PROP_USER_ID);
        requireNonNull(device, PROP_DEVICE);
        return findOne(qulh.userId.eq(userId).and(qulh.device.eq(device)));
    }

    @Nonnull
    public default List<UserLoginHistory> findByUserId(Long userId) {
        requireNonNull(userId, PROP_USER_ID);
        if (userId <= 0) {
            return ImmutableList.of();
        }
        return findAll(qulh.userId.eq(userId));
    }
}
