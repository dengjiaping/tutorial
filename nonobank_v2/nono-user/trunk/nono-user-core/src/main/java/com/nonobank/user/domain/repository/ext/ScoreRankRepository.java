/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ScoreRankRepository.java 2014-10-27 16:41
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
 * @version $Id: ScoreRankRepository.java 289 2014-10-27 08:46:50Z fuchun $
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
