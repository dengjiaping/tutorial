/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) DelegatingArea.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.dict;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * {@code Area} 的委托实现。
 *
 * @author fuchun
 * @version $Id: DelegatingArea.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public abstract class DelegatingArea implements Area, Serializable {

    private static final long serialVersionUID = 1L;

    protected Location location;

    protected DelegatingArea(Location location) {
        this.location = location;
    }

    @Override
    public Integer getId() {
        return location.getId();
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

    /**
     * 返回实际的{@code Location}。
     */
    @JsonIgnore
    public Location getLocation() {
        return location;
    }
}
