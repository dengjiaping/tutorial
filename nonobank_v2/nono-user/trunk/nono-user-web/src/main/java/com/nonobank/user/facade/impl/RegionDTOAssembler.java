/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) RegionDTOAssembler.java 2014-10-22 09:19
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.dict.Region;
import com.nonobank.user.facade.dto.dict.RegionDTO;

/**
 * @author fuchun
 * @version $Id: RegionDTOAssembler.java 260 2014-10-23 07:18:22Z yichuan $
 * @since 2.0
 */
public class RegionDTOAssembler extends AbstractAssembler<Region, RegionDTO> {

    public static final RegionDTOAssembler ASSEMBLER = new RegionDTOAssembler();

    @Override
    public RegionDTO toDTO(Region entity) {
        if (entity == null) {
            return null;
        }
        RegionDTO dto = new RegionDTO(
                entity.getId(),
                entity.getCode(),
                entity.getShortName()
        );
        if (entity.getStates() != null) {
            dto.setStates(StateDTOAssembler.ASSEMBLER
                    .toDTOList(entity.getStates(), s -> s != null));
        }
        return dto;
    }

    @Override
    public Region toEntity(RegionDTO dto) {
        throw new UnsupportedOperationException("Not support transform to Region.");
    }
}
