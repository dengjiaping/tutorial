/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcScoreRankRepository.java 2014-10-27 16:41
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
 * @version $Id: JdbcScoreRankRepository.java 289 2014-10-27 08:46:50Z fuchun $
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
