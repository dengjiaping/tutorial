/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) GenericRepository.java 2014-09-28 14:42
 */

package com.nonobank.data.repository;

import com.nonobank.data.domain.Entity;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;

/**
 * {@code Repository} 通用接口。
 *
 * @author fuchun
 * @version $Id: GenericRepository.java 42 2014-09-29 08:27:16Z fuchun $
 * @since 2.0
 */
@NoRepositoryBean
public interface GenericRepository<E extends Entity<ID, E>, ID extends Serializable & Comparable<ID>>
        extends PagingAndSortingRepository<E, ID> {

    /**
     * {@inheritDoc}
     * @throws UnsupportedOperationException 如果实现不支持该方法的调用。
     */
    default List<E> findAll() {
        return findAll((Sort) null);
    }

    /**
     * {@inheritDoc}
     */
    List<E> findAll(Iterable<ID> ids);

    /**
     * {@inheritDoc}
     * @throws UnsupportedOperationException 如果实现不支持该方法的调用。
     */
    List<E> findAll(Sort sort);

    /**
     * {@inheritDoc}
     */
    <S extends E> List<S> save(Iterable<S> entities);

    /**
     * Deletes the given entities in a batch which means it will create a single {@code SQLQuery}.
     *
     * @param entities the entities to be deleted.
     */
    void deleteInBatch(Iterable<E> entities);

    /**
     * Deletes all entities in a batch call.
     * @throws UnsupportedOperationException 如果实现不支持该方法的调用。
     */
    void deleteAllInBatch();

    /**
     * {@inheritDoc}
     * @throws UnsupportedOperationException 如果实现不支持该方法的调用。
     */
    @Override
    void deleteAll();
}
