/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QScoreRank.java 2014-10-27 16:41
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
import static com.nonobank.user.domain.ext.ScoreRank.*;
import static java.sql.Types.*;

/**
 * QUserLoanData is a Querydsl query type for UserLoanData
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QScoreRank extends QAbstractRecording<ScoreRank> {

    public static final String SCORE_RANK_TABLE = "SCORE_RANK";

    public static final QScoreRank qsr = new QScoreRank("sr");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final StringPath rankName = createString(PROP_RANK_NAME);

    public final StringPath rankIcon = createString(PROP_RANK_ICON);

    public final NumberPath<Integer> startScore = createNumber(PROP_START_SCORE, Integer.class);

    public final NumberPath<Integer> endScore = createNumber(PROP_END_SCORE, Integer.class);

    public final StringPath scoreCapital = createString(PROP_SCORE_CAPITAL);

    public final StringPath remarks = createString(PROP_REMARKS);

    public final PrimaryKey<ScoreRank> primary = createPrimaryKey(id);

    public QScoreRank(String variable) {
        super(ScoreRank.class, forVariable(variable), "public", SCORE_RANK_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QScoreRank(Path<? extends UserEducation> path) {
        super((Class) path.getType(), path.getMetadata(), "public", SCORE_RANK_TABLE);
        addMetadatas();
    }

    public QScoreRank(PathMetadata<?> metadata) {
        super(ScoreRank.class, metadata, "public", SCORE_RANK_TABLE);
        addMetadatas();
    }
    public QScoreRank(String variable, String schema, String table) {
        super(ScoreRank.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(rankName, named("RANK_NAME").ofType(VARCHAR).withSize(20));
        addMetadata(rankIcon, named("RANK_ICON").ofType(VARCHAR).withSize(200));
        addMetadata(startScore, named("START_SCORE").ofType(INTEGER));
        addMetadata(endScore, named("END_SCORE").ofType(INTEGER));
        addMetadata(scoreCapital, named("SCORE_CAPITAL").ofType(VARCHAR).withSize(500));
        addMetadata(remarks, named("REMARKS").ofType(VARCHAR).withSize(100));

        addRecordingMetadata();
    }
}
