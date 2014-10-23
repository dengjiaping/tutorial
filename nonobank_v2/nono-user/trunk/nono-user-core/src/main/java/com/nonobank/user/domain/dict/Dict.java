/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) Dict.java 2014-10-10 16:13
 */

package com.nonobank.user.domain.dict;

import java.io.Serializable;

/**
 * 字典接口。
 *
 * @author fuchun
 * @version $Id: Dict.java 145 2014-10-13 09:34:53Z fuchun $
 * @since 2.0
 */
public interface Dict extends Serializable {

    /**
     * 返回属性编号（编码）
     */
    public String getCode();

    /**
     * 返回属性{@code i18n} 关键字。
     */
    public String getI18nKey();

    /**
     * 返回属性{@code name} 名称。通常是中文显示。
     */
    public String getName();

    /**
     * 排序序号。
     */
    public Integer getOrderNO();
}
