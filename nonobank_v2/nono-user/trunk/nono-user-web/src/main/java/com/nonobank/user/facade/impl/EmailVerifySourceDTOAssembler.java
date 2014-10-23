/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) EmailVerifySourceDTOAssembler.java 2014-10-23 17:13
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.message.EmailVerifySource;
import com.nonobank.user.facade.dto.message.EmailVerifySourceDTO;

/**
 * @author Yichuan
 * @version $Id: EmailVerifySourceDTOAssembler.java 266 2014-10-23 09:18:20Z yichuan $
 * @since 2.0
 */
public class EmailVerifySourceDTOAssembler extends AbstractAssembler<EmailVerifySource, EmailVerifySourceDTO> {

    public static final EmailVerifySourceDTOAssembler ASSEMBLER = new EmailVerifySourceDTOAssembler();

    @Override
    public EmailVerifySourceDTO toDTO(EmailVerifySource entity) {
        if (entity == null)
            return null;
        return new EmailVerifySourceDTO(
                entity.getId(), entity.getUserId(), entity.getToken(), entity.getContent(),
                entity.getDeadline(), entity.getUseTimes(), entity.getStatus().getCode(),
                entity.getLastModifiedDate(), entity.getCreatedDate()
        );
    }

    @Override
    public EmailVerifySource toEntity(EmailVerifySourceDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to EmailVerifySource.");
    }
}
