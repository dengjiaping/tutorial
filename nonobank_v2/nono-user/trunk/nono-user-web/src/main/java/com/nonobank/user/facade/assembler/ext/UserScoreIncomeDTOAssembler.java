/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserScoreIncomeDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.ext;

import com.nonobank.user.domain.ext.UserScoreIncome;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.ext.UserScoreIncomeDTO;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserScoreIncomeDTOAssembler extends AbstractAssembler<UserScoreIncome, UserScoreIncomeDTO> {

    public static final UserScoreIncomeDTOAssembler ASSEMBLER = new UserScoreIncomeDTOAssembler();

    @Override
    public UserScoreIncomeDTO toDTO(UserScoreIncome entity) {
        if (entity == null)
            return null;
        return new UserScoreIncomeDTO(
                entity.getId(), entity.getUserId(), entity.getScoreAllocId(),
                entity.getScore(), entity.getAuditScore(), entity.getAuditorId(),
                entity.getAuditTime(), entity.isConfirm(), entity.getRemarks(),
                entity.getLastModifiedDate(), entity.getCreatedDate()
        );
    }

    @Override
    public UserScoreIncome toEntity(UserScoreIncomeDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to UserScoreIncome.");
    }
}
