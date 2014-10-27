/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) StateDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.dict;

import java.util.List;

/**
 * The DTO of the {@code State} "entity".
 *
 * @author fuchun
 * @version $Id: StateDTO.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class StateDTO extends AbstractArea {

    private static final long serialVersionUID = -4868870144946413137L;

    private final Integer regionId;
    private List<CityDTO> cities;

    public StateDTO(Integer id, Integer code, String name, Integer regionId) {
        super(id, code, name);
        this.regionId = regionId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public void setCities(List<CityDTO> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return toStringHelper()
                .add("regionId", getRegionId())
                .add("cities", getCities()).toString();
    }
}
