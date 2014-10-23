/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) County.java 2014-10-15 10:36
 */

package com.nonobank.user.domain.dict;

import javax.annotation.Nullable;

/**
 * 县（区）接口。
 *
 * @author fuchun
 * @version $Id: County.java 179 2014-10-16 01:05:35Z fuchun $
 * @since 2.0
 */
public interface County extends Area {

    /**
     * 所属城市的id。
     */
    public Integer getCityId();

    /**
     * 返回县（区）所属的城市。
     */
    @Nullable
    public City getCity();
}