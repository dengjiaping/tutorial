/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserScoreIncomeRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.UserScoreIncome;
import com.nonobank.user.domain.repository.ext.UserScoreIncomeRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.ext.QUserScoreIncome.qusd;

/**
 * 用户积分收入数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcUserScoreIncomeRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Repository("userScoreIncomeRepository")
public class JdbcUserScoreIncomeRepository
        extends QueryDslJdbcRepository<UserScoreIncome, Long>
        implements UserScoreIncomeRepository {

    public JdbcUserScoreIncomeRepository() {
        super(qusd);
    }

    @PostConstruct
    public void initialize() {

    }
}
