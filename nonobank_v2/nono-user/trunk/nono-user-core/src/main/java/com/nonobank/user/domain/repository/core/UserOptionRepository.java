/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserOptionRepository.java 2014-10-16 14:25
 */

package com.nonobank.user.domain.repository.core;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.data.repository.support.QueryDsl;
import com.nonobank.user.domain.core.UserOption;
import org.springframework.data.domain.Sort;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

import static com.nonobank.user.domain.core.QUserOption.qOpt;

/**
 * 用户配置项{@code UserOption} 实体的仓储接口。
 *
 * @author fuchun
 * @version $Id: UserOptionRepository.java 196 2014-10-16 08:54:06Z fuchun $
 * @since 2.0
 */
public interface UserOptionRepository extends QueryDslRepository<UserOption, Long> {

    /**
     * 查询指定用户和配置名称的配置信息。如果没有配置信息，则返回{@code null}。
     *
     * @param userId 用户id。
     * @param key 配置键名称。
     * @return 返回指定用户和配置名称的配置信息。
     * @throws NullPointerException 如果{@code userId == null || name == null}。
     */
    @Nullable
    public default UserOption findByUserIdAndKey(Long userId, String key) {
        Objects.requireNonNull(userId, UserOption.PROP_USER_ID);
        Objects.requireNonNull(key, UserOption.PROP_KEY);
        return findOne(qOpt.userId.eq(userId).and(qOpt.key.eq(key)));
    }

    /**
     * 查询指定用户的所有配置信息，并按照指定的排序规则进行列表排序。
     *
     * @param userId 用户id。
     * @param sort 排序规则。
     * @return 返回指定用户的排序的所有配置信息。
     * @throws NullPointerException 如果{@code userId == null}。
     */
    @Nonnull
    public default List<UserOption> findByUserId(Long userId, Sort sort) {
        Objects.requireNonNull(userId, UserOption.PROP_USER_ID);
        return findAll(qOpt.userId.eq(userId), QueryDsl.toOrders(qOpt, sort));
    }

    /**
     * 查询指定用户的所有配置信息。默认使用{@code option name} 按顺序排序。
     *
     * @param userId 用户id。
     * @return 返回指定用户的所有配置信息。
     * @throws NullPointerException 如果{@code userId == null}。
     */
    @Nonnull
    public default List<UserOption> findByUserIdOrderByKeyASC(Long userId) {
        return findByUserId(userId, new Sort(Sort.Direction.ASC,
                UserOption.PROP_NAME));
    }
}