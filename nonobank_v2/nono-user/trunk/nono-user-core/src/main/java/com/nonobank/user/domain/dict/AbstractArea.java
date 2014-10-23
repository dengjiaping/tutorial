/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) AbstractArea.java 2014-10-22 09:51
 */

package com.nonobank.user.domain.dict;

/**
 * @author fuchun
 * @version $Id: AbstractArea.java 237 2014-10-22 02:24:20Z fuchun $
 * @since 2.0
 */
public abstract class AbstractArea implements Area {

    private final Integer id;
    private final Integer code;
    private final String fullName;
    private final String shortName;

    protected AbstractArea(Integer id, Integer code, String fullName, String shortName) {
        this.id = id;
        this.code = code;
        this.fullName = fullName;
        this.shortName = shortName;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getShortName() {
        return shortName;
    }
}
