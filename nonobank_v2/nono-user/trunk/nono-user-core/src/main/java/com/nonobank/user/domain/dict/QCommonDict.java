/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QCommonDict.java 2014-10-10 15:24
 */

package com.nonobank.user.domain.dict;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.nonobank.data.domain.QAbstractRecording;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.dict.CommonDict.*;
import static java.sql.Types.*;

/**
 * QCommonDict is a Querydsl query type for CommonDict
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QCommonDict extends QAbstractRecording<CommonDict> {

    public static final String COMMON_DICT_TABLE = "DICT_COMMON";

    /**
     * 默认使用{@code cd} 作为别名的实例。
     */
    public static final QCommonDict qcd = new QCommonDict("cd");

    public final NumberPath<Integer> id = createNumber(PROP_ID, Integer.class);

    public final StringPath typeKey = createString(PROP_TYPE_KEY);

    public final StringPath code = createString(PROP_CODE);

    public final StringPath i18nKey = createString(PROP_I18N_KEY);

    public final StringPath name = createString(PROP_NAME);

    public final NumberPath<Integer> orderNO = createNumber(PROP_ORDER_NO, Integer.class);

    public final PrimaryKey<CommonDict> primary = createPrimaryKey(id);

    public QCommonDict(String variable) {
        super(CommonDict.class, forVariable(variable), "public", COMMON_DICT_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QCommonDict(Path<? extends CommonDict> path) {
        super((Class) path.getType(), path.getMetadata(), "public", COMMON_DICT_TABLE);
        addMetadatas();
    }

    public QCommonDict(PathMetadata<?> metadata) {
        super(CommonDict.class, metadata, "public", COMMON_DICT_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code CommonDict} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QCommonDict(String variable, String schema, String table) {
        super(CommonDict.class, variable, schema, table);
        addMetadatas();
    }

    protected void addMetadatas() {
        addMetadata(id, named("ID").ofType(INTEGER));
        addMetadata(typeKey, named("TYPE_KEY").ofType(VARCHAR).withSize(50));
        addMetadata(code, named("D_CODE").ofType(VARCHAR).withSize(10));
        addMetadata(i18nKey, named("I18N_KEY").ofType(VARCHAR).withSize(100));
        addMetadata(name, named("D_NAME").ofType(VARCHAR).withSize(20));
        addMetadata(orderNO, named("ORDER_NO").ofType(INTEGER).withSize(8));
    }
}
