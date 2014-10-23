/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserStatsRepository.java 2014-10-17 09:44
 */

package com.nonobank.user.domain.repository.core;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.core.UserStats;

/**
 * 用户关键数据查询接口
 *
 * @author Yichuan
 * @version $Id: UserStatsRepository.java 197 2014-10-17 01:50:40Z yichuan $
 * @since 2.0
 */
public interface UserStatsRepository extends QueryDslRepository<UserStats, Long> {

}
