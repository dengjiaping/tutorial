package com.nonobank.data.domain;

import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Abstract base class for recording entities. Stores the recording values in entity fields.
 *
 * @param <PK> the type of the recording type's identifier.
 * @author fuchun
 * @version $Id: AbstractRecording.java 40 2014-09-28 06:39:52Z fuchun $
 * @since 2.0
 */
public abstract class AbstractRecording<
        PK extends Serializable & Comparable<PK>, E extends AbstractRecording<PK, E>>
        extends AbstractEntity<PK, E> implements Recording {

    private static final long serialVersionUID = 1L;

    private DateTime createdDate;
    private DateTime lastModifiedDate;

    @Override
    public DateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
