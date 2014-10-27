/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QUserID5Record.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.sql.RelationalPathBase;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.DateTimePath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import org.joda.time.DateTime;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.data.domain.Entity.PROP_USER_ID;
import static com.nonobank.user.domain.ext.UserID5Record.*;
import static java.sql.Types.*;

/**
 * QUserField is a Querydsl query type for UserField
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserID5Record extends RelationalPathBase<UserID5Record> {

    public static final String USER_ID5_RECORD_TABLE = "USER_ID5_RECORD";

    public static final QUserID5Record quir = new QUserID5Record("uir");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final StringPath realName = createString(PROP_REAL_NAME);

    public final StringPath idCard = createString(PROP_ID_CARD);

    public final StringPath schoolName = createString(PROP_SCHOOL_NAME);

    public final StringPath education = createString(PROP_EDUCATION);

    public final StringPath entranceTime = createString(PROP_ENTRANCE_TIME);

    public final StringPath profession = createString(PROP_PROFESSION);

    public final StringPath graduation = createString(PROP_GRADUATION);

    public final StringPath studyResult = createString(PROP_STUDY_RESULT);

    public final StringPath studyChannel = createString(PROP_STUDY_CHANNEL);

    public final DateTimePath<DateTime> createdDate = createDateTime(PROP_CREATED_DATE, DateTime.class);

    public final PrimaryKey<UserID5Record> primary = createPrimaryKey(id);

    public QUserID5Record(String variable) {
        super(UserID5Record.class, forVariable(variable), "public", USER_ID5_RECORD_TABLE);
        addMetadatas();
    }

    public QUserID5Record(Path<? extends UserID5Record> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_ID5_RECORD_TABLE);
        addMetadatas();
    }

    public QUserID5Record(PathMetadata<?> metadata) {
        super(UserID5Record.class, metadata, "public", USER_ID5_RECORD_TABLE);
        addMetadatas();
    }

    public QUserID5Record(String variable, String schema, String table) {
        super(UserID5Record.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(realName, named("REAL_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(idCard, named("ID_CARD").ofType(VARCHAR).withSize(20));
        addMetadata(schoolName, named("SCHOOL_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(education, named("EDUCATION").ofType(VARCHAR).withSize(20));
        addMetadata(entranceTime, named("ENTRANCE_TIME").ofType(VARCHAR).withSize(20));
        addMetadata(profession, named("PROFESSION").ofType(VARCHAR).withSize(50));
        addMetadata(graduation, named("GRADUATION").ofType(VARCHAR).withSize(10));
        addMetadata(studyResult, named("STUDY_RESULT").ofType(VARCHAR).withSize(20));
        addMetadata(studyChannel, named("STUDY_CHANNEL").ofType(VARCHAR).withSize(20));
        addMetadata(createdDate, named("CREATED_DATE").ofType(TIMESTAMP).notNull());
    }
}
