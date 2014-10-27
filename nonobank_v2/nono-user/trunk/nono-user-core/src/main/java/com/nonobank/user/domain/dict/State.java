/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) State.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.dict;

import javax.annotation.Nullable;
import java.util.List;

/**
 * 省（州）信息接口。例如：中国的省、美国的州。
 *
 * @author fuchun
 * @version $Id: State.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface State extends Area {

    /**
     * Empty state instance.
     */
    State EMPTY_STATE = new EmptyState();

    /**
     * 区域Id。
     */
    public Integer getRegionId();

    /**
     * 省（州）下的所有城市信息。
     */
    @Nullable
    public List<City> getCities();

    class EmptyState implements State {

        @Override
        public Integer getRegionId() {
            return null;
        }

        @Nullable
        @Override
        public List<City> getCities() {
            return null;
        }

        @Override
        public Integer getId() {
            return null;
        }

        @Override
        public Integer getCode() {
            return null;
        }

        @Override
        public String getFullName() {
            return null;
        }

        @Override
        public String getShortName() {
            return null;
        }
    }
}
