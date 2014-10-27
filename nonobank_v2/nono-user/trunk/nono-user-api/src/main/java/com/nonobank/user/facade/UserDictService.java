/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserDictService.java 2014-10-27 16:40
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
 * @version $Id: UserDictService.java 289 2014-10-27 08:46:50Z fuchun $
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
