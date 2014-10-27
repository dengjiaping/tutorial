/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserOptionDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.core;

import com.nonobank.user.domain.core.UserOption;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.core.UserOptionDTO;

/**
 * @author Yichuan
 * @version $Id: UserOptionDTOAssembler.java 289 2014-10-27 08:46:50Z fuchun $
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
