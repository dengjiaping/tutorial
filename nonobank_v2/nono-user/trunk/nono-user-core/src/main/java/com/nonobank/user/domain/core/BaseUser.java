/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) BaseUser.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nonobank.data.domain.AbstractRecording;

/**
 * 用户信息实体的基本类。
 * <p/>
 * 包含{@code userId}、{@code lastModifiedDate} 和{@code createdDate} 属性。
 *
 * @author fuchun
 * @version $Id: BaseUser.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public abstract class BaseUser<T extends BaseUser<T>> extends AbstractRecording<Long, T> {

    private static final long serialVersionUID = -2581959084169113105L;

    private Long userId;

    @Override
    @JsonIgnore
    public Long getId() {
        return userId;
    }

    @Override
    public void setId(Long id) {
        setUserId(id);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
