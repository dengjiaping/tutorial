/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserAccountRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.core;

import com.mysema.query.sql.ColumnMetadata;
import com.nonobank.data.jdbc.types.EnumValueType;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.core.QUserAccount;
import com.nonobank.user.domain.core.UserAccount;
import com.nonobank.user.domain.core.UserStatus;
import com.nonobank.user.domain.repository.core.UserAccountRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.core.QUserAccount.qua;

/**
 * The JDBC base on implementation of the {@code UserAccountRepository}.
 *
 * @author fuchun
 * @version $Id$
 * @since 2.0
 */
@Repository("userAccountRepository")
public class JdbcUserAccountRepository extends QueryDslJdbcRepository<UserAccount, Long>
        implements UserAccountRepository {

    public JdbcUserAccountRepository() {
        super(qua);
    }

    @PostConstruct
    public void initialize() {
        // register UserStatus <=> short(tinyint) type mapping on UserAccount table
        queryDslJdbcTemplate.registerColumnType(
                QUserAccount.USER_ACCOUNT_TABLE,
                ColumnMetadata.getName(qua.status),
                new EnumValueType<>(UserStatus.class));
    }
}
