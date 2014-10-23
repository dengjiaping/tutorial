/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcScoreAllocRepository.java 2014-10-16 10:30
 */

package com.nonobank.user.base.jdbc.ext;

import com.mysema.query.sql.ColumnMetadata;
import com.nonobank.data.jdbc.types.EnumValueType;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.ScoreAlloc;
import com.nonobank.user.domain.ext.common.ScoreAllocType;
import com.nonobank.user.domain.repository.ext.ScoreAllocRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.ext.QScoreAlloc.SCORE_ALLOC_TABLE;
import static com.nonobank.user.domain.ext.QScoreAlloc.qsa;

/**
 * 积分类型配置信息数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcScoreAllocRepository.java 212 2014-10-20 01:48:43Z yichuan $
 * @since 2.0
 */
@Repository("scoreAllocRepository")
public class JdbcScoreAllocRepository
        extends QueryDslJdbcRepository<ScoreAlloc, Long>
        implements ScoreAllocRepository {

    public JdbcScoreAllocRepository() {
        super(qsa);
    }

    @PostConstruct
    public void initialize() {
        queryDslJdbcTemplate.registerColumnType(
                SCORE_ALLOC_TABLE, ColumnMetadata.getName(qsa.allocType),
                new EnumValueType<>(ScoreAllocType.class)
        );
    }
}
