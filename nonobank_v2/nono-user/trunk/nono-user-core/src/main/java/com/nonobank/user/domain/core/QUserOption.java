/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QUserOption.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.core;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.sql.RelationalPathBase;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.BooleanPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.core.UserOption.*;
import static java.sql.Types.*;

/**
 * QUserOption is a Querydsl query type for UserOption
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserOption extends RelationalPathBase<UserOption> {

    public static final String USER_OPTION_TABLE = "USER_OPTION";

    /**
     * 默认的{@code UserOption} 实例，使用{@code opt} 别名。
     */
    public static final QUserOption qOpt = new QUserOption("opt");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final StringPath key = createString(PROP_KEY);

    public final StringPath value = createString(PROP_VALUE);

    public final StringPath bigValue = createString(PROP_BIG_VALUE);

    public final BooleanPath big = createBoolean(PROP_BIG);

    public final PrimaryKey<UserOption> primary = createPrimaryKey(id);

    public QUserOption(String variable) {
        super(UserOption.class, forVariable(variable), "public", USER_OPTION_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserOption(Path<? extends UserOption> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_OPTION_TABLE);
        addMetadatas();
    }

    public QUserOption(PathMetadata<?> metadata) {
        super(UserOption.class, metadata, "public", USER_OPTION_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code UserOption} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QUserOption(String variable, String schema, String table) {
        super(UserOption.class, variable, schema, table);
    }

    protected void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT).notNull());
        addMetadata(userId, named("USER_ID").ofType(BIGINT).notNull());
        addMetadata(key, named("OPTION_KEY").ofType(VARCHAR).withSize(50));
        addMetadata(value, named("OPTION_VALUE").ofType(VARCHAR).withSize(255));
        addMetadata(bigValue, named("BIG_VALUE").ofType(LONGVARCHAR));
        addMetadata(big, named("IS_BIG").ofType(TINYINT));
    }
}
