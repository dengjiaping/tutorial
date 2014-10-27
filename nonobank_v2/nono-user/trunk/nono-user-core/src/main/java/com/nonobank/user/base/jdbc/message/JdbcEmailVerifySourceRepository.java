/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcEmailVerifySourceRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.message;

import com.mysema.query.sql.ColumnMetadata;
import com.nonobank.data.domain.RecordStatus;
import com.nonobank.data.jdbc.types.EnumValueType;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.message.EmailVerifySource;
import com.nonobank.user.domain.repository.message.EmailVerifySourceRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.message.QEmailVerifySource.EMAIL_VERIFY_SOURCE_TABLE;
import static com.nonobank.user.domain.message.QEmailVerifySource.qevs;

/**
 * 验证类邮件数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcEmailVerifySourceRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Repository("emailVerifySourceRepository")
public class JdbcEmailVerifySourceRepository
        extends QueryDslJdbcRepository<EmailVerifySource, Long>
        implements EmailVerifySourceRepository {

    public JdbcEmailVerifySourceRepository() {
        super(qevs);
    }

    @PostConstruct
    public void initialize() {
        queryDslJdbcTemplate.registerColumnType(EMAIL_VERIFY_SOURCE_TABLE,
                ColumnMetadata.getName(qevs.status),
                new EnumValueType<>(RecordStatus.class));
    }
}
