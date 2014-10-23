/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserUploadTypeRepository.java 2014-10-20 14:22
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
 * @version $Id: JdbcUserUploadTypeRepository.java 219 2014-10-20 06:48:31Z yichuan $
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