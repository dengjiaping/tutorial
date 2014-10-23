/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) DelegatingCity.java 2014-10-14 11:33
 */

package com.nonobank.user.domain.dict;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.List;

/**
 * The default implementation of the {@code City}。
 *
 * @author fuchun
 * @version $Id: DelegatingCity.java 237 2014-10-22 02:24:20Z fuchun $
 * @since 2.0
 */
public class DelegatingCity extends DelegatingArea implements City, Serializable {

    private static final long serialVersionUID = 476406143359876509L;

    public static DelegatingCity of(Location location) {
        return new DelegatingCity(location);
    }

    private volatile State state;
    private List<County> counties;

    protected DelegatingCity(Location location) {
        super(location);
    }

    @Override
    public Integer getCode() {
        return location.getCode();
    }

    @Override
    public String getFullName() {
        return location.getFullName();
    }

    @Override
    public String getShortName() {
        return location.getShortName();
    }

    @Override
    public Integer getStateId() {
        return location.getParentId();
    }

    @Override
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Nullable
    @Override
    public List<County> getCounties() {
        return counties;
    }

    public void setCounties(List<County> counties) {
        this.counties = counties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DelegatingCity)) {
            return false;
        }

        DelegatingCity that = (DelegatingCity) o;
        return !(location != null ? !location.equals(that.location) : that.location != null);

    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("DelegatingCity{location=%s}", location);
    }
}
