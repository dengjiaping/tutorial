/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcUserEducationRepository.java 2014-10-13 14:38
 */

package com.nonobank.user.base.jdbc.ext;

import com.mysema.query.sql.ColumnMetadata;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.dict.UserDict;
import com.nonobank.user.domain.ext.UserEducation;
import com.nonobank.user.domain.repository.ext.UserEducationRepository;
import com.nonobank.user.domain.types.DictType;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

import static com.nonobank.user.domain.ext.QUserEducation.USER_EDUCATION_TABLE;
import static com.nonobank.user.domain.ext.QUserEducation.que;

/**
 * 用户教育经历数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcUserEducationRepository.java 137 2014-10-13 06:43:57Z yichuan $
 * @since 2.0
 */
@Repository("userEducationRepository")
public class JdbcUserEducationRepository
        extends QueryDslJdbcRepository<UserEducation, Long>
        implements UserEducationRepository {

    public JdbcUserEducationRepository() {
        super(que);
    }

    @PostConstruct
    public void initialize() {
        queryDslJdbcTemplate.registerColumnType(USER_EDUCATION_TABLE,
                ColumnMetadata.getName(que.education),
                new DictType(UserDict.EDUCATION));
    }
}
