/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserLoanInfoRepository.java 2014-10-14 14:40
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.UserLoanInfo;

/**
 * 用户借款资料数据查询接口
 *
 * @author Yichuan
 * @version $Id: UserLoanInfoRepository.java 159 2014-10-14 06:42:04Z yichuan $
 * @since 2.0
 */
public interface UserLoanInfoRepository extends QueryDslRepository<UserLoanInfo, Long> {
}