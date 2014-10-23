/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QScoreType.java 2014-10-16 10:05
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
import com.nonobank.user.domain.ext.common.ScoreAllocType;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.ext.ScoreAlloc.*;
import static java.sql.Types.*;

/**
 * QUserLoanInfo is a Querydsl query type for UserLoanInfo
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QScoreAlloc extends QAbstractRecording<ScoreAlloc> {

    public static final String SCORE_ALLOC_TABLE = "SCORE_ALLOC";

    public static final QScoreAlloc qsa = new QScoreAlloc("sa");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final StringPath allocName = createString(PROP_ALLOC_NAME);

    public final EnumPath<ScoreAllocType> allocType = createEnum(PROP_ALLOC_TYPE, ScoreAllocType.class);

    public final StringPath keyword = createString(PROP_KEYWORD);

    public final StringPath allocDesc = createString(PROP_ALLOC_DESC);

    public final NumberPath<Integer> minScore = createNumber(PROP_MIN_SCORE, Integer.class);

    public final NumberPath<Integer> maxScore = createNumber(PROP_MAX_SCORE, Integer.class);

    public final BooleanPath isEnabled = createBoolean(PROP_IS_ENABLED);

    public final StringPath refuseReason = createString(PROP_REFUSE_REASON);

    public final NumberPath<Integer> orderNum = createNumber(PROP_ORDER_NUM, Integer.class);

    public final BooleanPath isAutoAssign = createBoolean(PROP_IS_AUTO_ASSIGN);

    public final PrimaryKey<ScoreAlloc> primary = createPrimaryKey(id);

    public QScoreAlloc(String variable, String schema, String table) {
        super(ScoreAlloc.class, variable, schema, table);
    }

    public QScoreAlloc(String variable) {
        super(ScoreAlloc.class, forVariable(variable), "public", SCORE_ALLOC_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QScoreAlloc(Path<? extends UserEducation> path) {
        super((Class) path.getType(), path.getMetadata(), "public", SCORE_ALLOC_TABLE);
        addMetadatas();
    }

    public QScoreAlloc(PathMetadata<?> metadata) {
        super(ScoreAlloc.class, metadata, "public", SCORE_ALLOC_TABLE);
        addMetadatas();
    }

    public void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(allocName, named("ALLOC_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(allocType, named("ALLOC_TYPE").ofType(TINYINT).withSize(1));
        addMetadata(keyword, named("KEYWORD").ofType(VARCHAR).withSize(50));
        addMetadata(allocDesc, named("ALLOC_DESC").ofType(VARCHAR).withSize(200));
        addMetadata(minScore, named("MIN_SCORE").ofType(INTEGER));
        addMetadata(maxScore, named("MAX_SCORE").ofType(INTEGER));
        addMetadata(isEnabled, named("IS_ENABLED").ofType(BOOLEAN));
        addMetadata(refuseReason, named("REFUSE_REASON").ofType(VARCHAR).withSize(500));
        addMetadata(orderNum, named("ORDER_NUM").ofType(INTEGER));
        addMetadata(isAutoAssign, named("IS_AUTO_ASSIGN").ofType(BOOLEAN));

        addRecordingMetadata();
    }
}
