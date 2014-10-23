/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcScoreRankRepository.java 2014-10-15 13:49
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.ScoreRank;
import com.nonobank.user.domain.repository.ext.ScoreRankRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.ext.QScoreRank.qsr;

/**
 * 积分等级信息数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcScoreRankRepository.java 170 2014-10-15 05:54:15Z yichuan $
 * @since 2.0
 */
@Repository("scoreRankRepository")
public class JdbcScoreRankRepository
        extends QueryDslJdbcRepository<ScoreRank, Long>
        implements ScoreRankRepository {

    public JdbcScoreRankRepository() {
        super(qsr);
    }

    @PostConstruct
    public void initialize() {

    }
}
