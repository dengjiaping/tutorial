/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcEmailVerifySourceRepository.java 2014-10-13 15:22
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
 * @version $Id: JdbcEmailVerifySourceRepository.java 142 2014-10-13 07:30:32Z yichuan $
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
