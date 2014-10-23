/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserUploadItemRepository.java 2014-10-20 16:10
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.UserUploadItem;
import com.nonobank.user.domain.repository.ext.UserUploadItemRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.ext.QUserUploadItem.quui;

/**
 * 用户上传信息数据查询接口
 *
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
@Repository("userUploadItemRepository")
public class JdbcUserUploadItemRepository
        extends QueryDslJdbcRepository<UserUploadItem, Long>
        implements UserUploadItemRepository {

    public JdbcUserUploadItemRepository() {
        super(quui);
    }

    @PostConstruct
    public void initialize() {

    }
}
