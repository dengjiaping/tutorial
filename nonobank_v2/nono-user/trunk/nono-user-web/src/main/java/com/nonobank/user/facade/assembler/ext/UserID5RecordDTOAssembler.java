/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserID5RecordDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.ext;

import com.nonobank.user.domain.ext.UserID5Record;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.ext.UserID5RecordDTO;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserID5RecordDTOAssembler extends AbstractAssembler<UserID5Record, UserID5RecordDTO> {

    public static final UserID5RecordDTOAssembler ASSEMBLER = new UserID5RecordDTOAssembler();

    @Override
    public UserID5RecordDTO toDTO(UserID5Record entity) {
        if (entity == null)
            return null;
        return new UserID5RecordDTO(
                entity.getId(), entity.getUserId(), entity.getRealName(), entity.getIdCard(),
                entity.getSchoolName(), entity.getEducation(), entity.getEntranceTime(),
                entity.getProfession(), entity.getGraduation(), entity.getStudyResult(),
                entity.getStudyChannel(), entity.getCreatedDate()
        );
    }

    @Override
    public UserID5Record toEntity(UserID5RecordDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to UserID5Record.");
    }
}
