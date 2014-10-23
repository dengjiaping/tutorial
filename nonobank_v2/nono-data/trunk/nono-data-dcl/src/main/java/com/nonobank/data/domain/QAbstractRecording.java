/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QAbstractRecording.java 2014-09-28 14:03
 */

package com.nonobank.data.domain;

import com.mysema.query.sql.RelationalPathBase;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.DateTimePath;
import org.joda.time.DateTime;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.nonobank.data.domain.Recording.PROP_CREATED_DATE;
import static com.nonobank.data.domain.Recording.PROP_LAST_MODIFIED_DATE;
import static java.sql.Types.TIMESTAMP;

/**
 * QAbstractRecording is a Querydsl query type for QAbstractRecording
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QAbstractRecording<T> extends RelationalPathBase<T> {

    private static final long serialVersionUID = 7582941692523143830L;

    public final DateTimePath<DateTime> createdDate = createDateTime(
            PROP_CREATED_DATE, DateTime.class);

    public final DateTimePath<DateTime> lastModifiedDate = createDateTime(
            PROP_LAST_MODIFIED_DATE, DateTime.class);

    public QAbstractRecording(Class<? extends T> type, String variable, String schema, String table) {
        super(type, variable, schema, table);
    }

    public QAbstractRecording(Class<? extends T> type, PathMetadata<?> metadata, String schema, String table) {
        super(type, metadata, schema, table);
    }

    protected void addRecordingMetadata() {
        addMetadata(lastModifiedDate, named("LAST_MODIFIED_DATE").ofType(TIMESTAMP).notNull());
        addMetadata(createdDate, named("CREATED_DATE").ofType(TIMESTAMP).notNull());
    }
}
