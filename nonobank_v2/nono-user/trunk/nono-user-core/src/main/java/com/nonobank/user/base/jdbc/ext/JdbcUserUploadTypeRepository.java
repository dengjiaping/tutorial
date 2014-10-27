/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserUploadTypeRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.UserUploadType;
import com.nonobank.user.domain.repository.ext.UserUploadTypeRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.ext.QUserUploadType.quut;

/**
 * 用户上传类型数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcUserUploadTypeRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Repository("userUploadTypeRepository")
public class JdbcUserUploadTypeRepository
        extends QueryDslJdbcRepository<UserUploadType, Long>
        implements UserUploadTypeRepository {

    public JdbcUserUploadTypeRepository() {
        super(quut);
    }

    @PostConstruct
    public void initialize() {

    }
}
