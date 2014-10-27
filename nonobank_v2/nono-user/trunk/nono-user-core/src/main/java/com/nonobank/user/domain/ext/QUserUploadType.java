/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QUserUploadType.java 2014-10-27 16:41
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
import static com.nonobank.user.domain.ext.UserUploadType.*;
import static java.sql.Types.BIGINT;
import static java.sql.Types.VARCHAR;

/**
 * QUserUploadType is a Querydsl query type for UserUploadType
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserUploadType extends QAbstractRecording<UserUploadType> {

    public static final String USER_UPLOAD_TYPE_TABLE = "USER_UPLOAD_TYPE";

    public static final QUserUploadType quut = new QUserUploadType("uut");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final NumberPath<Long> scoreAllocId = createNumber(PROP_SCORE_ALLOC_ID, Long.class);

    public final StringPath typeName = createString(PROP_TYPE_NAME);

    public final StringPath uploadNote = createString(PROP_UPLOAD_NOTE);

    public final StringPath uploadExample = createString(PROP_UPLOAD_EXAMPLE);

    public final PrimaryKey<UserUploadType> primary = createPrimaryKey(id);

    public QUserUploadType(String variable) {
        super(UserUploadType.class, forVariable(variable), "public", USER_UPLOAD_TYPE_TABLE);
        addMetadatas();
    }

    public QUserUploadType(Path<? extends UserUploadType> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_UPLOAD_TYPE_TABLE);
        addMetadatas();
    }

    public QUserUploadType(PathMetadata<?> metadata) {
        super(UserUploadType.class, metadata, "public", USER_UPLOAD_TYPE_TABLE);
    }

    public QUserUploadType(String variable, String schema, String table) {
        super(UserUploadType.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(scoreAllocId, named("SCORE_ALLOC_ID").ofType(BIGINT));
        addMetadata(typeName, named("TYPE_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(uploadNote, named("UPLOAD_NOTE").ofType(VARCHAR).withSize(250));
        addMetadata(uploadExample, named("UPLOAD_EXAMPLE").ofType(VARCHAR).withSize(100));

        addRecordingMetadata();
    }
}
