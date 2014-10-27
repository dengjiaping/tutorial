/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) RegionDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.dict;

import com.nonobank.user.domain.dict.Region;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.dict.RegionDTO;

/**
 * @author fuchun
 * @version $Id: RegionDTOAssembler.java 289 2014-10-27 08:46:50Z fuchun $
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
