/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) Area.java 2014-10-15 10:30
 */

package com.nonobank.user.domain.dict;

/**
 * 表示一个地区、区域的顶级接口。
 *
 * @author fuchun
 * @version $Id: Area.java 179 2014-10-16 01:05:35Z fuchun $
 * @since 2.0
 */
public interface Area {

    /**
     * 地区Id。
     */
    public Integer getId();

    /**
     * 地区代码。
     */
    public Integer getCode();

    /**
     * 地区全名。
     */
    public String getFullName();

    /**
     * 地区短名称。
     */
    public String getShortName();
}
