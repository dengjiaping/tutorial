/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) BankDTO.java 2014-10-22 10:33
 */

package com.nonobank.user.facade.dto.dict;

import java.io.Serializable;

/**
 * @author fuchun
 * @version $Id: BankDTO.java 240 2014-10-22 03:27:19Z fuchun $
 * @since 2.0
 */
public class BankDTO implements Serializable {

    private static final long serialVersionUID = 2806350539309677528L;

    private final Integer id;
    private final String name;
    private final Integer locCode;
    private final Integer parentId;

    public BankDTO(Integer id, String name, Integer locCode, Integer parentId) {
        this.id = id;
        this.name = name;
        this.locCode = locCode;
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getLocCode() {
        return locCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    @Override
    public String toString() {
        return String.format("BankDTO{id=%d, name='%s', locCode=%d, parentId=%d}",
                id, name, locCode, parentId);
    }
}