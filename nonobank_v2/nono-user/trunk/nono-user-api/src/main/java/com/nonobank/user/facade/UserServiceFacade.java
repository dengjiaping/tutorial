/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserServiceFacade.java 2014-10-28 09:19
 */

package com.nonobank.user.facade;

import com.nonobank.user.facade.dto.core.BaseUserModel;
import com.nonobank.user.facade.dto.core.UserAccountDTO;

import java.rmi.Remote;

/**
 * 用户系统服务接口。
 *
 * @author fuchun
 * @version $Id: UserServiceFacade.java 306 2014-10-30 02:54:16Z fuchun $
 * @since 2.0
 */
public interface UserServiceFacade extends Remote {

    public <T extends BaseUserModel> UserAccountDTO createUser(T userModel);
}
