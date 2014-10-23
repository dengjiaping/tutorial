/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserSocialDTOAssembler.java 2014-10-23 15:28
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.core.UserSocial;
import com.nonobank.user.facade.dto.core.UserSocialDTO;

/**
 * @author Yichuan
 * @version $Id: UserSocialDTOAssembler.java 263 2014-10-23 08:24:59Z yichuan $
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
