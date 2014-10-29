/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserService.java 2014-10-27 16:41
 */

package com.nonobank.user.service;

import com.nonobank.user.domain.core.UserAccount;
import org.springframework.util.MultiValueMap;

/**
 * 用户帐号业务接口。
 *
 * @author Yichuan
 * @version $Id: UserService.java 298 2014-10-29 03:05:00Z fuchun $
 * @since 2.0
 */
public interface UserService {

    public UserAccount newUser(MultiValueMap<String, String> valueMap);
}
