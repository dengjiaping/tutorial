/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) LocationServiceImpl.java 2014-10-21 13:50
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.domain.dict.*;
import com.nonobank.user.facade.LocationService;
import com.nonobank.user.facade.dto.dict.CityDTO;
import com.nonobank.user.facade.dto.dict.CountyDTO;
import com.nonobank.user.facade.dto.dict.RegionDTO;
import com.nonobank.user.facade.dto.dict.StateDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author fuchun
 * @version $Id: LocationServiceImpl.java 260 2014-10-23 07:18:22Z yichuan $
 * @since 2.0
 */
@Service("locationService")
public class LocationServiceImpl implements LocationService {

    @Nonnull
    @Override
    public List<RegionDTO> listRegions() {
        List<Region> regions = Location.allRegions();
        return RegionDTOAssembler.ASSEMBLER.toDTOList(regions);
    }

    @Nonnull
    @Override
    public List<StateDTO> listStates() {
        List<State> states = Location.allStates(null);
        return StateDTOAssembler.ASSEMBLER.toDTOList(states);
    }

    @Nonnull
    @Override
    public List<StateDTO> listStates(Integer regionCode) {
        List<State> states = Location.getStates(regionCode, null);
        return StateDTOAssembler.ASSEMBLER.toDTOList(states);
    }

    @Nonnull
    @Override
    public List<CityDTO> listCities(Integer stateCode) {
        List<City> cities = Location.getCities(stateCode, null);
        return CityDTOAssembler.ASSEMBLER.toDTOList(cities);
    }

    @Nonnull
    @Override
    public List<CountyDTO> listCounties(Integer cityCode) {
        List<County> counties = Location.getCounties(cityCode, null);
        return CountyDTOAssembler.ASSEMBLER.toDTOList(counties);
    }
}
