/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserOptionRepository.java 2014-10-16 14:46
 */

package com.nonobank.user.base.jdbc.core;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.core.QUserOption;
import com.nonobank.user.domain.core.UserOption;
import com.nonobank.user.domain.repository.core.UserOptionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The JDBC based on implementation of the {@code UserOptionRepository}.
 *
 * @author fuchun
 * @version $Id: JdbcUserOptionRepository.java 189 2014-10-16 07:20:25Z fuchun $
 * @since 2.0
 */
@Repository("userOptionRepository")
public class JdbcUserOptionRepository extends QueryDslJdbcRepository<UserOption, Long>
        implements UserOptionRepository {

    public JdbcUserOptionRepository() {
        super(QUserOption.qOpt);
    }

    // 禁止调用查询全部信息（数据量会非常大）
    @Override
    public List<UserOption> findAll() {
        throw new UnsupportedOperationException("Forbidden to invoke this method!");
    }

    // 禁止调用查询全部信息（数据量会非常大）
    @Override
    public List<UserOption> findAll(Sort sort) {
        throw new UnsupportedOperationException("Forbidden to invoke this method!");
    }
}
