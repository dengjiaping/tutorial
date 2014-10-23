/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserStatsRepository.java 2014-10-17 09:45
 */

package com.nonobank.user.base.jdbc.core;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.core.UserStats;
import com.nonobank.user.domain.repository.core.UserStatsRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.core.QUserStats.qust;

/**
 * 用户关键数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcUserStatsRepository.java 197 2014-10-17 01:50:40Z yichuan $
 * @since 2.0
 */
@Repository("userStatsRepository")
public class JdbcUserStatsRepository
        extends QueryDslJdbcRepository<UserStats, Long>
        implements UserStatsRepository {

    public JdbcUserStatsRepository() {
        super(qust);
    }

    @PostConstruct
    public void initialize() {

    }
}
