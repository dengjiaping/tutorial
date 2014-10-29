/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserCriminalRepository.java 2014-10-29 14:59
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.UserCriminal;
import org.springframework.data.domain.Sort;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Yichuan
 * @version $Id: UserCriminalRepository.java 300 2014-10-29 08:32:39Z yichuan $
 * @since 2.0
 */
public interface UserCriminalRepository extends QueryDslRepository<UserCriminal, Long> {

    /**
     * 查询指定用户的刑侦信息
     *
     * @param userId    用户ID
     * @param sort      排序
     */
    @Nonnull
    public List<UserCriminal> findByUserId(Long userId, @Nullable Sort sort);
}
