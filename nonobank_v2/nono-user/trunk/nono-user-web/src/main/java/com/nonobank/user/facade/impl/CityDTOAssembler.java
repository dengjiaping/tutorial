/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CityDTOAssembler.java 2014-10-22 09:18
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.dict.City;
import com.nonobank.user.facade.dto.dict.CityDTO;

/**
 * @author fuchun
 * @version $Id: CityDTOAssembler.java 260 2014-10-23 07:18:22Z yichuan $
 * @since 2.0
 */
public class CityDTOAssembler extends AbstractAssembler<City, CityDTO> {

    public static final CityDTOAssembler ASSEMBLER = new CityDTOAssembler();

    @Override
    public CityDTO toDTO(City entity) {
        if (entity == null) {
            return null;
        }
        CityDTO dto = new CityDTO(
                entity.getId(),
                entity.getCode(),
                entity.getShortName(),
                entity.getStateId()
        );
        if (entity.getCounties() != null) {
            dto.setCounties(CountyDTOAssembler.ASSEMBLER
                    .toDTOList(entity.getCounties(), c -> c != null));
        }
        return dto;
    }

    @Override
    public City toEntity(CityDTO dto) {
        throw new UnsupportedOperationException("Not support transform to City.");
    }
}
