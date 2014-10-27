/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QUserStudent.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.sql.RelationalPathBase;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.ext.UserStudent.*;
import static java.sql.Types.*;

/**
 * QUserStudent is a Querydsl query type for UserStudent
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserStudent extends RelationalPathBase<UserStudent> {

    public static final String USER_STUDENT_TABLE = "USER_STUDENT";

    public static final QUserStudent qust = new QUserStudent("ust");

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final StringPath userName = createString(PROP_USER_NAME);

    public final NumberPath<Integer> collegeId = createNumber(PROP_COLLEGE_ID, Integer.class);

    public final StringPath collegeName = createString(PROP_COLLEGE_NAME);

    public final StringPath campus = createString(PROP_CAMPUS);

    public final StringPath major = createString(PROP_MAJOR);

    public final StringPath studentNO = createString(PROP_STUDENT_NO);

    public final NumberPath<Integer> attnYear = createNumber(PROP_ATTN_YEAR, Integer.class);

    public final StringPath eduCode = createString(PROP_EDU_CODE);

    public final PrimaryKey<UserStudent> primary = createPrimaryKey(userId);

    public QUserStudent(String variable) {
        super(UserStudent.class, forVariable(variable), "public", USER_STUDENT_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserStudent(Path<? extends UserStudent> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_STUDENT_TABLE);
        addMetadatas();
    }

    public QUserStudent(PathMetadata<?> metadata) {
        super(UserStudent.class, metadata, "public", USER_STUDENT_TABLE);
        addMetadatas();
    }

    public QUserStudent(String variable, String schema, String table) {
        super(UserStudent.class, variable, schema, table);
    }

    public void addMetadatas() {
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(collegeId, named("COLLEGE_ID").ofType(BIGINT));
        addMetadata(collegeName, named("COLLEGE_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(campus, named("CAMPUS").ofType(VARCHAR).withSize(50));
        addMetadata(major, named("MAJOR").ofType(VARCHAR).withSize(50));
        addMetadata(studentNO, named("STUDENT_NO").ofType(VARCHAR).withSize(20));
        addMetadata(attnYear, named("ATTN_YEAR").ofType(SMALLINT));
        addMetadata(eduCode, named("EDU_CODE").ofType(VARCHAR).withSize(250));
    }
}