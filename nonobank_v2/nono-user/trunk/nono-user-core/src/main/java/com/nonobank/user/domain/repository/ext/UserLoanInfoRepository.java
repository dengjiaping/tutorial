/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserLoanInfoRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.UserLoanInfo;

/**
 * 用户借款资料数据查询接口
 *
 * @author Yichuan
 * @version $Id: UserLoanInfoRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface UserLoanInfoRepository extends QueryDslRepository<UserLoanInfo, Long> {
}
