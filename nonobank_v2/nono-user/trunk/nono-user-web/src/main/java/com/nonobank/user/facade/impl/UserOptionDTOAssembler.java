/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserOptionDTOAssembler.java 2014-10-23 16:20
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.core.UserOption;
import com.nonobank.user.facade.dto.core.UserOptionDTO;

/**
 * @author Yichuan
 * @version $Id: UserOptionDTOAssembler.java 263 2014-10-23 08:24:59Z yichuan $
 * @since 2.0
 */
public class UserOptionDTOAssembler extends AbstractAssembler<UserOption, UserOptionDTO> {

    public static final UserOptionDTOAssembler ASSEMBLER = new UserOptionDTOAssembler();

    @Override
    public UserOptionDTO toDTO(UserOption entity) {
        if (entity == null)
            return null;
        return new UserOptionDTO(
                entity.getId(), entity.getUserId(), entity.getKey(),
                entity.getValue(), entity.getBigValue(), entity.isBig()
        );
    }

    @Override
    public UserOption toEntity(UserOptionDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to UserOption.");
    }
}
