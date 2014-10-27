/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) Recording.java 2014-10-27 16:48
 */

package com.nonobank.data.domain;

import org.joda.time.DateTime;

/**
 * Interface for recording entities. Allows storing and retrieving created date
 * and modification date.
 *
 * @author fuchun
 * @version $Id: Recording.java 291 2014-10-27 08:49:07Z fuchun $
 * @since 2.0
 */
public interface Recording {

    /**
     * {@code CREATED_DATE} property name.
     */
    String PROP_CREATED_DATE = "createdDate";

    /**
     * {@code LAST_MODIFIED_DATE} property name.
     */
    String PROP_LAST_MODIFIED_DATE = "lastModifiedDate";

    /**
     * Returns the creation date of the entity.
     *
     * @return the createdDate
     */
    public DateTime getCreatedDate();

    /**
     * Sets the creation date of the entity.
     *
     * @param createdAt the creation date to set
     */
    public void setCreatedDate(DateTime createdAt);

    /**
     * Returns the date of the last modification.
     *
     * @return the lastModifiedDate
     */
    public DateTime getLastModifiedDate();

    /**
     * Sets the date of the last modification.
     *
     * @param lastModifiedAt the date of the last modification to set
     */
    public void setLastModifiedDate(DateTime lastModifiedAt);
}
