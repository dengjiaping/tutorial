/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ScoreRank.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.nonobank.common.json.JsonMapper;
import com.nonobank.data.domain.AbstractRecording;
import com.nonobank.user.domain.ext.capital.ScoreCapitalInfo;

import java.util.List;

/**
 * 积分等级配置信息实体
 *
 * @author Yichuan
 * @version $Id: ScoreRank.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class ScoreRank extends AbstractRecording<Long, ScoreRank> {

    public static final String PROP_RANK_NAME = "rankName";
    public static final String PROP_RANK_ICON = "rankIcon";
    public static final String PROP_START_SCORE = "startScore";
    public static final String PROP_END_SCORE = "endScore";
    public static final String PROP_SCORE_CAPITAL = "scoreCapital";
    public static final String PROP_REMARKS = "remarks";

    private static final long serialVersionUID = -3466790977104418474L;

    // 积分等级名
    private String rankName;
    // 积分等级图标
    private String rankIcon;
    // 积分等级下限值
    private int startScore;
    // 积分等级上限值
    private int endScore;
    // 积分等级相关资本信息(Linked<ScoreCapitalInfo>json字符串)
    private String scoreCapital;
    // 备注
    private String remarks;

    public ScoreRank() {
        super();
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getRankIcon() {
        return rankIcon;
    }

    public void setRankIcon(String rankIcon) {
        this.rankIcon = rankIcon;
    }

    public int getStartScore() {
        return startScore;
    }

    public void setStartScore(int startScore) {
        this.startScore = startScore;
    }

    public int getEndScore() {
        return endScore;
    }

    public void setEndScore(int endScore) {
        this.endScore = endScore;
    }

    public String getScoreCapital() {
        return scoreCapital;
    }

    public void setScoreCapital(String scoreCapital) {
        this.scoreCapital = scoreCapital;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_RANK_NAME, getRankName())
                .add(PROP_RANK_ICON, getRankIcon())
                .add(PROP_START_SCORE, getStartScore())
                .add(PROP_END_SCORE, getEndScore())
                .add(PROP_SCORE_CAPITAL, getScoreCapital())
                .add(PROP_REMARKS, getRemarks())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }

    public List<ScoreCapitalInfo> getCapitals() {
        if (Strings.isNullOrEmpty(getScoreCapital()))
            return ImmutableList.of();
        return JsonMapper.getDefault().readToList(getScoreCapital(), ScoreCapitalInfo.class);
    }
}
