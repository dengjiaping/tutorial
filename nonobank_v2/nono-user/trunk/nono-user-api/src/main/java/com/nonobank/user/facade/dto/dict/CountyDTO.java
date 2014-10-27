/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) CountyDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.dict;

/**
 * The DTO of the {@code County} "entity".
 *
 * @author fuchun
 * @version $Id: CountyDTO.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class CountyDTO extends AbstractArea {

    private static final long serialVersionUID = -2477143577061783960L;

    private final Integer cityId;

    public CountyDTO(Integer id, Integer code, String name, Integer cityId) {
        super(id, code, name);
        this.cityId = cityId;
    }

    public Integer getCityId() {
        return cityId;
    }

    @Override
    public String toString() {
        return toStringHelper().add("cityId", getCityId()).toString();
    }
}
