/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserScoreIncomeRepository.java 2014-10-27 16:41
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
 * @version $Id: UserScoreIncomeRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface UserScoreIncomeRepository extends QueryDslRepository<UserScoreIncome, Long> {

    public default List<UserScoreIncome> findByUserId(Long userId) {
        Objects.requireNonNull(userId, PROP_USER_ID);
        return findAll(qusd.userId.eq(userId));
    }
}
