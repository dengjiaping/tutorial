/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CountyDTOAssembler.java 2014-10-22 09:19
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.dict.County;
import com.nonobank.user.facade.dto.dict.CountyDTO;

/**
 * @author fuchun
 * @version $Id: CountyDTOAssembler.java 260 2014-10-23 07:18:22Z yichuan $
 * @since 2.0
 */
public class CountyDTOAssembler extends AbstractAssembler<County, CountyDTO> {

    public static final CountyDTOAssembler ASSEMBLER = new CountyDTOAssembler();

    @Override
    public CountyDTO toDTO(County entity) {
        if (entity == null) {
            return null;
        }
        return new CountyDTO(
                entity.getId(),
                entity.getCode(),
                entity.getShortName(),
                entity.getCityId()
        );
    }

    @Override
    public County toEntity(CountyDTO dto) {
        throw new UnsupportedOperationException("Not support transform to County.");
    }
}