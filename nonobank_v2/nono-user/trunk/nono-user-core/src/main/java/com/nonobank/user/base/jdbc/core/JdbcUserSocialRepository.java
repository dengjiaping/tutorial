/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserSocialRepository.java 2014-10-11 17:24
 */

package com.nonobank.user.base.jdbc.core;

import com.mysema.query.sql.ColumnMetadata;
import com.mysema.query.sql.types.EnumByNameType;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.core.QUserSocial;
import com.nonobank.user.domain.core.SocialSource;
import com.nonobank.user.domain.core.UserSocial;
import com.nonobank.user.domain.repository.core.UserSocialRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.core.QUserSocial.qus;

/**
 * The JDBC base on implementation of the {@code UserSocialRepository}.
 *
 * @author fuchun
 * @version $Id$
 * @since 2.0
 */
@Repository("userSocialRepository")
public class JdbcUserSocialRepository extends QueryDslJdbcRepository<UserSocial, Long>
        implements UserSocialRepository {

    public JdbcUserSocialRepository() {
        super(qus);
    }

    @PostConstruct
    public void initialize() {
        // register SocialSource <=> String type mapping on "USER_SOURCE" table.
        queryDslJdbcTemplate.registerColumnType(
                QUserSocial.USER_SOCIAL_TABLE,
                ColumnMetadata.getName(qus.socialSource),
                new EnumByNameType<>(SocialSource.class));
    }
}