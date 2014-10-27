/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) QUserProfile.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.core;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;
import com.nonobank.common.base.Gender;
import com.nonobank.data.domain.QAbstractRecording;
import com.nonobank.user.domain.dict.Dict;
import com.nonobank.user.domain.dict.Exist;
import org.joda.time.DateTime;

import javax.annotation.Generated;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.core.UserProfile.*;
import static java.sql.Types.*;

/**
 * QUserProfile is a Querydsl query type for QUserProfile
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserProfile extends QAbstractRecording<UserProfile> {

    public static final String USER_PROFILE_TABLE = "USER_PROFILE";

    /**
     * 默认使用{@code ua} 作为别名的实例。
     */
    public static final QUserProfile qup = new QUserProfile("up");

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final StringPath userName = createString(PROP_USER_NAME);

    public final StringPath hashedKey = createString(PROP_HASHED_KEY);

    public final StringPath englishName = createString(PROP_ENGLISH_NAME);

    public final StringPath formerName = createString(PROP_FORMER_NAME);

    public final StringPath mobileNO = createString(PROP_MOBILE_NO);

    public final StringPath mobileNO2 = createString(PROP_MOBILE_NO2);

    public final BooleanPath mobileVerified = createBoolean(PROP_MOBILE_VERIFIED);

    public final StringPath email = createString(PROP_EMAIL);

    public final BooleanPath emailVerified = createBoolean(PROP_EMAIL_VERIFIED);

    public final StringPath idCard = createString(PROP_ID_CARD);

    public final StringPath realName = createString(PROP_REAL_NAME);

    public final EnumPath<Gender> gender = createEnum(PROP_GENDER, Gender.class);

    public final NumberPath<Integer> age = createNumber(PROP_AGE, Integer.class);

    public final StringPath censusProvince = createString(PROP_CENSUS_PROVINCE);

    public final StringPath censusCity = createString(PROP_CENSUS_CITY);

    public final StringPath censusAddress = createString(PROP_CENSUS_ADDRESS);

    public final StringPath liveProvince = createString(PROP_LIVE_PROVINCE);

    public final StringPath liveCity = createString(PROP_LIVE_CITY);

    public final StringPath liveAddress = createString(PROP_LIVE_ADDRESS);

    public final StringPath liveContact = createString(PROP_LIVE_CONTACT);

    public final StringPath qq = createString(PROP_QQ);

    public final SimplePath<Dict> marriage = createSimple(PROP_MARRIAGE, Dict.class);

    public final SimplePath<Dict> education = createSimple(PROP_EDUCATION, Dict.class);

    public final SimplePath<Dict> position = createSimple(PROP_POSITION, Dict.class);

    public final SimplePath<Dict> skillCert = createSimple(PROP_SKILL_CERT, Dict.class);

    public final EnumPath<Exist> socialSecurity = createEnum(PROP_SOCIAL_SECURITY, Exist.class);

    public final EnumPath<Exist> passport = createEnum(PROP_PASSPORT, Exist.class);

    public final EnumPath<Exist> driving = createEnum(PROP_DRIVING, Exist.class);

    public final StringPath userType = createString(PROP_USER_TYPE);

    public final DateTimePath<DateTime> userTypeTime = createDateTime(PROP_USER_TYPE_TIME, DateTime.class);

    public final PrimaryKey<UserProfile> primary = createPrimaryKey(userId);

    public QUserProfile(String variable) {
        super(UserProfile.class, forVariable(variable), "public", USER_PROFILE_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserProfile(Path<? extends UserProfile> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_PROFILE_TABLE);
        addMetadatas();
    }

    public QUserProfile(PathMetadata<?> metadata) {
        super(UserProfile.class, metadata, "public", USER_PROFILE_TABLE);
        addMetadatas();
    }

    /**
     * 构造一个指定别名、shema和表名的和{@code UserProfile} 关联的映射。
     *
     * @param variable 表别名。
     * @param schema 数据库 schema.
     * @param table 表名。
     */
    public QUserProfile(String variable, String schema, String table) {
        super(UserProfile.class, variable, schema, table);
    }

    protected void addMetadatas() {
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(userName, named("USER_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(hashedKey, named("HASHED_KEY").ofType(VARCHAR).withSize(40));
        addMetadata(englishName, named("ENGLISH_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(formerName, named("FORMER_NAME").ofType(VARCHAR).withSize(20));
        addMetadata(mobileNO, named("MOBILE_NO").ofType(VARCHAR).withSize(20));
        addMetadata(mobileVerified, named("MOBILE_VERIFIED").ofType(TINYINT));
        addMetadata(email, named("EMAIL").ofType(VARCHAR).withSize(50));
        addMetadata(emailVerified, named("EMAIL_VERIFIED").ofType(TINYINT));
        addMetadata(idCard, named("ID_CARD").ofType(VARCHAR).withSize(20));
        addMetadata(realName, named("REAL_NAME").ofType(VARCHAR).withSize(20));
        addMetadata(gender, named("GENDER").ofType(VARCHAR).withSize(1));
        addMetadata(age, named("AGE").ofType(INTEGER).withSize(4));

        addMetadata(censusProvince, named("CENSUS_PROVINCE").ofType(VARCHAR).withSize(20));
        addMetadata(censusCity, named("CENSUS_CITY").ofType(VARCHAR).withSize(30));
        addMetadata(censusAddress, named("CENSUS_ADDRESS").ofType(VARCHAR).withSize(100));

        addMetadata(liveProvince, named("LIVE_PROVINCE").ofType(VARCHAR).withSize(20));
        addMetadata(liveCity, named("LIVE_CITY").ofType(VARCHAR).withSize(30));
        addMetadata(liveAddress, named("LIVE_ADDRESS").ofType(VARCHAR).withSize(100));
        addMetadata(liveContact, named("LIVE_CONTACT").ofType(VARCHAR).withSize(100));
        addMetadata(qq, named("QQ").ofType(VARCHAR).withSize(20));

        addMetadata(marriage, named("MARRIAGE").ofType(VARCHAR).withSize(2));
        addMetadata(education, named("EDUCATION").ofType(VARCHAR).withSize(2));
        addMetadata(position, named("POSITION").ofType(VARCHAR).withSize(4));
        addMetadata(skillCert, named("POSITION").ofType(VARCHAR).withSize(2));
        addMetadata(socialSecurity, named("SOCIAL_SECURITY").ofType(VARCHAR).withSize(1));
        addMetadata(passport, named("PASSPORT").ofType(VARCHAR).withSize(1));
        addMetadata(driving, named("DRIVING").ofType(VARCHAR).withSize(1));

        addMetadata(userType, named("USER_TYPE").ofType(VARCHAR).withSize(20));
        addMetadata(userTypeTime, named("USER_TYPE_TIME").ofType(TIMESTAMP));
        addRecordingMetadata();
    }
}
