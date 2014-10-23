/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserFieldRepository.java 2014-10-16 15:26
 */

package com.nonobank.user.base.jdbc.ext;

import com.mysema.query.sql.ColumnMetadata;
import com.nonobank.data.jdbc.types.EnumValueType;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.UserField;
import com.nonobank.user.domain.ext.common.VerifyMode;
import com.nonobank.user.domain.repository.ext.UserFieldRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.ext.QUserField.USER_FIELD_TABLE;
import static com.nonobank.user.domain.ext.QUserField.quf;

/**
 * 用户属性数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcUserFieldRepository.java 190 2014-10-16 08:17:43Z yichuan $
 * @since 2.0
 */
@Repository("userFieldRepository")
public class JdbcUserFieldRepository
        extends QueryDslJdbcRepository<UserField, Long>
        implements UserFieldRepository {

    public JdbcUserFieldRepository() {
        super(quf);
    }

    @PostConstruct
    public void initialize() {
        queryDslJdbcTemplate.registerColumnType(USER_FIELD_TABLE,
                ColumnMetadata.getName(quf.verifyMode),
                new EnumValueType<>(VerifyMode.class));
    }
}
