/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserSocialRepository.java 2014-10-11 14:16
 */

package com.nonobank.user.domain.repository.core;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.data.repository.support.QueryDsl;
import com.nonobank.user.domain.core.SocialSource;
import com.nonobank.user.domain.core.UserSocial;
import org.springframework.data.domain.Sort;

import java.util.List;

import static com.nonobank.user.domain.core.QUserSocial.qus;
import static java.util.Objects.requireNonNull;

/**
 * {@code UserSource} 实体的仓储接口。
 *
 * @author fuchun
 * @version $Id$
 * @since 2.0
 */
public interface UserSocialRepository extends QueryDslRepository<UserSocial, Long> {

    public default boolean existsByAuthToken(String authToken) {
        return !(authToken == null || authToken.length() == 0) &&
                count(qus.authToken.eq(authToken)) > 0;
    }

    public default UserSocial findByUserIdAndAccSource(Long userId, SocialSource socialSource) {
        requireNonNull(userId, UserSocial.PROP_USER_ID);
        requireNonNull(socialSource, UserSocial.PROP_SOCIAL_SOURCE);
        return findOne(qus.userId.eq(userId).and(qus.socialSource.eq(socialSource)));
    }

    public default UserSocial findByOpenIdAndAccSource(String openId, SocialSource socialSource) {
        requireNonNull(openId, UserSocial.PROP_OPEN_ID);
        requireNonNull(socialSource, UserSocial.PROP_SOCIAL_SOURCE);
        return findOne(qus.openId.eq(openId).and(qus.socialSource.eq(socialSource)));
    }

    public default List<UserSocial> findByUserId(Long userId, Sort sort) {
        requireNonNull(userId, UserSocial.PROP_USER_ID);
        return findAll(qus.userId.eq(userId), QueryDsl.toOrders(qus, sort));
    }
}
