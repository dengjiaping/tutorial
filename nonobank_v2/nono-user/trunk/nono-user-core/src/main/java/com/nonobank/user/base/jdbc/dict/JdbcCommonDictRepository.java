/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcCommonDictRepository.java 2014-10-21 17:28
 */

package com.nonobank.user.base.jdbc.dict;

import com.google.common.collect.ImmutableList;
import com.nonobank.data.repository.support.QueryDsl;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.dict.CommonDict;
import com.nonobank.user.domain.dict.QCommonDict;
import com.nonobank.user.domain.repository.dict.CommonDictRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.nonobank.user.domain.dict.AbstractDict.PROP_CODE;
import static com.nonobank.user.domain.dict.AbstractDict.PROP_I18N_KEY;
import static com.nonobank.user.domain.dict.CommonDict.PROP_TYPE_KEY;
import static com.nonobank.user.domain.dict.QCommonDict.qcd;
import static java.util.Objects.requireNonNull;

/**
 * The JDBC based on implementation of the {@code CommonDictRepository}.
 *
 * @author Yichuan
 * @version $Id: JdbcCommonDictRepository.java 257 2014-10-23 06:33:13Z fuchun $
 * @since 2.0
 */
@Repository("commonDictRepository")
public class JdbcCommonDictRepository extends QueryDslJdbcRepository<CommonDict, Integer>
        implements CommonDictRepository {

    public JdbcCommonDictRepository() {
        super(QCommonDict.qcd);
    }

    @Nullable
    @Override
    public CommonDict findByTypeKeyAndCode(String typeKey, String code) {
        requireNonNull(typeKey, PROP_TYPE_KEY);
        requireNonNull(code, PROP_CODE);
        return findOne(qcd.typeKey.eq(typeKey).and(qcd.code.eq(code)));
    }

    @Nullable
    @Override
    public CommonDict findByTypeKeyAndI18nKey(String typeKey, String i18nKey) {
        requireNonNull(typeKey, PROP_TYPE_KEY);
        requireNonNull(i18nKey, PROP_I18N_KEY);
        return findOne(qcd.typeKey.eq(typeKey).and(qcd.i18nKey.eq(i18nKey)));
    }

    @Nonnull
    @Override
    public ImmutableList<CommonDict> findByTypeKey(String typeKey, @Nullable Sort sort) {
        requireNonNull(typeKey, PROP_TYPE_KEY);
        if (typeKey.trim().length() == 0) {
            return ImmutableList.of();
        }
        return ImmutableList.copyOf(
                findAll(qcd.typeKey.eq(typeKey), QueryDsl.toOrders(qcd, sort)));
    }
}
