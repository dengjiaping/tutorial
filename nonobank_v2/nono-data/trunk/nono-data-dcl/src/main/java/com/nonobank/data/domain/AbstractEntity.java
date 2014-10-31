/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) AbstractEntity.java 2014-10-27 16:48
 */

package com.nonobank.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Abstract base class for entities. Allows parameterization of id type, chooses auto-generation and implements
 * {@link #equals(Object)} and {@link #hashCode()} based on that id.
 *
 * @author fuchun
 * @version $Id: AbstractEntity.java 303 2014-10-30 01:16:32Z fuchun $
 * @since 2.0
 */
public abstract class AbstractEntity<PK extends Serializable & Comparable<PK>, E extends AbstractEntity<PK, E>>
        implements Entity<PK, E> {

    private static final long serialVersionUID = 1L;

    private transient CrudRepository<E, PK> repository;

    private PK id;

    /**
     * Sets the id of the entity.
     *
     * @param id the id to set.
     */
    @Override
    public void setId(PK id) {
        this.id = id;
    }

    /**
     * Returns the id of the entity.
     *
     * @return the id
     */
    @Override
    public PK getId() {
        return id;
    }

    /**
     * Returns if the {@code Persistable} is new or was persisted already.
     *
     * @return if the object is new
     */
    @Override
    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S extends E> S save() {
        if (repository() != null) {
            Entity<PK, E> entity = this;
            return repository().save((S) entity);
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void delete() {
        if (repository() != null) {
            repository().delete(getId());
        }
    }

    @Override
    public CrudRepository<E, PK> repository() {
        return repository;
    }

    public void setRepository(CrudRepository<E, PK> repository) {
        this.repository = repository;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this == o) {
            return true;
        } else if (!(o instanceof AbstractEntity)) {
            return false;
        }
        AbstractEntity<PK, E> that = (AbstractEntity<PK, E>) o;
        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        int hashCode = 31 + getClass().getName().hashCode();
        hashCode += getId() == null ? 0 : getId().hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return String.format("%s@Entity(id=%s)", getClass().getName(), getId());
    }
}
