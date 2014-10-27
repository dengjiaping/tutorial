/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) DictDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.dict;

import java.io.Serializable;

/**
 * The {@code Dict} data transform object.
 *
 * @author fuchun
 * @version $Id: DictDTO.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class DictDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String code;
    private final String name;
    private final Integer order;

    public DictDTO(String code, String name, Integer order) {
        this.code = code;
        this.name = name;
        this.order = order;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return String.format("DictDTO{code='%s', name='%s', order=%d}",
                getCode(), getName(), getOrder());
    }
}
