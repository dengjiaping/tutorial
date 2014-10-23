/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserStatsDTOAssembler.java 2014-10-23 16:44
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.core.UserStats;
import com.nonobank.user.facade.dto.core.UserStatsDTO;

/**
 * @author Yichuan
 * @version $Id: UserStatsDTOAssembler.java 264 2014-10-23 08:48:26Z yichuan $
 * @since 2.0
 */
public class UserStatsDTOAssembler extends AbstractAssembler<UserStats, UserStatsDTO> {

    public static final UserStatsDTOAssembler ASSEMBLER = new UserStatsDTOAssembler();

    @Override
    public UserStatsDTO toDTO(UserStats entity) {
        if (entity == null)
            return null;
        return new UserStatsDTO(
                entity.getUserId(),
                entity.getTotalScore(),
                entity.getCurrScore(),
                entity.getBorrowCount(),
                entity.getRejectedCount(),
                entity.getBiddingCount(),
                entity.getLastModifiedDate(),
                entity.getCreatedDate()
        );
    }

    @Override
    public UserStats toEntity(UserStatsDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to UserStats.");
    }
}
