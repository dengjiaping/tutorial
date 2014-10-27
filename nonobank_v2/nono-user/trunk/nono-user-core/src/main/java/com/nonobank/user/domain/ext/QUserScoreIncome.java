/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QUserScoreIncome.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.BooleanPath;
import com.mysema.query.types.path.DateTimePath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.nonobank.data.domain.QAbstractRecording;
import org.joda.time.DateTime;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.ext.UserScoreIncome.*;
import static java.sql.Types.*;

/**
 * QUserScoreIncome is a Querydsl query type for UserScoreIncome
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserScoreIncome extends QAbstractRecording<UserScoreIncome> {

    public static final String USER_SCORE_INCOME_TABLE = "USER_SCORE_INCOME";

    public static final QUserScoreIncome qusd = new QUserScoreIncome("usd");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final NumberPath<Long> scoreAllocId = createNumber(PROP_SCORE_ALLOC_ID, Long.class);

    public final NumberPath<Integer> score = createNumber(PROP_SCORE, Integer.class);

    public final NumberPath<Integer> auditScore = createNumber(PROP_AUDIT_SCORE, Integer.class);

    public final NumberPath<Integer> auditorId = createNumber(PROP_AUDITOR_ID, Integer.class);

    public final DateTimePath<DateTime> auditTime = createDateTime(PROP_AUDIT_TIME, DateTime.class);

    public final BooleanPath isConfirm = createBoolean(PROP_IS_CONFIRM);

    public final StringPath remarks = createString(PROP_REMARKS);

    public final PrimaryKey<UserScoreIncome> primary = createPrimaryKey(id);

    public QUserScoreIncome(String variable) {
        super(UserScoreIncome.class, forVariable(variable), "public", USER_SCORE_INCOME_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserScoreIncome(Path<? extends UserScoreIncome> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_SCORE_INCOME_TABLE);
        addMetadatas();
    }

    public QUserScoreIncome(PathMetadata<?> metadata) {
        super(UserScoreIncome.class, metadata, "public", USER_SCORE_INCOME_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code UserScoreDetail} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QUserScoreIncome(String variable, String schema, String table) {
        super(UserScoreIncome.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(scoreAllocId, named("SCORE_ALLOC_ID").ofType(BIGINT));
        addMetadata(score, named("SCORE").ofType(INTEGER));
        addMetadata(auditScore, named("AUDIT_SCORE").ofType(INTEGER));
        addMetadata(auditorId, named("AUDITOR_ID").ofType(INTEGER));
        addMetadata(auditTime, named("AUDIT_TIME").ofType(TIMESTAMP));
        addMetadata(isConfirm, named("IS_CONFIRM").ofType(BOOLEAN));
        addMetadata(remarks, named("REMARKS").ofType(VARCHAR).withSize(100));

        addRecordingMetadata();
    }
}
