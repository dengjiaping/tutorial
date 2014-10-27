/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) BankDTOAssembler.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.assembler.dict;

import com.nonobank.user.domain.dict.Bank;
import com.nonobank.user.facade.assembler.AbstractAssembler;
import com.nonobank.user.facade.dto.dict.BankDTO;

/**
 * @author fuchun
 * @version $Id: BankDTOAssembler.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class BankDTOAssembler extends AbstractAssembler<Bank, BankDTO> {
    
    public static final BankDTOAssembler ASSEMBLER = new BankDTOAssembler();

    @Override
    public BankDTO toDTO(Bank entity) {
        if (entity == null) {
            return null;
        }
        return new BankDTO(
                entity.getId(),
                entity.getName(),
                entity.getLocCode(),
                entity.getParentId()
        );
    }

    @Override
    public Bank toEntity(BankDTO dto) {
        throw new UnsupportedOperationException("Not support transform to Bank.");
    }
}
