/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QLocation.java 2014-10-14 15:28
 */

package com.nonobank.user.domain.dict;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.sql.RelationalPathBase;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.dict.Location.*;
import static java.sql.Types.INTEGER;
import static java.sql.Types.TINYINT;
import static java.sql.Types.VARCHAR;

/**
 * QLocation is a Querydsl query type for Location
 * @version $Id: QLocation.java 168 2014-10-15 04:41:27Z fuchun $
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QLocation extends RelationalPathBase<Location> {

    public static final String LOCATION_TABLE = "DICT_LOCATION";

    /**
     * 默认使用{@code l} 作为别名的实例。
     */
    public static final QLocation ql = new QLocation("l");

    public final NumberPath<Integer> id = createNumber(PROP_ID, Integer.class);

    public final NumberPath<Short> tier = createNumber(PROP_TIER, Short.class);

    public final NumberPath<Integer> code = createNumber(PROP_CODE, Integer.class);

    public final StringPath fullName = createString(PROP_FULL_NAME);

    public final StringPath shortName = createString(PROP_SHORT_NAME);

    public final NumberPath<Integer> parentId = createNumber(PROP_PARENT_ID, Integer.class);

    public final PrimaryKey<Location> primary = createPrimaryKey(id);

    public QLocation(String variable) {
        super(Location.class, forVariable(variable), "public", LOCATION_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QLocation(Path<? extends Location> path) {
        super((Class) path.getType(), path.getMetadata(), "public", LOCATION_TABLE);
        addMetadatas();
    }

    public QLocation(PathMetadata<?> metadata) {
        super(Location.class, metadata, "public", LOCATION_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code Location} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QLocation(String variable, String schema, String table) {
        super(Location.class, variable, schema, table);
        addMetadatas();
    }

    protected void addMetadatas() {
        addMetadata(id, named("ID").ofType(INTEGER));
        addMetadata(tier, named("TIER").ofType(TINYINT));
        addMetadata(code, named("L_CODE").ofType(INTEGER));
        addMetadata(fullName, named("FULL_NAME").ofType(VARCHAR).withSize(20));
        addMetadata(shortName, named("SHORT_NAME").ofType(VARCHAR).withSize(20));
        addMetadata(parentId, named("PARENT_ID").ofType(INTEGER));
    }
}