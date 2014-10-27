/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserSocialDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.core;

import com.nonobank.user.domain.core.UserSocial;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.core.UserSocialDTO;

/**
 * @author Yichuan
 * @version $Id: UserSocialDTOAssembler.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class UserSocialDTOAssembler extends AbstractAssembler<UserSocial, UserSocialDTO> {

    public static final UserSocialDTOAssembler ASSEMBLER = new UserSocialDTOAssembler();

    @Override
    public UserSocialDTO toDTO(UserSocial entity) {
        if (entity == null)
            return null;
        return new UserSocialDTO(
                entity.getId(),
                entity.getUserId(),
                entity.getUserName(),
                entity.getOpenId(),
                entity.getSocialSource().name(),
                entity.getAuthToken(),
                entity.getPeriod(),
                entity.getTokenUpdateTime(),
                entity.getLastModifiedDate(),
                entity.getCreatedDate()
        );
    }

    @Override
    public UserSocial toEntity(UserSocialDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to UserSocial");
    }
}