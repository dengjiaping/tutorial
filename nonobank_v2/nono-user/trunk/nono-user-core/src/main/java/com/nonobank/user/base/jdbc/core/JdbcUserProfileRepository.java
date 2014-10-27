/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserProfileRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.core;

import com.mysema.query.sql.ColumnMetadata;
import com.mysema.query.types.Path;
import com.nonobank.common.base.Gender;
import com.nonobank.data.jdbc.types.EnumValueType;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.core.UserProfile;
import com.nonobank.user.domain.dict.Exist;
import com.nonobank.user.domain.dict.UserDict;
import com.nonobank.user.domain.repository.core.UserProfileRepository;
import com.nonobank.user.domain.types.DictType;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.core.QUserProfile.USER_PROFILE_TABLE;
import static com.nonobank.user.domain.core.QUserProfile.qup;

/**
 * The JDBC based on implementation of the {@code UserProfileRepository}.
 *
 * @author fuchun
 * @version $Id$
 * @since 2.0
 */
@Repository("userProfileRepository")
public class JdbcUserProfileRepository extends QueryDslJdbcRepository<UserProfile, Long>
        implements UserProfileRepository {

    public JdbcUserProfileRepository() {
        super(qup);
    }

    @PostConstruct
    public void initialize() {

        registerDictColumnType(qup.marriage, UserDict.MARRIAGE);
        registerDictColumnType(qup.education, UserDict.EDUCATION);
        registerDictColumnType(qup.position, UserDict.POSITION);
        registerDictColumnType(qup.skillCert, UserDict.SKILL_CERT);

        queryDslJdbcTemplate.registerColumnType(
                USER_PROFILE_TABLE,
                ColumnMetadata.getName(qup.gender),
                EnumValueType.forString(Gender.class));

        registerExistColumnType(qup.socialSecurity);
        registerExistColumnType(qup.passport);
        registerExistColumnType(qup.driving);
    }

    private void registerDictColumnType(Path<?> path, String typeKey) {
        queryDslJdbcTemplate.registerColumnType(
                USER_PROFILE_TABLE,
                ColumnMetadata.getName(path),
                new DictType(typeKey));
    }

    private void registerExistColumnType(Path<?> path) {
        queryDslJdbcTemplate.registerColumnType(
                USER_PROFILE_TABLE,
                ColumnMetadata.getName(path),
                EnumValueType.forString(Exist.class));
    }
}
