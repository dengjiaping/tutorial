/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcCommonDictRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.dict;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.nonobank.data.repository.query.BeanSort;
import com.nonobank.data.repository.support.QueryDsl;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.dict.CommonDict;
import com.nonobank.user.domain.dict.QCommonDict;
import com.nonobank.user.domain.repository.dict.CommonDictRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.nonobank.user.domain.dict.AbstractDict.PROP_CODE;
import static com.nonobank.user.domain.dict.AbstractDict.PROP_I18N_KEY;
import static com.nonobank.user.domain.dict.CommonDict.PROP_TYPE_KEY;
import static com.nonobank.user.domain.dict.QCommonDict.qcd;
import static java.util.Objects.requireNonNull;

/**
 * The JDBC based on implementation of the {@code CommonDictRepository}.
 *
 * @author Yichuan
 * @version $Id: JdbcCommonDictRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Repository("commonDictRepository")
public class JdbcCommonDictRepository extends QueryDslJdbcRepository<CommonDict, Integer>
        implements CommonDictRepository {

    private final LoadingCache<String, List<CommonDict>> cache;

    public JdbcCommonDictRepository() {
        super(QCommonDict.qcd);

        cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(24, TimeUnit.HOURS)
                .initialCapacity(100)
                .recordStats()
                .build(new CacheLoader<String, List<CommonDict>>() {
                    @Override
                    public List<CommonDict> load(@Nonnull String key) throws Exception {
                        return findByTypeKey(key, null);
                    }
                });
    }

    @PreDestroy
    public void destroy() {
        cache.invalidateAll();
    }

    @Nullable
    @Override
    public CommonDict findByTypeKeyAndCode(String typeKey, String code) {
        requireNonNull(typeKey, PROP_TYPE_KEY);
        requireNonNull(code, PROP_CODE);
        List<CommonDict> list = cache.getUnchecked(typeKey);
        if (list != null && list.size() > 0) {
            list = list.stream()
                    .filter(d -> d.getCode().equals(code))
                    .collect(Collectors.toList());
            return list.isEmpty() ? null : list.get(0);
        } else {
            return findOne(qcd.typeKey.eq(typeKey).and(qcd.code.eq(code)));
        }
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
        List<CommonDict> list = cache.getIfPresent(typeKey);
        if (list == null) {
            list = findAll(qcd.typeKey.eq(typeKey), QueryDsl.toOrders(qcd, sort));
            cache.put(typeKey, list);
        } else {
            if (sort != null) {
                Collections.sort(list, BeanSort.beanComparator(sort));
            }
        }
        return list instanceof ImmutableList ? (ImmutableList<CommonDict>) list :
                ImmutableList.copyOf(list);
    }
}
