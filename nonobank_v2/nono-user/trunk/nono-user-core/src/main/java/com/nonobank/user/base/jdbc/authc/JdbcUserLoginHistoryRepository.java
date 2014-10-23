/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserLoginHistoryRepository.java 2014-10-13 14:29
 */

package com.nonobank.user.base.jdbc.authc;

import com.mysema.query.sql.ColumnMetadata;
import com.mysema.query.sql.types.EnumByNameType;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.authc.UserDevice;
import com.nonobank.user.domain.authc.UserLoginHistory;
import com.nonobank.user.domain.repository.authc.UserLoginHistoryRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.authc.QUserLoginHistory.USER_LOGIN_HISTORY_TABLE;
import static com.nonobank.user.domain.authc.QUserLoginHistory.qulh;

/**
 * The JDBC based on implementation of the {@code UserLoginHistoryRepository}.
 *
 * @author fuchun
 * @version $Id$
 * @since 2.0
 */
@Repository("userLoginHistoryRepository")
public class JdbcUserLoginHistoryRepository extends QueryDslJdbcRepository<UserLoginHistory, Long>
        implements UserLoginHistoryRepository {

    public JdbcUserLoginHistoryRepository() {
        super(qulh);
    }

    @PostConstruct
    public void initialize() {
        // register UserDevice <=> varchar(string) mapping on UserLoginHistory table
        queryDslJdbcTemplate.registerColumnType(
                USER_LOGIN_HISTORY_TABLE,
                ColumnMetadata.getName(qulh.device),
                new EnumByNameType<>(UserDevice.class));
    }
}
