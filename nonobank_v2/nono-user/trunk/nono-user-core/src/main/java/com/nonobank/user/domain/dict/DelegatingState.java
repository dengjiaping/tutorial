/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) DefaultProvince.java 2014-10-14 12:50
 */

package com.nonobank.user.domain.dict;

import java.io.Serializable;
import java.util.List;

/**
 * The delegating implementation of the {@code State}.
 *
 * @author fuchun
 * @version $Id: DelegatingState.java 237 2014-10-22 02:24:20Z fuchun $
 * @since 2.0
 */
public class DelegatingState extends DelegatingArea implements State, Serializable {

    private static final long serialVersionUID = 5198881805323815371L;

    public static DelegatingState of(Location location) {
        return new DelegatingState(location);
    }

    private List<City> cities;

    protected DelegatingState(Location location) {
        super(location);
    }

    @Override
    public Integer getRegionId() {
        return location.getParentId();
    }

    @Override
    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DelegatingState)) return false;

        DelegatingState that = (DelegatingState) o;

        return !(location != null ? !location.equals(that.location) : that.location != null);

    }

    @Override
    public int hashCode() {
        int value = 31 * getClass().hashCode();
        value += value * 31 + (location != null ? location.hashCode() : 0);
        return value;
    }

    @Override
    public String toString() {
        return String.format("DefaultProvince{location=%s}", location);
    }
}