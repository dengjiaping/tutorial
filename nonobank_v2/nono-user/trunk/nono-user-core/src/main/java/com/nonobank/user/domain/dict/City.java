/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) City.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.dict;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 城市接口。
 *
 * @author fuchun
 * @version $Id: City.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface City extends Area {

    /**
     * 所属省（州）份的id。
     */
    public Integer getStateId();

    /**
     * 返回城市所属的省（州）。
     */
    @Nullable
    public State getState();

    /**
     * 城市下属所有县（区）信息列表。
     */
    @Nullable
    public List<County> getCounties();
}