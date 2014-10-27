/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EntityMeta.java 2014-10-27 16:48
 */

package com.nonobank.data.domain;

import java.io.Serializable;

/**
 * 实体元数据接口。用于扩展实体的属性，或额外的信息。
 *
 * @author fuchun
 * @version $Id: EntityMeta.java 291 2014-10-27 08:49:07Z fuchun $
 * @since 2.0
 */
public interface EntityMeta<ID extends Serializable & Comparable<ID>> extends Metadata {

    /**
     * 返回元数据关联的实体Id。
     */
    public ID getEntityId();
}
