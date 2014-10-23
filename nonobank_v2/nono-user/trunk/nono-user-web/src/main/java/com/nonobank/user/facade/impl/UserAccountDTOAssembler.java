/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserAccountDTOAssembler.java 2014-10-23 14:25
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.core.UserAccount;
import com.nonobank.user.facade.dto.core.UserAccountDTO;

/**
 * @author Yichuan
 * @version $Id: UserAccountDTOAssembler.java 261 2014-10-23 07:35:15Z yichuan $
 * @since 2.0
 */
public class UserAccountDTOAssembler extends AbstractAssembler<UserAccount, UserAccountDTO> {

    public static final UserAccountDTOAssembler ASSEMBLER = new UserAccountDTOAssembler();

    @Override
    public UserAccountDTO toDTO(UserAccount entity) {
        if (entity == null)
            return null;
        return new UserAccountDTO(
                entity.getUserId(),
                entity.getUserName(),
                entity.getHashedKey(),
                entity.getAvatar(),
                entity.getMobileNO(),
                entity.getLastModifiedDate(),
                entity.getCreatedDate()
        );
    }

    @Override
    public UserAccount toEntity(UserAccountDTO dto) {
        throw new UnsupportedOperationException("Not support transform to UserAccount.");
    }
}