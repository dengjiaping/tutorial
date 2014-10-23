/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CommonDictRepository.java 2014-10-10 15:31
 */

package com.nonobank.user.domain.repository.dict;

import com.google.common.collect.ImmutableList;
import com.mysema.query.types.Order;
import com.mysema.query.types.OrderSpecifier;
import com.nonobank.data.repository.GenericRepository;
import com.nonobank.user.domain.dict.CommonDict;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.nonobank.user.domain.dict.QCommonDict.qcd;

/**
 * {@link com.nonobank.user.domain.dict.CommonDict} 实体的仓储接口。
 *
 * @author fuchun
 * @version $Id: CommonDictRepository.java 257 2014-10-23 06:33:13Z fuchun $
 * @since 2.0
 */
public interface CommonDictRepository extends GenericRepository<CommonDict, Integer> {

    @Nullable
    public CommonDict findByTypeKeyAndCode(String typeKey, String code);

    @Nullable
    public CommonDict findByTypeKeyAndI18nKey(String typeKey, String i18nKey);

    @Nonnull
    public default ImmutableList<CommonDict> findByTypeKeyOrderByOrderNO(String typeKey) {
        return findByTypeKey(typeKey, new QSort(
                new OrderSpecifier<>(Order.ASC, qcd.orderNO)));
    }

    @Nonnull
    public ImmutableList<CommonDict> findByTypeKey(String typeKey, @Nullable Sort sort);
}