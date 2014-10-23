/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) DefaultBoundUserOption.java 2014-10-16 15:10
 */

package com.nonobank.user.domain.core;

import com.nonobank.user.domain.ctx.UserCmdContext;

import java.util.List;

/**
 * @author fuchun
 * @version $Id: DefaultBoundUserOption.java 196 2014-10-16 08:54:06Z fuchun $
 * @since 2.0
 */
class DefaultBoundUserOption implements BoundUserOption {

    private final Long userId;

    public DefaultBoundUserOption(Long userId) {
        this.userId = userId;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public List<UserOption> options() {
        return UserCmdContext.userOptionRepository()
                .findByUserIdOrderByKeyASC(userId);
    }

    @Override
    public UserOption getOption(String key) {
        return UserCmdContext.userOptionRepository()
                .findByUserIdAndKey(userId, key);
    }
}
