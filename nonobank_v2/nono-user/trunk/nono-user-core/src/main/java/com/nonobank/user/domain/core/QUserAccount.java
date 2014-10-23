/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QUserAccount.java 2014-10-10 10:10
 */

package com.nonobank.user.domain.core;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.BooleanPath;
import com.mysema.query.types.path.EnumPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.nonobank.data.domain.QAbstractRecording;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.core.UserAccount.*;
import static java.sql.Types.*;

/**
 * QUserAccount is a Querydsl query type for QUserAccount
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserAccount extends QAbstractRecording<UserAccount> {

    public static final String USER_ACCOUNT_TABLE = "USER_ACCOUNT";

    /**
     * 默认使用{@code ua} 作为别名的实例。
     */
    public static final QUserAccount qua = new QUserAccount("ua");

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final StringPath userName = createString(PROP_USER_NAME);

    public final StringPath hashedKey = createString(PROP_HASHED_KEY);

    public final StringPath avatar = createString(PROP_AVATAR);

    public final StringPath mobileNO = createString(PROP_MOBILE_NO);

    //public final BooleanPath mobileVerified = createBoolean(PROP_MOBILE_VERIFIED);

//    public final StringPath email = createString(PROP_EMAIL);

    //public final BooleanPath emailVerified = createBoolean(PROP_MOBILE_VERIFIED);

    public final StringPath oldHashedPasswd = createString(PROP_OLD_HASHED_PASSWD);

    public final StringPath hashedPasswd = createString(PROP_HASHED_PASSWD);

    public final StringPath passwdSalt = createString(PROP_PASSWD_SALT);

    public final StringPath passwdQuestion = createString(PROP_PASSWD_QUESTION);

    public final StringPath passwdAnswer = createString(PROP_PASSWD_ANSWER);

    public final StringPath answerSalt = createString(PROP_ANSWER_SALT);

    public final EnumPath<UserStatus> status = createEnum(PROP_STATUS, UserStatus.class);

    public final BooleanPath deleted = createBoolean(PROP_DELETED);

    public final PrimaryKey<UserAccount> primary = createPrimaryKey(userId);

    public QUserAccount(String variable) {
        super(UserAccount.class, forVariable(variable), "public", USER_ACCOUNT_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserAccount(Path<? extends UserAccount> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_ACCOUNT_TABLE);
        addMetadatas();
    }

    public QUserAccount(PathMetadata<?> metadata) {
        super(UserAccount.class, metadata, "public", USER_ACCOUNT_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code UserAccount} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QUserAccount(String variable, String schema, String table) {
        super(UserAccount.class, variable, schema, table);
    }

    protected void addMetadatas() {
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(userName, named("USER_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(hashedKey, named("HASHED_KEY").ofType(VARCHAR).withSize(40));
        addMetadata(avatar, named("AVATAR").ofType(VARCHAR).withSize(50));
        addMetadata(mobileNO, named("MOBILE_NO").ofType(VARCHAR).withSize(20));
        addMetadata(oldHashedPasswd, named("OLD_HASHED_PASSWD").ofType(VARCHAR).withSize(40));
        addMetadata(hashedPasswd, named("HASHED_PASSWD").ofType(VARCHAR).withSize(100));
        addMetadata(passwdSalt, named("HASHED_SALT").ofType(VARCHAR).withSize(20));
        addMetadata(passwdQuestion, named("PASSWD_QUESTION").ofType(VARCHAR).withSize(100));
        addMetadata(passwdAnswer, named("PASSWD_ANSWER").ofType(VARCHAR).withSize(50));
        addMetadata(answerSalt, named("ANSWER_SALT").ofType(VARCHAR).withSize(20));
        addMetadata(status, named("STATUS").ofType(TINYINT));
        addMetadata(deleted, named("IS_DELETED").ofType(TINYINT).withSize(2));
        addRecordingMetadata();
    }
}