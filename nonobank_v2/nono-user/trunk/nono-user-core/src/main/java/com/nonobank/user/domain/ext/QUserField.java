/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QUserField.java 2014-10-16 15:00
 */

package com.nonobank.user.domain.ext;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.BooleanPath;
import com.mysema.query.types.path.EnumPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.nonobank.data.domain.QAbstractRecording;
import com.nonobank.user.domain.ext.common.VerifyMode;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.ext.UserField.*;
import static java.sql.Types.*;

/**
 * QUserField is a Querydsl query type for UserField
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserField extends QAbstractRecording<UserField> {

    public static final String USER_FIELD_TABLE = "USER_FIELD";

    public static final QUserField quf = new QUserField("uf");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final NumberPath<Long> scoreAllocId = createNumber(PROP_SCORE_ALLOC_ID, Long.class);

    public final StringPath fieldName = createString(PROP_FIELD_NAME);

    public final StringPath fieldKwd = createString(PROP_FIELD_KWD);

    public final BooleanPath isRequired = createBoolean(PROP_IS_REQUIRED);

    public final NumberPath<Integer> fieldMinLen = createNumber(PROP_FIELD_MIN_LEN, Integer.class);

    public final NumberPath<Integer> fieldMaxLen = createNumber(PROP_FIELD_MAX_LEN, Integer.class);

    public final StringPath fieldNote = createString(PROP_FIELD_NOTE);

    public final EnumPath<VerifyMode> verifyMode = createEnum(PROP_VERIFY_MODE, VerifyMode.class);

    public final BooleanPath isIntegrity = createBoolean(PROP_IS_INTEGRITY);

    public final StringPath fieldDesc = createString(PROP_FIELD_DESC);

    public final PrimaryKey<UserField> primary = createPrimaryKey(id);

    public QUserField(String variable) {
        super(UserField.class, forVariable(variable), "public", USER_FIELD_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserField(Path<? extends UserEducation> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_FIELD_TABLE);
        addMetadatas();
    }

    public QUserField(PathMetadata<?> metadata) {
        super(UserField.class, metadata, "public", USER_FIELD_TABLE);
        addMetadatas();
    }

    public QUserField(String variable, String schema, String table) {
        super(UserField.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(scoreAllocId, named("SCORE_ALLOC_ID").ofType(BIGINT));
        addMetadata(fieldName, named("FIELD_NAME").ofType(50));
        addMetadata(fieldKwd, named("FIELD_KWD").ofType(50));
        addMetadata(isRequired, named("IS_REQUIRED").ofType(BOOLEAN));
        addMetadata(fieldMinLen, named("FIELD_MIN_LEN").ofType(INTEGER));
        addMetadata(fieldMaxLen, named("FIELD_MAX_LEN").ofType(INTEGER));
        addMetadata(fieldNote, named("FIELD_NOTE").ofType(VARCHAR).withSize(250));
        addMetadata(verifyMode, named("VERIFY_MODE").ofType(TINYINT));
        addMetadata(isIntegrity, named("IS_INTEGRITY").ofType(BOOLEAN));
        addMetadata(fieldDesc, named("FIELD_DESC").ofType(VARCHAR).withSize(200));

        addRecordingMetadata();
    }
}
