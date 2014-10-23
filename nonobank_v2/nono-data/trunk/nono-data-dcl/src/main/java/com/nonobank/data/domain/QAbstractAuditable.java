/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QAbstractAuditable.java 2014-09-28 14:02
 */

package com.nonobank.data.domain;

import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.NumberPath;

import javax.annotation.Generated;
import java.io.Serializable;

import static com.mysema.query.sql.ColumnMetadata.named;
import static java.sql.Types.VARCHAR;

/**
 * QAbstractRecording is a Querydsl query type for QAbstractRecording
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QAbstractAuditable<T extends AbstractAuditable<? extends Serializable, T, Long>>
        extends QAbstractRecording<T> {

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final NumberPath<Long> lastModifiedBy = createNumber("lastModifiedBy", Long.class);

    public QAbstractAuditable(Class<? extends T> type, String variable, String schema, String table) {
        super(type, variable, schema, table);
    }

    public QAbstractAuditable(Class<? extends T> type, PathMetadata<?> metadata, String schema, String table) {
        super(type, metadata, schema, table);
    }

    protected void addAuditableMetadata() {
        addRecordingMetadata();
        addMetadata(createdBy, named("CREATED_BY").withSize(50).ofType(VARCHAR));
        addMetadata(lastModifiedBy, named("LAST_MODIFIED_BY").withSize(50).ofType(VARCHAR));
    }
}