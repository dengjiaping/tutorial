/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QUserEducation.java 2014-10-13 13:57
 */

package com.nonobank.user.domain.ext;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EnumPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.nonobank.data.domain.QAbstractRecording;
import com.nonobank.user.domain.dict.Education;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.ext.UserEducation.*;
import static java.sql.Types.*;

/**
 * QUserEducation is a Querydsl query type for UserEducation
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserEducation extends QAbstractRecording<UserEducation> {

    public static final String USER_EDUCATION_TABLE = "USER_EDUCATION";

    /**
     * 默认使用{@code ue} 作为别名的实体。
     */
    public static final QUserEducation que = new QUserEducation("ue");

    public final NumberPath<Long> id = createNumber(PROP_ID, Long.class);
    // 用户ID
    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);
    // 用户名
    public final StringPath userName = createString(PROP_USER_NAME);
    // 学校名称
    public final StringPath schoolName = createString(PROP_SCHOOL_NAME);
    // 专业
    public final StringPath profession = createString(PROP_PROFESSION);
    // 学历
    public final EnumPath<Education> education = createEnum(PROP_EDUCATION, Education.class);
    // 开始-年
    public final NumberPath<Integer> startYear = createNumber(PROP_START_YEAR, Integer.class);
    // 开始-月
    public final NumberPath<Integer> startMonth = createNumber(PROP_START_MONTH, Integer.class);
    // 截止-年
    public final NumberPath<Integer> endYear = createNumber(PROP_END_YEAR, Integer.class);
    // 截止-月
    public final NumberPath<Integer> endMonth = createNumber(PROP_END_MONTH, Integer.class);
    // 备注
    public final StringPath remarks = createString(PROP_REMARKS);

    public final PrimaryKey<UserEducation> primary = createPrimaryKey(id);

    public QUserEducation(String variable) {
        super(UserEducation.class, forVariable(variable), "public", USER_EDUCATION_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserEducation(Path<? extends UserEducation> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_EDUCATION_TABLE);
        addMetadatas();
    }

    public QUserEducation(PathMetadata<?> metadata) {
        super(UserEducation.class, metadata, "public", USER_EDUCATION_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code UserEducation} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QUserEducation(String variable, String schema, String table) {
        super(UserEducation.class, variable, schema, table);
    }

    protected void addMetadatas() {
        addMetadata(id, named("ID").ofType(BIGINT));
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(userName, named("USER_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(schoolName, named("SCHOOL_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(profession, named("PROFESSION").ofType(VARCHAR).withSize(50));
        addMetadata(education, named("EDUCATION").ofType(VARCHAR).withSize(2));
        addMetadata(startYear, named("START_YEAR").ofType(INTEGER));
        addMetadata(startMonth, named("START_MONTH").ofType(INTEGER));
        addMetadata(endYear, named("END_YEAR").ofType(INTEGER));
        addMetadata(endMonth, named("END_MONTH").ofType(INTEGER));
        addMetadata(remarks, named("REMARKS").ofType(VARCHAR).withSize(200));

        addRecordingMetadata();
    }
}
