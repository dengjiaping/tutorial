/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserDictServiceImpl.java 2014-10-27 16:42
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.dict.*;
import com.nonobank.user.facade.assembler.dict.BankDTOAssembler;
import com.nonobank.user.facade.assembler.dict.DictDTOAssembler;
import com.nonobank.user.facade.assembler.dict.StateDTOAssembler;
import com.nonobank.user.facade.UserDictService;
import com.nonobank.user.facade.dto.dict.BankDTO;
import com.nonobank.user.facade.dto.dict.CollegeDTO;
import com.nonobank.user.facade.dto.dict.DictDTO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The based on implementation of the {@code UserDictService}.
 *
 * @author fuchun
 * @version $Id: UserDictServiceImpl.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Service("userDictService")
@Transactional(readOnly = true)
public class UserDictServiceImpl implements UserDictService {

    @Nonnull
    @Override
    public List<CollegeDTO> listColleges(Integer stateCode) {
        return listColleges(stateCode, new Sort(
                Sort.Direction.ASC, College.PROP_NAME));
    }

    @Nonnull
    @Override
    public List<CollegeDTO> listColleges(Integer stateCode, Sort sort) {
        List<College> colleges = College.list(stateCode, sort);
        if (colleges.isEmpty()) {
            return Collections.emptyList();
        }
        return colleges.stream().filter(c -> c != null)
                .map(c -> new CollegeDTO(
                        c.getId(),
                        c.getName(),
                        StateDTOAssembler.ASSEMBLER.toDTO(c.getState()),
                        c.getGrade()
                ))
                .collect(Collectors.toList());
    }

    @Nonnull
    @Override
    public List<BankDTO> listTopBanks() {
        List<Bank> banks = Bank.listTopBanks();
        if (banks.isEmpty()) {
            return Collections.emptyList();
        }
        return BankDTOAssembler.ASSEMBLER.toDTOList(banks);
    }

    @Nonnull
    @Override
    public List<BankDTO> listBranches(Integer bankId, Integer cityCode) {
        List<Bank> banks = Bank.listBranches(bankId, cityCode);
        if (banks.isEmpty()) {
            return Collections.emptyList();
        }
        return BankDTOAssembler.ASSEMBLER.toDTOList(banks);
    }

    @Nonnull
    @Override
    public List<DictDTO> listMarriages() {
        List<Dict> marriages = UserDict.findMarriages(CommonDict.DEFAULT_SORT);
        if (marriages.isEmpty()) {
            return Collections.emptyList();
        }
        return DictDTOAssembler.ASSEMBLER.toDTOList(marriages);
    }

    @Nonnull
    @Override
    public List<DictDTO> listEducations() {
        List<Dict> educations = UserDict.findEducations(
                CommonDict.DEFAULT_SORT);
        if (educations.isEmpty()) {
            return Collections.emptyList();
        }
        return DictDTOAssembler.ASSEMBLER.toDTOList(educations);
    }

    @Nonnull
    @Override
    public List<DictDTO> listPosition() {
        List<Dict> positions = UserDict.findPositions(CommonDict.DEFAULT_SORT);
        if (positions.isEmpty()) {
            return Collections.emptyList();
        }
        return DictDTOAssembler.ASSEMBLER.toDTOList(positions);
    }
}
