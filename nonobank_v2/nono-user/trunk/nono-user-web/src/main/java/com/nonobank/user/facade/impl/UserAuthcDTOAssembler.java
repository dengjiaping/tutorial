/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserAuthcDTOAssembler.java 2014-10-23 16:04
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.core.UserAuthc;
import com.nonobank.user.facade.dto.core.UserAuthcDTO;

/**
 * @author Yichuan
 * @version $Id: UserAuthcDTOAssembler.java 262 2014-10-23 08:10:39Z yichuan $
 * @since 2.0
 */
public class UserAuthcDTOAssembler extends AbstractAssembler<UserAuthc, UserAuthcDTO> {

    public static final UserAuthcDTOAssembler ASSEMBLER = new UserAuthcDTOAssembler();

    @Override
    public UserAuthcDTO toDTO(UserAuthc entity) {
        if (entity == null)
            return null;
        return new UserAuthcDTO(
                entity.getUserId(), entity.getUserName(), entity.getEmail(),
                entity.isEmailVerified(), entity.getMobileNO(), entity.isMobileVerified(),
                entity.getAvatar(), entity.getAvatarStatus().getValue(), entity.getRealName(),
                entity.getIdCard(), entity.isCardVerified(), DictDTOAssembler.ASSEMBLER.toDTO(entity.getEducation()),
                entity.getDiploma(), entity.getEduValidCode(), entity.getEduCreateTime(),
                entity.isEduVerified(), entity.getProfession(), entity.getStuNumber(),
                entity.getUnivLocation(), entity.getUnivName(), entity.getCampus(),
                entity.getEntranceYear(), entity.isStuVerified(), entity.isFaceVerified(),
                entity.getLastModifiedDate(), entity.getCreatedDate()
        );
    }

    @Override
    public UserAuthc toEntity(UserAuthcDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to UserAuthc.");
    }
}