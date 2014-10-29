/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QUserCriminal.java 2014-10-29 14:23
 */

package com.nonobank.user.domain.ext;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.nonobank.data.domain.QAbstractRecording;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.ext.UserCriminal.*;
import static java.sql.Types.BIGINT;
import static java.sql.Types.VARCHAR;

/**
 * QUserCriminal is a Querydsl query type for UserCriminal
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserCriminal extends QAbstractRecording<UserCriminal> {

    public static final String USER_CRIMINAL_TABLE = "USER_CRIMINAL";

    public static final QUserCriminal quc = new QUserCriminal("uc");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final StringPath userName = createString(PROP_USER_NAME);

    public final StringPath criminalStatus = createString(PROP_CRIMINAL_STATUS);

    public final StringPath criminalInfo = createString(PROP_CRIMINAL_INFO);

    public final PrimaryKey<UserCriminal> primary = createPrimaryKey(id);

    public QUserCriminal(String variable) {
        super(UserCriminal.class, forVariable(variable), "public", USER_CRIMINAL_TABLE);
    }

    public QUserCriminal(Path<? extends UserCriminal> path) {
        super((Class) path.getClass(), path.getMetadata(), "public", USER_CRIMINAL_TABLE);
    }

    public QUserCriminal(PathMetadata<?> metadata) {
        super(UserCriminal.class, metadata, "public", USER_CRIMINAL_TABLE);
    }

    public QUserCriminal(String variable, String schema, String table) {
        super(UserCriminal.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(userName, named("USER_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(criminalStatus, named("CRIMINAL_STATUS").ofType(VARCHAR).withSize(20));
        addMetadata(criminalInfo, named("CRIMINAL_INFO").ofType(VARCHAR).withSize(200));

        addRecordingMetadata();
    }
}
