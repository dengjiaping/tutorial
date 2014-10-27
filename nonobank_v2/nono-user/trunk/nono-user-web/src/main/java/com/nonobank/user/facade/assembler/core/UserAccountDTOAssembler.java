/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserAccountDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.core;

import com.nonobank.user.domain.core.UserAccount;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.core.UserAccountDTO;

/**
 * @author Yichuan
 * @version $Id: UserAccountDTOAssembler.java 289 2014-10-27 08:46:50Z fuchun $
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