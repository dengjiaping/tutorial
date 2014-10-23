package com.nonobank.data.domain;

import org.springframework.data.domain.Auditable;

import java.io.Serializable;

/**
 * Abstract base class for auditable entities. Stores the audition values in entity fields.
 *
 * @author fuchun
 * @version $Id: AbstractAuditable.java 40 2014-09-28 06:39:52Z fuchun $
 * @since 2.0
 */
public abstract class AbstractAuditable<
        PK extends Serializable & Comparable<PK>, E extends AbstractAuditable<PK, E, U>,
        U extends Serializable & Comparable<U>>
        extends AbstractRecording<PK, E> implements Entity<PK, E>, Auditable<U, PK> {

    private static final long serialVersionUID = 1L;

    private U createdBy;
    private U lastModifiedBy;

    /**
     * Returns the user who created this entity.
     *
     * @return the createdBy
     */
    @Override
    public U getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the user who created this entity.
     *
     * @param createdBy the creating entity to set
     */
    @Override
    public void setCreatedBy(final U createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Returns the user who modified the entity lastly.
     *
     * @return the lastModifiedBy
     */
    @Override
    public U getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     * Sets the user who modified the entity lastly.
     *
     * @param lastModifiedBy the last modifying entity to set
     */
    @Override
    public void setLastModifiedBy(U lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}