/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserCmdContext.java 2014-10-16 14:51
 */

package com.nonobank.user.domain.ctx;

import com.nonobank.user.domain.repository.core.*;

/**
 * 用户核心领域上下文。
 *
 * @author fuchun
 * @version $Id: UserCmdContext.java 189 2014-10-16 07:20:25Z fuchun $
 * @since 2.0
 */
public final class UserCmdContext {

    private static final UserCmdContext CONTEXT = new UserCmdContext();

    public static UserCmdContext getContext() {
        return CONTEXT;
    }

    public static UserAccountRepository userAccountRepository() {
        return CONTEXT.userAccountRepository;
    }

    public static UserAuthcRepository userAuthcRepository() {
        return CONTEXT.userAuthcRepository;
    }

    public static UserOptionRepository userOptionRepository() {
        return CONTEXT.userOptionRepository;
    }

    public static UserProfileRepository userProfileRepository() {
        return CONTEXT.userProfileRepository;
    }

    public static UserSocialRepository userSocialRepository() {
        return CONTEXT.userSocialRepository;
    }

    private UserAccountRepository userAccountRepository;
    private UserAuthcRepository userAuthcRepository;
    private UserOptionRepository userOptionRepository;
    private UserProfileRepository userProfileRepository;
    private UserSocialRepository userSocialRepository;

    private UserCmdContext() {}

    public void setUserAccountRepository(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public void setUserAuthcRepository(UserAuthcRepository userAuthcRepository) {
        this.userAuthcRepository = userAuthcRepository;
    }

    public void setUserOptionRepository(UserOptionRepository userOptionRepository) {
        this.userOptionRepository = userOptionRepository;
    }

    public void setUserProfileRepository(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public void setUserSocialRepository(UserSocialRepository userSocialRepository) {
        this.userSocialRepository = userSocialRepository;
    }
}
