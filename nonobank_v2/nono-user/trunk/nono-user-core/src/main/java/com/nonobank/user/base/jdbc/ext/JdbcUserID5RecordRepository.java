/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserID5RecordRepository.java 2014-10-27 16:41
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
 * @version $Id: JdbcUserID5RecordRepository.java 289 2014-10-27 08:46:50Z fuchun $
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
