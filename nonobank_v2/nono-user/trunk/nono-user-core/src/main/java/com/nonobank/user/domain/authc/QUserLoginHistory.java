/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QUserLoginHistory.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.authc;

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
import static com.nonobank.user.domain.authc.UserLoginHistory.*;
import static java.sql.Types.*;

/**
 * QUserLoginHistory is a Querydsl query type for UserLoginHistory
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserLoginHistory extends QAbstractRecording<UserLoginHistory> {

    public static final String USER_LOGIN_HISTORY_TABLE = "USER_LOGIN_HISTORY";

    /**
     * 默认使用{@code ulh} 作为别名的实例。
     */
    public static final QUserLoginHistory qulh = new QUserLoginHistory("ulh");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final StringPath userName = createString(PROP_USER_NAME);

    public final EnumPath<UserDevice> device = createEnum(PROP_DEVICE, UserDevice.class);

    public final StringPath loginField = createString(PROP_LOGIN_FIELD);

    public final StringPath lastUserAgent = createString(PROP_LAST_USER_AGENT);

    public final DateTimePath<DateTime> lastLoginTime = createDateTime(PROP_LAST_LOGIN_TIME, DateTime.class);

    public final StringPath lastLoginIp = createString(PROP_LAST_LOGIN_IP);

    public final StringPath lastToken = createString(PROP_LAST_TOKEN);

    public final StringPath prevUserAgent = createString(PROP_PREV_USER_AGENT);

    public final DateTimePath<DateTime> prevLoginTime = createDateTime(PROP_PREV_LOGIN_TIME, DateTime.class);

    public final StringPath prevLoginIp = createString(PROP_PREV_LOGIN_IP);

    public final StringPath prevToken = createString(PROP_PREV_TOKEN);

    public final NumberPath<Integer> loginCount = createNumber(PROP_LOGIN_COUNT, Integer.class);

    public final PrimaryKey<UserLoginHistory> primary = createPrimaryKey(id);

    public QUserLoginHistory(String variable) {
        super(UserLoginHistory.class, forVariable(variable), "public", USER_LOGIN_HISTORY_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserLoginHistory(Path<? extends UserLoginHistory> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_LOGIN_HISTORY_TABLE);
        addMetadatas();
    }

    public QUserLoginHistory(PathMetadata<?> metadata) {
        super(UserLoginHistory.class, metadata, "public", USER_LOGIN_HISTORY_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code UserLoginHistory} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QUserLoginHistory(String variable, String schema, String table) {
        super(UserLoginHistory.class, variable, schema, table);
    }

    protected void addMetadatas() {
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(userName, named("USER_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(device, named("DEVICE").ofType(VARCHAR).withSize(20));
        addMetadata(loginField, named("LOGIN_FIELD").ofType(VARCHAR).withSize(50));
        addMetadata(lastUserAgent, named("LAST_USER_AGENT").ofType(VARCHAR).withSize(255));
        addMetadata(lastLoginTime, named("LAST_LOGIN_TIME").ofType(TIMESTAMP));
        addMetadata(lastLoginIp, named("LAST_LOGIN_IP").ofType(VARCHAR).withSize(20));
        addMetadata(lastToken, named("LAST_TOKEN").ofType(VARCHAR).withSize(50));
        addMetadata(prevUserAgent, named("PREV_USER_AGENT").ofType(VARCHAR).withSize(255));
        addMetadata(prevLoginTime, named("PREV_LOGIN_TIME").ofType(TIMESTAMP));
        addMetadata(prevLoginIp, named("PREV_LOGIN_IP").ofType(VARCHAR).withSize(20));
        addMetadata(prevToken, named("PREV_TOKEN").ofType(VARCHAR).withSize(50));
        addMetadata(loginCount, named("LOGIN_COUNT").ofType(INTEGER));
        addRecordingMetadata();
    }
}
