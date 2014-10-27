/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserUploadRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.ext;

import com.mysema.query.sql.ColumnMetadata;
import com.nonobank.data.jdbc.types.EnumValueType;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.UserUpload;
import com.nonobank.user.domain.ext.common.UploadAuditStatus;
import com.nonobank.user.domain.repository.ext.UserUploadRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.ext.QUserUpload.USER_UPLOAD_TABLE;
import static com.nonobank.user.domain.ext.QUserUpload.quu;

/**
 * 用户上传数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcUserUploadRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Repository("userUploadRepository")
public class JdbcUserUploadRepository
        extends QueryDslJdbcRepository<UserUpload, Long>
        implements UserUploadRepository {

    public JdbcUserUploadRepository() {
        super(quu);
    }

    @PostConstruct
    public void initialize() {
        queryDslJdbcTemplate.registerColumnType(
                USER_UPLOAD_TABLE,
                ColumnMetadata.getName(quu.auditStatus),
                new EnumValueType<>(UploadAuditStatus.class)
        );
    }
}
