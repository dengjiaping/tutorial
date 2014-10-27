/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserEducationRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.ext;

import com.mysema.query.sql.ColumnMetadata;
import com.nonobank.data.repository.support.QueryDsl;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.dict.UserDict;
import com.nonobank.user.domain.ext.UserEducation;
import com.nonobank.user.domain.repository.ext.UserEducationRepository;
import com.nonobank.user.domain.types.DictType;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import java.util.List;

import static com.nonobank.user.domain.ext.QUserEducation.USER_EDUCATION_TABLE;
import static com.nonobank.user.domain.ext.QUserEducation.que;

/**
 * 用户教育经历数据查询接口
 *
 * @author Yichuan
 * @version $Id: JdbcUserEducationRepository.java 289 2014-10-27 08:46:50Z fuchun $
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

    @Nonnull
    @Override
    public List<UserEducation> findByUserId(Long userId, @Nullable Sort sort) {
        return findAll(que.userId.eq(userId), QueryDsl.toOrders(que, sort));
    }
}
