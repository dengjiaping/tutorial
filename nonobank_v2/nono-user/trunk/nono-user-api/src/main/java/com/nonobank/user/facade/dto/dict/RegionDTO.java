/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) RegionDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.dict;

import java.util.List;

/**
 * The DTO of the {@code Region} "entity".
 *
 * @author fuchun
 * @version $Id: RegionDTO.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class RegionDTO extends AbstractArea {

    private static final long serialVersionUID = -7214544343747279583L;

    private List<StateDTO> states;

    public RegionDTO(Integer id, Integer code, String name) {
        super(id, code, name);
    }

    public List<StateDTO> getStates() {
        return states;
    }

    public void setStates(List<StateDTO> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return toStringHelper().add("states", getStates()).toString();
    }
}
