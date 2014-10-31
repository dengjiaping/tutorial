/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserServiceFacadeImpl.java 2014-10-28 09:22
 */

package com.nonobank.user.facade.impl;

import com.nonobank.user.facade.UserServiceFacade;
import com.nonobank.user.facade.dto.core.BaseUserModel;
import com.nonobank.user.facade.dto.core.UserAccountDTO;
import org.springframework.stereotype.Component;

/**
 *
 *
 * @author fuchun
 * @version $Id: UserServiceFacadeImpl.java 307 2014-10-30 03:04:06Z fuchun $
 * @since 2.0
 */
@Component("userServiceFacade")
public class UserServiceFacadeImpl implements UserServiceFacade {

    @Override
    public <T extends BaseUserModel> UserAccountDTO createUser(T userModel) {
        return null;
    }
}