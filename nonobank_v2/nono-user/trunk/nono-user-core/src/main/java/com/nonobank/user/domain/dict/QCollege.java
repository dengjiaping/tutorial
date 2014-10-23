/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QCollege.java 2014-10-13 17:36
 */

package com.nonobank.user.domain.dict;

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
import static com.nonobank.user.domain.dict.College.*;
import static java.sql.Types.*;

/**
 * QCollege is a Querydsl query type for College
 * @version $Id: QCollege.java 198 2014-10-17 02:35:50Z fuchun $
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QCollege extends RelationalPathBase<College> {

    public static final String COLLEGE_TABLE = "DICT_COLLEGE";

    /**
     * 默认使用{@code cd} 作为别名的实例。
     */
    public static final QCollege qc = new QCollege("col");

    public final NumberPath<Integer> id = createNumber(PROP_ID, Integer.class);

    public final StringPath name = createString(PROP_NAME);

    public final NumberPath<Long> nameSrc = createNumber(PROP_NAME_CRC, Long.class);

    public final NumberPath<Integer> stateCode = createNumber(PROP_STATE_CODE, Integer.class);

    public final NumberPath<Short> grade = createNumber(PROP_GRADE, Short.class);

    public final BooleanPath enabled = createBoolean(PROP_ENABLED);

    public final PrimaryKey<College> primary = createPrimaryKey(id);

    public QCollege(String variable) {
        super(College.class, forVariable(variable), "public", COLLEGE_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QCollege(Path<? extends College> path) {
        super((Class) path.getType(), path.getMetadata(), "public", COLLEGE_TABLE);
        addMetadatas();
    }

    public QCollege(PathMetadata<?> metadata) {
        super(College.class, metadata, "public", COLLEGE_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code College} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QCollege(String variable, String schema, String table) {
        super(College.class, variable, schema, table);
        addMetadatas();
    }

    protected void addMetadatas() {
        addMetadata(id, named("ID").ofType(INTEGER));
        addMetadata(name, named("C_NAME").ofType(VARCHAR).withSize(100));
        addMetadata(nameSrc, named("C_NAME_CRC").ofType(BIGINT));
        addMetadata(stateCode, named("STATE_CODE").ofType(INTEGER));
        addMetadata(grade, named("C_GRADE").ofType(TINYINT).withSize(4));
        addMetadata(enabled, named("ENABLED").ofType(TINYINT));
    }
}
