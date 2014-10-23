/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserAuthcRepository.java 2014-10-13 11:31
 */

package com.nonobank.user.domain.repository.core;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.core.UserAuthc;

/**
 * {@code UserAuthc} entity repository.
 *
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public interface UserAuthcRepository extends QueryDslRepository<UserAuthc, Long> {
}