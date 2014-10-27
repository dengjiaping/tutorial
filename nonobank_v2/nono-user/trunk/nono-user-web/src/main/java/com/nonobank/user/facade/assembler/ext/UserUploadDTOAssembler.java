/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserUploadDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.ext;

import com.nonobank.user.domain.ext.UserUpload;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.ext.UserUploadDTO;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class UserUploadDTOAssembler extends AbstractAssembler<UserUpload, UserUploadDTO> {

    public static final UserUploadDTOAssembler ASSEMBLER = new UserUploadDTOAssembler();

    @Override
    public UserUploadDTO toDTO(UserUpload entity) {
        if (entity == null)
            return null;
        return new UserUploadDTO(
                entity.getId(), entity.getUserId(), entity.getUploadTypeId(),
                entity.getUploadTitle(), entity.getUploadContent(), entity.getAuditStatus().getCode(),
                entity.getAuditTime(), entity.getOperatorId(), entity.getOperatorName(),
                entity.getAssignerId(), entity.getAssignerName(), entity.getAssignTime(),
                entity.getRemarks(), entity.getLastModifiedDate(), entity.getCreatedDate()
        );
    }

    @Override
    public UserUpload toEntity(UserUploadDTO dto) {
        throw new UnsupportedOperationException("Not supported transform to UserUpload.");
    }
}