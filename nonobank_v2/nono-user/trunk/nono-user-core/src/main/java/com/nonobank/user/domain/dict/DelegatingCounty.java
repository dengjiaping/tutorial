/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) DelegatingCounty.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.dict;

import java.io.Serializable;

/**
 * {@code County} 的默认实现。
 *
 * @author fuchun
 * @version $Id: DelegatingCounty.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class DelegatingCounty extends DelegatingArea implements County, Serializable {

    private static final long serialVersionUID = -107589772852710813L;

    public static DelegatingCounty of(Location location) {
        return new DelegatingCounty(location);
    }

    private City city;

    protected DelegatingCounty(Location location) {
        super(location);
    }

    @Override
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public Integer getCityId() {
        return location.getParentId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DelegatingCounty)) return false;

        DelegatingCounty that = (DelegatingCounty) o;

        return !(location != null ? !location.equals(that.location) : that.location != null) &&
                city != null ? !city.equals(that.city) : that.city != null;

    }

    @Override
    public int hashCode() {
        int result = 31 + (location != null ? location.hashCode() : 0);
        result = result + 31 * (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("DelegatingCounty{location=%s}", location);
    }
}
