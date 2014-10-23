/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) BankRepository.java 2014-10-16 10:40
 */

package com.nonobank.user.domain.repository.dict;

import com.nonobank.data.repository.support.QueryDsl;
import com.nonobank.user.domain.dict.Bank;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

import static com.nonobank.user.domain.dict.QBank.qb;

/**
 * The {@code Bank} entity repository.
 *
 * @author fuchun
 * @version $Id: BankRepository.java 183 2014-10-16 03:14:52Z fuchun $
 * @since 2.0
 */
public interface BankRepository extends QueryDslPredicateExecutor<Bank> {

    @Nonnull
    public default List<Bank> findByLocCodeAndParentId(
            Integer locCode, Integer parentId, Sort sort) {
        Objects.requireNonNull(locCode, Bank.PROP_LOC_CODE);
        Objects.requireNonNull(parentId, Bank.PROP_PARENT_ID);
        return (List<Bank>) findAll(qb.locCode.eq(locCode).and(qb.parentId.eq(parentId)),
                QueryDsl.toOrders(qb, sort));
    }

    @Nonnull
    public default List<Bank> findByParentIdNull(Sort sort) {
        return (List<Bank>) findAll(qb.parentId.isNull(),
                QueryDsl.toOrders(qb, sort));
    }

    @Nonnull
    public default List<Bank> findByLocCode(Integer locCode, Sort sort) {
        Objects.requireNonNull(locCode, Bank.PROP_LOC_CODE);
        return (List<Bank>) findAll(qb.locCode.eq(locCode),
                QueryDsl.toOrders(qb, sort));
    }
}