/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) ScoreAllocRepository.java 2014-10-16 10:28
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.QScoreAlloc;
import com.nonobank.user.domain.ext.ScoreAlloc;
import com.nonobank.user.domain.ext.common.ScoreAllocType;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * 积分类型配置信息数据查询接口
 *
 * @author Yichuan
 * @version $Id: ScoreAllocRepository.java 214 2014-10-20 02:02:21Z yichuan $
 * @since 2.0
 */
public interface ScoreAllocRepository extends QueryDslRepository<ScoreAlloc, Long> {

    public default ScoreAlloc findByKeyword(String keyword) {
        requireNonNull(keyword, ScoreAlloc.PROP_KEYWORD);
        return findOne(QScoreAlloc.qsa.keyword.eq(keyword));
    }

    public default List<ScoreAlloc> findByAllocType(ScoreAllocType allocType) {
        requireNonNull(allocType, ScoreAlloc.PROP_ALLOC_TYPE);
        return findAll(QScoreAlloc.qsa.allocType.eq(allocType));
    }
}
