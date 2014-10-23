/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) TestDomain.java 2014-09-29 11:53
 */

package com.nonobank.data.domain;

import org.joda.time.DateTime;

/**
 * @author Fuchun
 * @since 1.0
 */
public class TestDomain extends AbstractEntity<Integer, TestDomain> {

    public static final short STATUS_DELETED = -1;
    public static final short STATUS_NORMAL = 0;

    private static final long serialVersionUID = 6720064273192111407L;

    private String name;
    private TUserStatus status;
    private DateTime createdDate;
    private DateTime lastModifiedDate;

    public TestDomain id(Integer id) {
        setId(id);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TUserStatus getStatus() {
        return status;
    }

    public void setStatus(TUserStatus status) {
        this.status = status;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public DateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(DateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Merges this entity with given new state entity.
     *
     * @param other new state entity。
     * @return this entity.
     * @throws IllegalStateException if {@code !e.getId().equals(getId())}.
     */
    @Override
    public TestDomain merge(TestDomain other) {
        return this;
    }

    public static TestDomain newInstance(String name, TUserStatus status) {
        final TestDomain td = new TestDomain();
        final DateTime dateTime = DateTime.now();
        td.setName(name);
        td.setStatus(status == null ? TUserStatus.CREATED : status);
        td.setCreatedDate(dateTime);
        td.setLastModifiedDate(dateTime);
        return td;
    }
}