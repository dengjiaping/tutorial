/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) StateDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.dict;

import com.nonobank.user.domain.dict.State;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.dict.StateDTO;

/**
 * @author fuchun
 * @version $Id: StateDTOAssembler.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class StateDTOAssembler extends AbstractAssembler<State, StateDTO> {

    public static final StateDTOAssembler ASSEMBLER = new StateDTOAssembler();

    @Override
    public StateDTO toDTO(State entity) {
        if (entity == null) {
            return null;
        }
        StateDTO dto = new StateDTO(
                entity.getId(),
                entity.getCode(),
                entity.getShortName(),
                entity.getRegionId());
        if (entity.getCities() != null) {
            dto.setCities(CityDTOAssembler.ASSEMBLER
                    .toDTOList(entity.getCities(), c -> c != null));
        }
        return dto;
    }

    @Override
    public State toEntity(StateDTO dto) {
        throw new UnsupportedOperationException("Not support transform to State.");
    }
}
