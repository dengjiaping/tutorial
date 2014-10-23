/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CityDTO.java 2014-10-21 12:31
 */

package com.nonobank.user.facade.dto.dict;

import java.util.List;

/**
 * The DTO of the {@code City} "entity".
 *
 * @author fuchun
 * @version $Id: CityDTO.java 233 2014-10-21 09:13:58Z fuchun $
 * @since 2.0
 */
public class CityDTO extends AbstractArea {

    private static final long serialVersionUID = 4644496737910729979L;

    private final Integer stateId;
    private List<CountyDTO> counties;

    public CityDTO(Integer id, Integer code, String name, Integer stateId) {
        super(id, code, name);
        this.stateId = stateId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public List<CountyDTO> getCounties() {
        return counties;
    }

    public void setCounties(List<CountyDTO> counties) {
        this.counties = counties;
    }

    @Override
    public String toString() {
        return toStringHelper()
                .add("stateId", getStateId())
                .add("counties", getCounties()).toString();
    }
}
