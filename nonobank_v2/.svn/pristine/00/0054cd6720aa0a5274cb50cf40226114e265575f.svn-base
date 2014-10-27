/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserEducationDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.ext;

import com.nonobank.user.domain.ext.UserEducation;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.assembler.dict.DictDTOAssembler;
import com.nonobank.user.facade.dto.ext.UserEducationDTO;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserEducationDTOAssembler extends AbstractAssembler<UserEducation, UserEducationDTO> {

    public static final UserEducationDTOAssembler ASSEMBLER = new UserEducationDTOAssembler();

    @Override
    public UserEducationDTO toDTO(UserEducation entity) {
        if (entity == null)
            return null;
        return new UserEducationDTO(
                entity.getId(), entity.getUserId(), entity.getUserName(),
                entity.getSchoolName(), entity.getProfession(), DictDTOAssembler.ASSEMBLER.toDTO(entity.getEducation()),
                entity.getStartYear(), entity.getStartMonth(), entity.getEndYear(), entity.getEndMonth(),
                entity.getRemarks(), entity.getLastModifiedDate(), entity.getCreatedDate()
        );
    }

    @Override
    public UserEducation toEntity(UserEducationDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to UserEducation.");
    }
}
