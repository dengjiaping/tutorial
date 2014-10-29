/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserCriminalRepository.java 2014-10-29 15:00
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.data.repository.support.QueryDsl;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.UserCriminal;
import com.nonobank.user.domain.repository.ext.UserCriminalRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import java.util.List;

import static com.nonobank.user.domain.ext.QUserCriminal.quc;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
@Repository("userCriminalRepository")
public class JdbcUserCriminalRepository
        extends QueryDslJdbcRepository<UserCriminal, Long>
        implements UserCriminalRepository {

    public JdbcUserCriminalRepository() {
        super(quc);
    }

    @PostConstruct
    public void initialize() {

    }

    @Nonnull
    @Override
    public List<UserCriminal> findByUserId(Long userId, @Nullable Sort sort) {
        return findAll(quc.userId.eq(userId), QueryDsl.toOrders(quc, sort));
    }
}
