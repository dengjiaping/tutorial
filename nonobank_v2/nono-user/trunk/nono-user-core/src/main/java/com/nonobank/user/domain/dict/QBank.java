/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QBank.java 2014-10-16 10:37
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
import static com.nonobank.user.domain.dict.Bank.*;
import static java.sql.Types.*;

/**
 * QBank is a Querydsl query type for Bank
 * @version $Id: QBank.java 183 2014-10-16 03:14:52Z fuchun $
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QBank extends RelationalPathBase<Bank> {

    public static final String BANK_TABLE = "DICT_BANK";

    /**
     * 默认使用{@code cd} 作为别名的实例。
     */
    public static final QBank qb = new QBank("b");

    public final NumberPath<Integer> id = createNumber(PROP_ID, Integer.class);

    public final StringPath name = createString(PROP_NAME);

    public final NumberPath<Integer> locCode = createNumber(PROP_LOC_CODE, Integer.class);

    public final NumberPath<Integer> parentId = createNumber(PROP_PARENT_ID, Integer.class);

    public final PrimaryKey<Bank> primary = createPrimaryKey(id);

    public QBank(String variable) {
        super(Bank.class, forVariable(variable), "public", BANK_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QBank(Path<? extends Bank> path) {
        super((Class) path.getType(), path.getMetadata(), "public", BANK_TABLE);
        addMetadatas();
    }

    public QBank(PathMetadata<?> metadata) {
        super(Bank.class, metadata, "public", BANK_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code Bank} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QBank(String variable, String schema, String table) {
        super(Bank.class, variable, schema, table);
        addMetadatas();
    }

    protected void addMetadatas() {
        addMetadata(id, named("ID").ofType(INTEGER));
        addMetadata(name, named("BANK_NAME").ofType(VARCHAR).withSize(100));
        addMetadata(locCode, named("LOC_CODE").ofType(INTEGER));
        addMetadata(parentId, named("PARENT_ID").ofType(INTEGER));
    }
}
