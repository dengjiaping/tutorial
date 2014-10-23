/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) DelegatingRegion.java 2014-10-16 09:07
 */

package com.nonobank.user.domain.dict;

import java.util.List;

/**
 * The {@code Region} default implementation.
 *
 * @author fuchun
 * @version $Id: DelegatingRegion.java 237 2014-10-22 02:24:20Z fuchun $
 * @since 2.0
 */
public class DelegatingRegion extends DelegatingArea implements Region {

    private static final long serialVersionUID = -8158291226562029550L;

    public static DelegatingRegion of(Location location) {
        return new DelegatingRegion(location);
    }

    private List<State> states;

    protected DelegatingRegion(Location location) {
        super(location);
    }

    @Override
    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DelegatingRegion)) return false;

        DelegatingRegion that = (DelegatingRegion) o;

        return !(states != null ? !states.equals(that.states) : that.states != null);

    }

    @Override
    public int hashCode() {
        int result = 31 + (location != null ? location.hashCode() : 0);
        result = result + 31 * (states != null ? states.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("DefaultRegion{location=%s}", location);
    }
}
