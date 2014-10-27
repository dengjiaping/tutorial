/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ScoreRankDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.ext;

import com.google.common.collect.Lists;
import com.nonobank.user.domain.ext.ScoreRank;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.ext.ScoreCapitalInfoDTO;
import com.nonobank.user.facade.dto.ext.ScoreRankDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class ScoreRankDTOAssembler extends AbstractAssembler<ScoreRank, ScoreRankDTO> {

    public static final ScoreRankDTOAssembler ASSEMBLER = new ScoreRankDTOAssembler();

    @Override
    public ScoreRankDTO toDTO(ScoreRank entity) {
        if (entity == null)
            return null;
        List<ScoreCapitalInfoDTO> scoreCapitals = Lists.newArrayList();
        scoreCapitals.addAll(entity.getCapitals().stream().map(info -> new ScoreCapitalInfoDTO(
                info.getType().getCode(), info.getMinRate(), info.getMaxAmount(),
                info.getMaxGuarantee(), info.getGuaranteeRate()
        )).collect(Collectors.toList()));
        return new ScoreRankDTO(
                entity.getId(), entity.getRankName(), entity.getRankIcon(),
                entity.getStartScore(), entity.getEndScore(), scoreCapitals,
                entity.getRemarks(), entity.getLastModifiedDate(), entity.getCreatedDate()
        );
    }

    @Override
    public ScoreRank toEntity(ScoreRankDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to ScoreRank.");
    }
}
