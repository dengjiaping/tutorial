/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserAuthcDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.core;

import com.nonobank.user.domain.core.UserAuthc;
import com.nonobank.user.facade.assembler.dict.DictDTOAssembler;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.core.UserAuthcDTO;

/**
 * @author Yichuan
 * @version $Id: UserAuthcDTOAssembler.java 289 2014-10-27 08:46:50Z fuchun $
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
