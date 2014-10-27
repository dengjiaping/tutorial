/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ScoreRankDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.ext;

import com.nonobank.common.json.JsonMapper;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.List;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class ScoreRankDTO implements Serializable {

    private static final long serialVersionUID = -6521952371315312506L;

    private final Long id;
    private final String rankName;
    private final String rankIcon;
    private final int startScore;
    private final int endScore;
    private final List<ScoreCapitalInfoDTO> scoreCapitals;
    private final String remarks;
    private final DateTime lastModifiedDate;
    private final DateTime createdDate;

    public ScoreRankDTO(Long id, String rankName, String rankIcon, int startScore,
                        int endScore, List<ScoreCapitalInfoDTO> scoreCapitals,
                        String remarks, DateTime lastModifiedDate, DateTime createdDate) {
        this.id = id;
        this.rankName = rankName;
        this.rankIcon = rankIcon;
        this.startScore = startScore;
        this.endScore = endScore;
        this.scoreCapitals = scoreCapitals;
        this.remarks = remarks;
        this.lastModifiedDate = lastModifiedDate;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public String getRankName() {
        return rankName;
    }

    public String getRankIcon() {
        return rankIcon;
    }

    public int getStartScore() {
        return startScore;
    }

    public int getEndScore() {
        return endScore;
    }

    public List<ScoreCapitalInfoDTO> getScoreCapitals() {
        return scoreCapitals;
    }

    public String getRemarks() {
        return remarks;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("ScoreRankDTO{id=%d, rankName='%s', rankIcon='%s', startScore=%d, endScore=%d, scoreCapitals='%s', remarks='%s', lastModifiedDate='%s', createdDate='%s'}",
                id, rankName, rankIcon, startScore, endScore, JsonMapper.getDefault().toJSONString(scoreCapitals), remarks, lastModifiedDate, createdDate);
    }
}