/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) DefaultRegion.java 2014-10-22 09:58
 */

package com.nonobank.user.domain.dict;

import java.util.List;

/**
 * @author fuchun
 * @version $Id: DefaultRegion.java 237 2014-10-22 02:24:20Z fuchun $
 * @since 2.0
 */
public class DefaultRegion extends AbstractArea implements Region {

    private List<State> states;

    DefaultRegion(Integer id, Integer code, String fullName, String shortName) {
        super(id, code, fullName, shortName);
    }

    @Override
    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}