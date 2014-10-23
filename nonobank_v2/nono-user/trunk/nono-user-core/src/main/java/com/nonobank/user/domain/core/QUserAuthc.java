/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QUserAuthc.java 2014-10-13 10:27
 */

package com.nonobank.user.domain.core;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;
import com.nonobank.data.domain.QAbstractRecording;
import com.nonobank.user.domain.dict.Dict;
import org.joda.time.DateTime;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.data.domain.Entity.PROP_USER_ID;
import static com.nonobank.user.domain.core.UserAuthc.*;
import static com.nonobank.user.domain.core.UserProfile.PROP_EDUCATION;
import static java.sql.Types.*;

/**
 * QUserAuthc is a Querydsl query type for UserAuthc
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserAuthc extends QAbstractRecording<UserAuthc> {

    public static final String USER_AUTHC_TABLE = "USER_AUTHC";

    /**
     * 默认使用{@code uac} 作为别名的实例。
     */
    public static final QUserAuthc quac = new QUserAuthc("uac");

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final StringPath userName = createString(PROP_USER_NAME);

    public final StringPath email = createString(PROP_EMAIL);

    public final BooleanPath emailVerified = createBoolean(PROP_EMAIL_VERIFIED);

    public final StringPath mobileNO = createString(PROP_MOBILE_NO);

    public final BooleanPath mobileVerified = createBoolean(PROP_MOBILE_VERIFIED);

    public final StringPath avatar = createString(PROP_AVATAR);

    public final EnumPath<AvatarAuthcStatus> avatarStatus = createEnum(PROP_AVATAR_STATUS, AvatarAuthcStatus.class);
    // 身份认证
    public final StringPath realName = createString(PROP_REAL_NAME);

    public final StringPath idCard = createString(PROP_ID_CARD);

    public final BooleanPath cardVerified = createBoolean(PROP_CARD_VERIFIED);
    // 学历认证
    public final SimplePath<Dict> education = createSimple(PROP_EDUCATION, Dict.class);

    public final StringPath diploma = createString(PROP_DIPLOMA);

    public final StringPath eduValidCode = createString(PROP_EDU_VALID_CODE);

    public final DateTimePath<DateTime> eduCreateTime = createDateTime(PROP_EDU_CREATE_TIME, DateTime.class);

    public final BooleanPath eduVerified = createBoolean(PROP_EDU_VERIFIED);
    // 学籍认证
    public final StringPath profession = createString(PROP_PROFESSION);

    public final StringPath stuNumber = createString(PROP_STU_NUMBER);

    public final StringPath univLocation = createString(PROP_UNIV_LOCATION);

    public final StringPath univName = createString(PROP_UNIV_NAME);

    public final StringPath campus = createString(PROP_CAMPUS);

    public final NumberPath<Integer> entranceYear = createNumber(PROP_ENTRANCE_YEAR, Integer.class);

    public final BooleanPath stuVerified = createBoolean(PROP_STU_VERIFIED);
    // 脸纹认证
    public final BooleanPath faceVerified = createBoolean(PROP_FACE_VERIFIED);

    public final PrimaryKey<UserAuthc> primary = createPrimaryKey(userId);

    public QUserAuthc(String variable) {
        super(UserAuthc.class, forVariable(variable), "public", USER_AUTHC_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserAuthc(Path<? extends UserAuthc> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_AUTHC_TABLE);
        addMetadatas();
    }

    public QUserAuthc(PathMetadata<?> metadata) {
        super(UserAuthc.class, metadata, "public", USER_AUTHC_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code UserAuthc} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QUserAuthc(String variable, String schema, String table) {
        super(UserAuthc.class, variable, schema, table);
    }

    protected void addMetadatas() {
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(userName, named("USER_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(email, named("EMAIL").ofType(VARCHAR).withSize(50));
        addMetadata(emailVerified, named("EMAIL_VERIFIED").ofType(TINYINT));
        addMetadata(mobileNO, named("MOBILE_NO").ofType(VARCHAR).withSize(20));
        addMetadata(mobileVerified, named("MOBILE_VERIFIED").ofType(TINYINT));
        addMetadata(avatar, named("AVATAR").ofType(VARCHAR).withSize(255));
        addMetadata(avatarStatus, named("AVATAR_STATUS").ofType(TINYINT));
        addMetadata(realName, named("REAL_NAME").ofType(VARCHAR).withSize(20));
        addMetadata(idCard, named("ID_CARD").ofType(VARCHAR).withSize(20));
        addMetadata(cardVerified, named("CARD_VERIFIED").ofType(TINYINT));
        addMetadata(education, named("EDUCATION").ofType(VARCHAR).withSize(2));
        addMetadata(diploma, named("DIPLOMA").ofType(VARCHAR).withSize(255));
        addMetadata(eduValidCode, named("EDU_VALID_CODE").ofType(VARCHAR).withSize(50));
        addMetadata(eduCreateTime, named("EDU_CREATE_TIME").ofType(TIMESTAMP));
        addMetadata(eduVerified, named("EDU_VERIFIED").ofType(TINYINT));
        addMetadata(profession, named("PROFESSION").ofType(VARCHAR).withSize(50));
        addMetadata(stuNumber, named("STU_NUMBER").ofType(VARCHAR).withSize(20));
        addMetadata(univLocation, named("UNIV_LOCATION").ofType(VARCHAR).withSize(20));
        addMetadata(univName, named("UNIV_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(campus, named("CAMPUS").ofType(VARCHAR).withSize(50));
        addMetadata(entranceYear, named("ENTRANCE_YEAR").ofType(INTEGER));
        addMetadata(stuVerified, named("STU_VERIFIED").ofType(TINYINT));
        addMetadata(faceVerified, named("FACE_VERIFIED").ofType(TINYINT));
        addRecordingMetadata();
    }
}
