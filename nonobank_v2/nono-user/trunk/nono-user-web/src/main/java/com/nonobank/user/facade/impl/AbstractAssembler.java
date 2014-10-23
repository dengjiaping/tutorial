/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) AbstractAssembler.java 2014-10-22 09:06
 */

package com.nonobank.user.facade.impl;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author fuchun
 * @version $Id: AbstractAssembler.java 260 2014-10-23 07:18:22Z yichuan $
 * @since 2.0
 */
public abstract class AbstractAssembler<E, T> {

    public abstract T toDTO(E entity);

    @Nonnull
    public List<T> toDTOList(List<E> entities) {
        return toDTOList(entities, e -> e != null);
    }

    @Nonnull
    public List<T> toDTOList(List<E> entities, Predicate<E> filter) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }
        Predicate<E> f = (filter == null) ? (e -> e != null) : filter;
        return entities.stream().filter(f)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public abstract E toEntity(T dto);

    @Nonnull
    public List<E> toEntityList(List<T> dtoList) {
        return toEntityList(dtoList, t -> t != null);
    }

    @Nonnull
    public List<E> toEntityList(List<T> dtoList, Predicate<T> filter) {
        if (dtoList == null || dtoList.isEmpty()) {
            return Collections.emptyList();
        }
        Predicate<T> f = (filter == null) ? (e -> e != null) : filter;
        return dtoList.stream().filter(f)
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
