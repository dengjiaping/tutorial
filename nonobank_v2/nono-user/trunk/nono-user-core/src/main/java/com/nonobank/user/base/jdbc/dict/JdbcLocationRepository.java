/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JdbcLocationRepository.java 2014-10-15 10:54
 */

package com.nonobank.user.base.jdbc.dict;

import com.mysema.query.sql.SQLQuery;
import com.nonobank.data.repository.support.QueryDsl;
import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.dict.Location;
import com.nonobank.user.domain.dict.QLocation;
import com.nonobank.user.domain.repository.dict.LocationRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.nonobank.data.repository.support.QueryDsl.toOrders;
import static com.nonobank.user.domain.dict.QLocation.ql;

/**
 * @author fuchun
 * @version $Id: JdbcLocationRepository.java 209 2014-10-17 09:45:19Z fuchun $
 * @since 2.0
 */
@Repository("locationRepository")
public class JdbcLocationRepository extends QueryDslJdbcRepository<Location, Integer>
        implements LocationRepository {

    private final QLocation ql1 = new QLocation("l1");

    public JdbcLocationRepository() {
        super(ql);
    }

    @Override
    @Nonnull
    public List<Location> findChildrenByCode(Integer code, Sort sort) {
        if (code == null || code <= 0) {
            return Collections.emptyList();
        }
        final SQLQuery sqlQuery = newSqlQuery()
                .where(ql.parentId.eq(
                        newSubQuery().from(ql1).where(ql1.code.eq(code))
                                .unique(ql1.id)));
        QueryDsl.applySorting(sort, sqlQuery, ql);
        return queryForList(sqlQuery);
    }

    @Override
    @Nonnull
    public List<Location> findChildrenByShortName(String shortName, Sort sort) {
        if (shortName == null || shortName.length() == 0) {
            return Collections.emptyList();
        }
        final SQLQuery sqlQuery = newSqlQuery()
                .where(ql.parentId.eq(
                        newSubQuery().from(ql1).where(ql1.shortName.eq(shortName))
                                .unique(ql1.id)));
        QueryDsl.applySorting(sort, sqlQuery, ql);
        return queryForList(sqlQuery);
    }

    @Override
    public Location findByCode(Integer code) {
        Objects.requireNonNull(code, Location.PROP_CODE);
        return findOne(ql.code.eq(code));
    }

    @Override
    public Location findByShortNameAndParentId(
            String shortName, Integer parentId) {
        Objects.requireNonNull(shortName, Location.PROP_SHORT_NAME);
        Objects.requireNonNull(parentId, Location.PROP_PARENT_ID);
        return findOne(ql.shortName.eq(shortName).and(ql.parentId.eq(parentId)));
    }

    @Override
    @Nonnull
    public List<Location> findByTier(Short tier, Sort sort) {
        Objects.requireNonNull(tier, Location.PROP_TIER);
        if (tier <= 0) {
            return Collections.emptyList();
        }
        return findAll(ql.tier.eq(tier), toOrders(ql, sort));
    }

    @Override
    @Nonnull
    public List<Location> findByParentId(Integer parentId, Sort sort) {
        Objects.requireNonNull(parentId, Location.PROP_PARENT_ID);
        if (parentId <= 0) {
            return Collections.emptyList();
        }
        return findAll(ql.parentId.eq(parentId), toOrders(ql, sort));
    }
}
