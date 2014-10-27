/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserProfileMeta.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nonobank.data.domain.AbstractEntityMeta;

/**
 * 用户基本信息扩展实体。
 *
 * @author fuchun
 * @version $Id: UserProfileMeta.java 289 2014-10-27 08:46:50Z fuchun $
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
