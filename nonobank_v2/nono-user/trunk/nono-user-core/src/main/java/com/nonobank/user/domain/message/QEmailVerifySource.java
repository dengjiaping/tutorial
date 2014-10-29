/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QEmailVerifySource.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.message;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EnumPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.nonobank.data.domain.QAbstractRecording;
import com.nonobank.data.domain.RecordStatus;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.message.EmailVerifySource.*;
import static java.sql.Types.*;

/**
 * QEmailVerifySource is a Querydsl query type for EmailVerifySource
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QEmailVerifySource extends QAbstractRecording<EmailVerifySource> {

    public static final String EMAIL_VERIFY_SOURCE_TABLE = "EMAIL_VERIFY_SOURCE";

    /**
     * 默认使用{@code evs} 作为别名的实体。
     */
    public static final QEmailVerifySource qevs = new QEmailVerifySource("evs");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);
    // 用户ID
    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);
    // 业务类型
    public final EnumPath<BusinessType> type = createEnum(PROP_TYPE, BusinessType.class);
    // 加密token
    public final StringPath token = createString(PROP_TOKEN);
    // 实际内容
    public final StringPath content = createString(PROP_CONTENT);
    // 有效时间
    public final NumberPath<Long> deadline = createNumber(PROP_DEADLINE, Long.class);
    // 有效次数
    public final NumberPath<Integer> useTimes = createNumber(PROP_USE_TIMES, Integer.class);
    // 状态(-1失效  0未验证 1已验证)
    public final EnumPath<RecordStatus> status = createEnum(PROP_STATUS, RecordStatus.class);


    public final PrimaryKey<EmailVerifySource> primary = createPrimaryKey(id);

    public QEmailVerifySource(String variable) {
        super(EmailVerifySource.class, forVariable(variable), "public", EMAIL_VERIFY_SOURCE_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QEmailVerifySource(Path<? extends EmailVerifySource> path) {
        super((Class) path.getType(), path.getMetadata(), "public", EMAIL_VERIFY_SOURCE_TABLE);
        addMetadatas();
    }

    public QEmailVerifySource(PathMetadata<?> metadata) {
        super(EmailVerifySource.class, metadata, "public", EMAIL_VERIFY_SOURCE_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code EmailVerifySource} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QEmailVerifySource(String variable, String schema, String table) {
        super(EmailVerifySource.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(type, named("TYPE").ofType(TINYINT).withSize(1));
        addMetadata(token, named("TOKEN").ofType(VARCHAR).withSize(50));
        addMetadata(content, named("CONTENT").ofType(VARCHAR).withSize(100));
        addMetadata(deadline, named("DEADLINE").ofType(BIGINT));
        addMetadata(useTimes, named("USE_TIMES").ofType(INTEGER));
        addMetadata(status, named("STATUS").ofType(TINYINT).withSize(1));

        addRecordingMetadata();
    }
}
