/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ScoreAllocDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.ext;

import com.nonobank.user.domain.ext.ScoreAlloc;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.ext.ScoreAllocDTO;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class ScoreAllocDTOAssembler extends AbstractAssembler<ScoreAlloc, ScoreAllocDTO> {

    public static final ScoreAllocDTOAssembler ASSEMBLER = new ScoreAllocDTOAssembler();

    @Override
    public ScoreAllocDTO toDTO(ScoreAlloc entity) {
        if (entity == null)
            return null;
        return new ScoreAllocDTO(
                entity.getId(), entity.getAllocName(), entity.getAllocType().getCode(),
                entity.getKeyword(), entity.getAllocDesc(), entity.getMinScore(),
                entity.getMaxScore(), entity.isEnabled(), entity.getRefuseReason(),
                entity.getOrderNum(), entity.isAutoAssign(), entity.getLastModifiedDate(), entity.getCreatedDate()
        );
    }

    @Override
    public ScoreAlloc toEntity(ScoreAllocDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to ScoreAlloc.");
    }
}
