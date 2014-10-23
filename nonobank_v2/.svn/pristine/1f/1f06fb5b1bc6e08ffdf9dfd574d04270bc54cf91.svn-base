/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QUserStats.java 2014-10-17 09:23
 */

package com.nonobank.user.domain.core;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.PathMetadataFactory;
import com.mysema.query.types.path.NumberPath;
import com.nonobank.data.domain.QAbstractRecording;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.nonobank.user.domain.core.UserStats.*;
import static java.sql.Types.BIGINT;
import static java.sql.Types.INTEGER;

/**
 * QUserStats is a Querydsl query type for UserStats
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserStats extends QAbstractRecording<UserStats> {

    public static final String USER_STATS_TABLE = "USER_STATS";

    public static final QUserStats qust = new QUserStats("ust");

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final NumberPath<Integer> totalScore = createNumber(PROP_TOTAL_SCORE, Integer.class);

    public final NumberPath<Integer> currScore = createNumber(PROP_CURR_SCORE, Integer.class);

    public final NumberPath<Integer> borrowCount = createNumber(PROP_BORROW_COUNT, Integer.class);

    public final NumberPath<Integer> rejectedCount = createNumber(PROP_REJECTED_COUNT, Integer.class);

    public final NumberPath<Integer> biddingCount = createNumber(PROP_BIDDING_COUNT, Integer.class);

    public final PrimaryKey<UserStats> primary = createPrimaryKey(userId);

    public QUserStats(String variable) {
        super(UserStats.class, PathMetadataFactory.forVariable(variable), "public", USER_STATS_TABLE);
        addMetadatas();
    }

    public QUserStats(Path<? extends UserSocial> path) {
        super((Class)path.getType(), path.getMetadata(), "public", USER_STATS_TABLE);
        addMetadatas();
    }

    public QUserStats(PathMetadata<?> metadata) {
        super(UserStats.class, metadata, "public", USER_STATS_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code UserStats} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QUserStats(String variable, String schema, String table) {
        super(UserStats.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(totalScore, named("TOTAL_SCORE").ofType(INTEGER));
        addMetadata(currScore, named("CURR_SCORE").ofType(INTEGER));
        addMetadata(borrowCount, named("BORROW_COUNT").ofType(INTEGER));
        addMetadata(rejectedCount, named("REJECTED_COUNT").ofType(INTEGER));
        addMetadata(biddingCount, named("BIDDING_COUNT").ofType(INTEGER));

        addRecordingMetadata();
    }
}
