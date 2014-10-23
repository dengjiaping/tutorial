/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) Metadata.java 2014-10-16 16:14
 */

package com.nonobank.data.domain;

/**
 * 元数据顶级接口。用于表示一对（K-V）键值，K 表示属性，V 表示属性值。
 *
 * @author fuchun
 * @version $Id: Metadata.java 194 2014-10-16 08:39:33Z fuchun $
 * @since 2.0
 */
public interface Metadata {

    /**
     * {@code metaKey} 属性名称。
     */
    String PROP_META_KEY = "metaKey";

    /**
     * {@code metaValue} 属性名称。
     */
    String PROP_META_VALUE = "metaValue";

    /**
     * 元数据的键名。
     */
    public String getMetaKey();

    /**
     * 元数据的键值。
     */
    public String getMetaValue();
}
