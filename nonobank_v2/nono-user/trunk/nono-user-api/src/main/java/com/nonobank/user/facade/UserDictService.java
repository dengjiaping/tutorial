/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserDictService.java 2014-10-22 08:59
 */

package com.nonobank.user.facade;

import com.nonobank.user.facade.dto.dict.BankDTO;
import com.nonobank.user.facade.dto.dict.CollegeDTO;
import com.nonobank.user.facade.dto.dict.DictDTO;
import org.springframework.data.domain.Sort;

import javax.annotation.Nonnull;
import java.rmi.Remote;
import java.util.List;

/**
 * 用户字典数据远程服务接口。
 *
 * @author fuchun
 * @version $Id: UserDictService.java 260 2014-10-23 07:18:22Z yichuan $
 * @since 2.0
 */
public interface UserDictService extends Remote {

    @Nonnull
    public List<CollegeDTO> listColleges(Integer stateCode);

    @Nonnull
    public List<CollegeDTO> listColleges(Integer stateCode, Sort sort);

    @Nonnull
    public List<BankDTO> listTopBanks();

    @Nonnull
    public List<BankDTO> listBranches(Integer bankId, Integer cityCode);

    @Nonnull
    public List<DictDTO> listMarriages();

    @Nonnull
    public List<DictDTO> listEducations();

    @Nonnull
    public List<DictDTO> listPosition();
}
