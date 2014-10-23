/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserAuthcRepository.java 2014-10-13 11:35
 */

package com.nonobank.user.base.jdbc.core;

import com.mysema.query.sql.ColumnMetadata;
import com.nonobank.data.jdbc.types.EnumValueType;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.core.AvatarAuthcStatus;
import com.nonobank.user.domain.core.UserAuthc;
import com.nonobank.user.domain.dict.UserDict;
import com.nonobank.user.domain.repository.core.UserAuthcRepository;
import com.nonobank.user.domain.types.DictType;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.core.QUserAuthc.USER_AUTHC_TABLE;
import static com.nonobank.user.domain.core.QUserAuthc.quac;

/**
 * The JDBC base on implementation of the {@code UserAuthcRepository}.
 *
 * @author Yichuan
 * @version $Id: JdbcUserAuthcRepository.java 128 2014-10-13 03:53:10Z yichuan $
 * @since 2.0
 */
@Repository("userAuthcRepository")
public class JdbcUserAuthcRepository
        extends QueryDslJdbcRepository<UserAuthc, Long>
        implements UserAuthcRepository {

    public JdbcUserAuthcRepository() {
        super(quac);
    }

    @PostConstruct
    public void initialize() {
        queryDslJdbcTemplate.registerColumnType(
                USER_AUTHC_TABLE, ColumnMetadata.getName(quac.education),
                new DictType(UserDict.EDUCATION));
        queryDslJdbcTemplate.registerColumnType(
                USER_AUTHC_TABLE,
                ColumnMetadata.getName(quac.avatarStatus),
                new EnumValueType<>(AvatarAuthcStatus.class));
    }
}
