/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserScoreDetailRepository.java 2014-10-17 11:11
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.UserScoreIncome;

import java.util.List;
import java.util.Objects;

import static com.nonobank.user.domain.ext.QUserScoreIncome.qusd;
import static com.nonobank.user.domain.ext.UserScoreIncome.PROP_USER_ID;

/**
 * 用户积分收入数据查询接口
 *
 * @author Yichuan
 * @version $Id: UserScoreIncomeRepository.java 200 2014-10-17 03:57:56Z yichuan $
 * @since 2.0
 */
public interface UserScoreIncomeRepository extends QueryDslRepository<UserScoreIncome, Long> {

    public default List<UserScoreIncome> findByUserId(Long userId) {
        Objects.requireNonNull(userId, PROP_USER_ID);
        return findAll(qusd.userId.eq(userId));
    }
}
