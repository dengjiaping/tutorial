/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserID5RecordRepository.java 2014-10-17 17:31
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.UserID5Record;
import com.nonobank.user.domain.repository.ext.UserID5RecordRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.ext.QUserID5Record.quir;

/**
 * 国政通(第三方)验证记录数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcUserID5RecordRepository.java 208 2014-10-17 09:36:17Z yichuan $
 * @since 2.0
 */
@Repository("userId5RecordRepository")
public class JdbcUserID5RecordRepository
        extends QueryDslJdbcRepository<UserID5Record, Long>
        implements UserID5RecordRepository {

    public JdbcUserID5RecordRepository() {
        super(quir);
    }

    @PostConstruct
    public void initialize() {

    }
}
