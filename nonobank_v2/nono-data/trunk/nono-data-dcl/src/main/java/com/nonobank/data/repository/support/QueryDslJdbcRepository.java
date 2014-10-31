/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QueryDslJdbcRepository.java 2014-10-27 16:48
 */

package com.nonobank.data.repository.support;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Table;
import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.sql.RelationalPath;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLSubQuery;
import com.mysema.query.sql.dml.BeanMapper;
import com.mysema.query.sql.dml.SQLDeleteClause;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Path;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.Projections;
import com.mysema.query.types.expr.SimpleExpression;
import com.nonobank.data.domain.Entity;
import com.nonobank.data.domain.Recording;
import com.nonobank.data.jdbc.query.JavaBeanPropertyRowMapper;
import com.nonobank.data.jdbc.query.QueryDslJdbcTemplate;
import com.nonobank.data.repository.QueryDslRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import javax.annotation.Nonnull;
import java.beans.PropertyEditor;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * QueryDSL jdbc repository implementation.
 *
 * @author fuchun
 * @version $Id: QueryDslJdbcRepository.java 311 2014-10-30 05:23:12Z fuchun $
 * @since 2.0
 */
public class QueryDslJdbcRepository<E extends Entity<ID, E>, ID extends Serializable & Comparable<ID>>
        implements QueryDslRepository<E, ID>, QueryDslPredicateExecutor<E> {

    protected QueryDslJdbcTemplate queryDslJdbcTemplate;
    protected ConversionService conversionService;
    protected Table<String, Class<?>, PropertyEditor> propertyEditorTable;

    protected RelationalPath<E> entityPath;

    private final Class<E> domainClass;
    private final Class<ID> idClass;

    private long maxSize4FindAll = -1;

    @SuppressWarnings("unused")
    public QueryDslJdbcRepository() {
        this(null, HashBasedTable.create(), null);
    }

    public QueryDslJdbcRepository(RelationalPath<E> entityPath) {
        this(entityPath, HashBasedTable.create(), null);
    }

    @SuppressWarnings("unchecked")
    public QueryDslJdbcRepository(
            RelationalPath<E> entityPath,
            Table<String, Class<?>, PropertyEditor> propertyEditorTable,
            ConversionService conversionService) {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] types = type.getActualTypeArguments();
        domainClass = (Class<E>) types[0];
        idClass = (Class<ID>) types[1];

        this.entityPath = entityPath;
        this.propertyEditorTable = propertyEditorTable;
        this.conversionService = conversionService == null ? new DefaultConversionService() :
                conversionService;
    }

    public Class<E> getDomainClass() {
        return domainClass;
    }

    public Class<ID> getIdClass() {
        return idClass;
    }

    /**
     * Returns {@code true} if the entity's ID is auto_increment,
     * otherwise {@code false}. Default: {@code true}.
     */
    protected boolean isAutoIncrement() {
        return true;
    }

    /**
     * Returns the QueryDsl {@code RelationPath} of this domain repository.
     */
    protected RelationalPath<E> getEntityPath() {
        return entityPath;
    }

    /**
     * Query for object with given {@code SQLQuery}.
     *
     * @param sqlQuery SQLQuery.
     * @return the domain object with given query.
     */
    protected E queryForObject(final SQLQuery sqlQuery) {
        return queryDslJdbcTemplate.queryForObject(
                sqlQuery, Projections.bean(getEntityPath(),
                        QueryDsl.columns(getEntityPath())));
    }

    /**
     * Query for domain list with given {@code SQLQuery}.
     *
     * @param sqlQuery SQLQuery.
     * @return the domain object list with given query.
     */
    protected List<E> queryForList(final SQLQuery sqlQuery) {
        return queryDslJdbcTemplate.query(
                sqlQuery, Projections.bean(getEntityPath(),
                        QueryDsl.columns(getEntityPath())));
    }

    protected void checkEntityIdNotNull(ID id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("The given entity id must not be null!");
        }
    }

    protected void checkEntityNotNull(E entity) throws IllegalArgumentException {
        if (entity == null) {
            throw new IllegalArgumentException("The given entity must not be null!");
        }
    }

    /**
     * Returns new {@link JavaBeanPropertyRowMapper} with this domain class.
     */
    protected JavaBeanPropertyRowMapper<E> newEntityRowMapper() {
        JavaBeanPropertyRowMapper<E> rowMapper =
                JavaBeanPropertyRowMapper.newInstance(getDomainClass());
        if (conversionService != null)
            rowMapper.setConversionService(conversionService);
        if (propertyEditorTable != null)
            rowMapper.setCustomPropertyEditors(propertyEditorTable);
        return rowMapper;
    }

    /**
     * Returns the new {@code SQLQuery} with this {@link #getEntityPath()} .
     */
    protected SQLQuery newSqlQuery() {
        return queryDslJdbcTemplate.newSqlQuery().from(getEntityPath());
    }

    /**
     * Returns the new empty {@code SQLQuery}. Just with configuration.
     */
    protected SQLQuery emptySqlQuery() {
        return queryDslJdbcTemplate.newSqlQuery();
    }

    /**
     * Returns the new SQL sub query ({@code SQLSubQuery).
     */
    protected SQLSubQuery newSubQuery() {
        return new SQLSubQuery();
    }

    @SuppressWarnings("unchecked")
    protected Predicate primaryKeyPredicate(ID[] ids) {
        if (ids == null || ids.length == 0) {
            throw new IllegalArgumentException(
                    "The given primary key `ids` must not be null or empty.");
        }
        PrimaryKey<E> primaryKey = getEntityPath().getPrimaryKey();
        assert primaryKey != null;
        List<? extends Path<?>> idPaths = primaryKey.getLocalColumns();
        assert idPaths != null && idPaths.size() > 0;
        if (ids.length == 1) {
            return ((SimpleExpression<ID>) idPaths.get(0)).eq(ids[0]);
        }

        return ((SimpleExpression<ID>) idPaths.get(0)).in(ids);
    }

    /**
     * Returns primary keys predicate used given ids.
     *
     * @param ids the given ids (primary keys)
     */
    protected Predicate primaryKeyPredicate(@Nonnull Iterable<ID> ids) {
        ID[] idArr = Iterables.toArray(ids, getIdClass());
        return primaryKeyPredicate(idArr);
    }

    @SuppressWarnings("unchecked")
    protected Predicate primaryKeyPredicate(ID id) {
        checkEntityIdNotNull(id);
        PrimaryKey<E> primaryKey = getEntityPath().getPrimaryKey();
        assert primaryKey != null;
        List<? extends Path<?>> idPaths = primaryKey.getLocalColumns();
        assert idPaths != null && idPaths.size() > 0;
        return ((SimpleExpression<ID>) idPaths.get(0)).eq(id);
    }

    @Override
    @Nonnull
    public List<E> findAll(Iterable<ID> ids) {
        if (ids == null || Iterables.isEmpty(ids)) {
            return ImmutableList.of();
        }
        return queryForList(newSqlQuery().where(primaryKeyPredicate(ids)));
    }

    @Override
    public long count() {
        return count(null);
    }

    @Override
    public void delete(ID id) {
        checkEntityIdNotNull(id);
        queryDslJdbcTemplate.delete(getEntityPath(),
                delete -> delete.where(primaryKeyPredicate(id)).execute());
    }

    @Override
    public void delete(E entity) {
        checkEntityNotNull(entity);
        checkEntityIdNotNull(entity.getId());
        delete(entity.getId());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void delete(Iterable<? extends E> entities) {
        deleteInBatch((Iterable<E>) entities);
    }

    @Override
    public List<E> findAll(Sort sort) {
        final SQLQuery sqlQuery = newSqlQuery();
        QueryDsl.applySorting(sort, sqlQuery, getEntityPath());
        if (maxSize4FindAll > 0) {
            long total = count();
            long limit = total > maxSize4FindAll ? maxSize4FindAll : total;
            sqlQuery.offset(0).limit(limit);
        }
        return queryForList(sqlQuery);
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return findAll(null, pageable);
    }

    @Override
    public <S extends E> S save(S entity) {
        if (entity == null) {
            throw new IllegalArgumentException("The given entity must be not null!");
        }
        if (entity.getId() == null) { // only auto_increment
            return insert(entity);
        } else {
            return exists(entity.getId()) ? update(entity) : insert(entity);
        }
    }

    /**
     * Inserts a new entity to repository (relation database).
     *
     * @param entity new entity.
     * @param <S> the entity type.
     * @return a new entity with id.
     */
    public <S extends E> S insert(final S entity) {
        boolean withKey = false;
        if (isAutoIncrement()) {
            withKey = entity.getId() == null;
        } else { // not auto_increment for PK
            if (entity.getId() == null)
                throw new InvalidDataAccessResourceUsageException(
                        "The entity's ID must not be null.");
        }
        if (entity instanceof Recording) {
            Recording recording = (Recording) entity;
            recording.setLastModifiedDate(DateTime.now());
            recording.setCreatedDate(DateTime.now());
        }
        if (withKey) {
            ID id = queryDslJdbcTemplate.insertWithKey(getEntityPath(),
                    insert -> insert.populate(entity, BeanMapper.WITH_NULL_BINDINGS)
                            .executeWithKey(getIdClass()));
            entity.setId(id);
        } else {
            long row = queryDslJdbcTemplate.insert(getEntityPath(),
                    insert -> insert.populate(entity, BeanMapper.WITH_NULL_BINDINGS)
                            .execute()
            );
            if (row == 0) {
                return null;
            }
        }
        return entity;
    }

    /**
     * Updates the given entity object.
     *
     * @param entity updated entity.
     * @param <S> the entity type.
     * @return a updated entity.
     */
    @SuppressWarnings("unchecked")
    public <S extends E> S update(final S entity) {
        Objects.requireNonNull(entity, "entity");
        if (entity instanceof Recording) {
            ((Recording) entity).setLastModifiedDate(DateTime.now());
        }
        queryDslJdbcTemplate.update(getEntityPath(),
                update -> update.populate(entity, BeanMapper.DEFAULT)
                        .where(primaryKeyPredicate(entity.getId()))
                        .execute()
        );
        return entity;
    }

    @Override
    public <S extends E> List<S> save(Iterable<S> entities) {
        if (entities == null || Iterables.size(entities) == 0) {
            return ImmutableList.of();
        }
        List<S> result = new LinkedList<>();
        for (S entity : entities) {
            S updatedEntity = save(entity);
            if (updatedEntity != null) {
                result.add(updatedEntity);
            }
        }

        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E findOne(ID id) {
        checkEntityIdNotNull(id);
        return findOne(primaryKeyPredicate(id));
    }

    @Override
    public boolean exists(ID id) {
        if (id == null) {
            throw new IllegalArgumentException("The given entity id must not be null!");
        }
        return exists(primaryKeyPredicate(id));
    }

    @Override
    public void deleteInBatch(Iterable<E> entities) {
        if (entities == null || Iterables.isEmpty(entities)) {
            return;
        }
        final Iterable<E> realEntities = Iterables.filter(entities,
                input -> input != null && input.getId() != null);

        final Iterable<ID> deletedIds = Iterables.transform(realEntities,
                input -> {
                    assert input != null;
                    return input.getId();
                }
        );

        queryDslJdbcTemplate.delete(getEntityPath(), deleteClause ->
                deleteClause.where(primaryKeyPredicate(deletedIds)).execute());
    }

    @Override
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Not support delete all records.");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not support delete all records.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean exists(Predicate predicate) {
        return queryDslJdbcTemplate.exists(newSqlQuery().where(predicate));
    }

    @Override
    public E findOne(Predicate predicate) {
        return queryForObject(newSqlQuery().where(predicate));
    }

    @Override
    public List<E> findAll(Predicate predicate) {
        checkNotNull(predicate, "predicate");
        return queryForList(newSqlQuery().where(predicate));
    }

    @Override
    public List<E> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
        final SQLQuery sqlQuery = newSqlQuery().where(predicate).orderBy(orders);
        return queryForList(sqlQuery);
    }

    @Override
    public Page<E> findAll(Predicate predicate, Pageable pageable) {
        long total = count(predicate);
        List<E> content;
        if (total == 0) {
            content = ImmutableList.of();
        } else {
            final SQLQuery sqlQuery = predicate == null ?
                    newSqlQuery() : newSqlQuery().where(predicate);
            QueryDsl.applyPagination(pageable, sqlQuery, getEntityPath());
            content = queryForList(sqlQuery);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public long count(Predicate predicate) {
        SQLQuery sqlQuery;
        if (predicate != null) {
            sqlQuery = newSqlQuery().where(predicate);
        } else {
            sqlQuery = newSqlQuery();
        }
        return queryDslJdbcTemplate.count(sqlQuery);
    }

    /**
     * Deletes all entities managed by the repository (only testing).
     */
    @SuppressWarnings("unused")
    public void deleteAllInBatchInner() {
        queryDslJdbcTemplate.delete(getEntityPath(), SQLDeleteClause::execute);
    }

    @Autowired(required = false)
    public void setQueryDslJdbcTemplate(QueryDslJdbcTemplate queryDslJdbcTemplate) {
        this.queryDslJdbcTemplate = queryDslJdbcTemplate;
    }

    @Autowired(required = false)
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Autowired(required = false)
    public void setMaxSize4FindAll(long maxSize4FindAll) {
        this.maxSize4FindAll = maxSize4FindAll;
    }
}
