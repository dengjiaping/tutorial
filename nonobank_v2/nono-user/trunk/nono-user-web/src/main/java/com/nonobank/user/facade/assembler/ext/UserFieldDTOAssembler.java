/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserFieldDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.ext;

import com.nonobank.user.domain.ext.UserField;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.ext.UserFieldDTO;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserFieldDTOAssembler extends AbstractAssembler<UserField, UserFieldDTO> {

    public static final UserFieldDTOAssembler ASSEMBLER = new UserFieldDTOAssembler();

    @Override
    public UserFieldDTO toDTO(UserField entity) {
        if (entity == null)
            return null;
        return new UserFieldDTO(
                entity.getId(), entity.getScoreAllocId(), entity.getFieldName(),
                entity.getFieldKwd(), entity.isRequired(), entity.getFieldMinLen(),
                entity.getFieldMaxLen(), entity.getFieldNote(), entity.getVerifyMode().getCode(),
                entity.isIntegrity(), entity.getFieldDesc(), entity.getLastModifiedDate(), entity.getCreatedDate()
        );
    }

    @Override
    public UserField toEntity(UserFieldDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to UserField.");
    }
}