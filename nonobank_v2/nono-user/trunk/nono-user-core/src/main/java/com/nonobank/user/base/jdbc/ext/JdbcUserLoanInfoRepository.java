/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserLoanInfoRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.UserLoanInfo;
import com.nonobank.user.domain.repository.ext.UserLoanInfoRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.ext.QUserLoanInfo.quld;

/**
 * 用户借款资料数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcUserLoanInfoRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Repository("userLoanInfoRepository")
public class JdbcUserLoanInfoRepository
        extends QueryDslJdbcRepository<UserLoanInfo, Long>
        implements UserLoanInfoRepository {

    public JdbcUserLoanInfoRepository() {
        super(quld);
    }

    @PostConstruct
    public void initialize() {

    }
}
