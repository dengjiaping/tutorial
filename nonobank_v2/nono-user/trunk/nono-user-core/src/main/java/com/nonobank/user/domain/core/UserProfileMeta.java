/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserProfileExt.java 2014-10-09 15:37
 */

package com.nonobank.user.domain.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nonobank.data.domain.AbstractEntityMeta;

/**
 * 用户基本信息扩展实体。
 *
 * @author fuchun
 * @version $Id: UserProfileMeta.java 196 2014-10-16 08:54:06Z fuchun $
 * @since 2.0
 */
public class UserProfileMeta extends AbstractEntityMeta<Long, UserProfileMeta> {

    private static final long serialVersionUID = -8581840284800919990L;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 用户Id。与{@link #getUserId()} 相同。
     */
    @Override
    @JsonIgnore
    public Long getEntityId() {
        return getUserId();
    }

    /**
     * 设置用户Id。与{@link #setUserId(Long)} 相同。
     *
     * @param entityId 用户Id。
     */
    @Override
    @JsonIgnore
    public void setEntityId(Long entityId) {
        setUserId(entityId);
    }

    @Override
    public String toString() {
        return toStringHelper(PROP_USER_ID).toString();
    }
}
