/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) DictDTOAssembler.java 2014-10-22 11:09
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.dict.Dict;
import com.nonobank.user.facade.dto.dict.DictDTO;

/**
 * @author fuchun
 * @version $Id: DictDTOAssembler.java 260 2014-10-23 07:18:22Z yichuan $
 * @since 2.0
 */
public class DictDTOAssembler extends AbstractAssembler<Dict, DictDTO> {

    public static final DictDTOAssembler ASSEMBLER = new DictDTOAssembler();

    @Override
    public DictDTO toDTO(Dict entity) {
        if (entity == null) {
            return null;
        }
        return new DictDTO(
                entity.getCode(),
                entity.getName(),
                entity.getOrderNO()
        );
    }

    @Override
    public Dict toEntity(DictDTO dto) {
        throw new UnsupportedOperationException("Not support transform to Dict.");
    }
}
