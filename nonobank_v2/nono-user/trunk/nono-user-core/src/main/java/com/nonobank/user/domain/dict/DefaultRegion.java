/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) DefaultRegion.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.dict;

import java.util.List;

/**
 * @author fuchun
 * @version $Id: DefaultRegion.java 289 2014-10-27 08:46:50Z fuchun $
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
