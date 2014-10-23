/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) AbstractArea.java 2014-10-21 12:25
 */

package com.nonobank.user.facade.dto.dict;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * The DTO of the {@code Area}.
 *
 * @author fuchun
 * @version $Id: AbstractArea.java 233 2014-10-21 09:13:58Z fuchun $
 * @since 2.0
 */
public class AbstractArea implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer id;
    private final Integer code;
    private final String name;

    public AbstractArea(Integer id, Integer code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(getClass())
                .add("id", getId())
                .add("code", getCode())
                .add("name", getName());
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }
}
