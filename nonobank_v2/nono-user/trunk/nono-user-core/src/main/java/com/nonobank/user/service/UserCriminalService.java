/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserCriminalService.java 2014-10-29 15:08
 */

package com.nonobank.user.service;

import com.nonobank.user.domain.ext.UserCriminal;

import java.util.List;

/**
 * @author Yichuan
 * @version $Id: UserCriminalService.java 300 2014-10-29 08:32:39Z yichuan $
 * @since 2.0
 */
public interface UserCriminalService {

    public List<UserCriminal> findByUserId(Long userId);
}
