/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserScoreIncomeRepository.java 2014-10-17 11:21
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
 * @version $Id: JdbcUserScoreIncomeRepository.java 208 2014-10-17 09:36:17Z yichuan $
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
