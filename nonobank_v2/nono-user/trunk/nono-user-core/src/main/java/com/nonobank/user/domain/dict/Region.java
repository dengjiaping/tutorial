/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) Region.java 2014-10-16 09:06
 */

package com.nonobank.user.domain.dict;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * 表示一个较大的区域（不限范围）。例如：中国华东区、华北区等。
 *
 * @author fuchun
 * @version $Id: Region.java 180 2014-10-16 02:16:55Z fuchun $
 * @since 2.0
 */
public interface Region extends Area {

    Integer NORTH_CHINA = 1000;

    Integer NORTHEAST_CHINA = 2000;

    Integer EAST_CHINA = 3000;

    Integer CENTRAL_CHINA = 4000;

    Integer SOUTHERN_CHINA = 5000;

    Integer SOUTHWEST_CHINA = 6000;

    Integer NORTHWEST_CHINA = 7000;

    List<Integer> REGION_CODES_CHINA = ImmutableList.of(
            NORTH_CHINA, NORTHEAST_CHINA, EAST_CHINA, CENTRAL_CHINA,
            SOUTHERN_CHINA, SOUTHWEST_CHINA, NORTHWEST_CHINA
    );

    /**
     * 返回区域包含的省份（州）。
     */
    public List<State> getStates();
}