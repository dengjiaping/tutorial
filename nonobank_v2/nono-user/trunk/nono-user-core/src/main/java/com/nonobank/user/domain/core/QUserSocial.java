/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QUserSocial.java 2014-10-11 14:07
 */

package com.nonobank.user.domain.core;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.DateTimePath;
import com.mysema.query.types.path.EnumPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.nonobank.data.domain.QAbstractRecording;
import org.joda.time.DateTime;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.core.UserSocial.*;
import static java.sql.Types.BIGINT;
import static java.sql.Types.TIMESTAMP;
import static java.sql.Types.VARCHAR;

/**
 * QUserSocial is a Querydsl query type for UserSocial
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserSocial extends QAbstractRecording<UserSocial> {

    public static final String USER_SOCIAL_TABLE = "USER_SOCIAL";

    /**
     * 默认的{@code QUserSocial} 实例，使用{@code us} 别名。
     */
    public static final QUserSocial qus = new QUserSocial("us");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final StringPath userName = createString(PROP_USER_NAME);

    public final StringPath openId = createString(PROP_OPEN_ID);

    public final EnumPath<SocialSource> socialSource = createEnum(PROP_SOCIAL_SOURCE, SocialSource.class);

    public final StringPath authToken = createString(PROP_AUTH_TOKEN);

    public final NumberPath<Long> period = createNumber(PROP_PERIOD, Long.class);

    public final DateTimePath<DateTime> tokenUpdateTime = createDateTime(PROP_TOKEN_UPDATE_TIME, DateTime.class);

    public final PrimaryKey<UserSocial> primary = createPrimaryKey(id);

    public QUserSocial(String variable) {
        super(UserSocial.class, forVariable(variable), "public", USER_SOCIAL_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserSocial(Path<? extends UserSocial> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_SOCIAL_TABLE);
        addMetadatas();
    }

    public QUserSocial(PathMetadata<?> metadata) {
        super(UserSocial.class, metadata, "public", USER_SOCIAL_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code UserSocial} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QUserSocial(String variable, String schema, String table) {
        super(UserSocial.class, variable, schema, table);
    }

    protected void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT).notNull());
        addMetadata(userId, named("USER_ID").ofType(BIGINT).notNull());
        addMetadata(userName, named("USER_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(openId, named("OPEN_ID").ofType(VARCHAR).withSize(50));
        addMetadata(socialSource, named("SOCIAL_SOURCE").ofType(VARCHAR).withSize(20));
        addMetadata(authToken, named("AUTH_TOKEN").ofType(VARCHAR).withSize(50));
        addMetadata(period, named("TOKEN_PERIOD").ofType(BIGINT));
        addMetadata(tokenUpdateTime, named("TOKEN_UPDATE_TIME").ofType(TIMESTAMP));
        addRecordingMetadata();
    }
}
