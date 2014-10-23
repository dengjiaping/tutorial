/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) ScoreRankRepository.java 2014-10-15 13:30
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.QScoreRank;
import com.nonobank.user.domain.ext.ScoreRank;

import java.util.Objects;

/**
 * 积分等级信息查询接口
 *
 * @author Yichuan
 * @version $Id: ScoreRankRepository.java 169 2014-10-15 05:45:31Z yichuan $
 * @since 2.0
 */
public interface ScoreRankRepository extends QueryDslRepository<ScoreRank, Long> {

    public default ScoreRank findByScore(Integer score) {
        Objects.requireNonNull(score, ScoreRank.PROP_START_SCORE);
        return findOne(QScoreRank.qsr.startScore.loe(score).and(
                QScoreRank.qsr.endScore.goe(score)
        ));
    }
}
