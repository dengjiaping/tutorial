/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) QUserLoanData.java 2014-10-14 13:22
 */

package com.nonobank.user.domain.ext;

import com.mysema.query.sql.PrimaryKey;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.nonobank.data.domain.QAbstractRecording;

import javax.annotation.Generated;
import java.math.BigDecimal;

import static com.mysema.query.sql.ColumnMetadata.named;
import static com.mysema.query.types.PathMetadataFactory.forVariable;
import static com.nonobank.user.domain.ext.UserLoanInfo.*;
import static java.sql.Types.*;

/**
 * QUserLoanInfo is a Querydsl query type for UserLoanInfo
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUserLoanInfo extends QAbstractRecording<UserLoanInfo> {

    public static final String USER_LOAN_INFO_TABLE = "USER_LOAN_INFO";

    /**
     * 默认使用{@code ue} 作为别名的实体。
     */
    public static final QUserLoanInfo quld = new QUserLoanInfo("uld");

    public final NumberPath<Long> userId = createNumber(PROP_USER_ID, Long.class);

    public final StringPath userName = createString(PROP_USER_NAME);
    // 工作单位信息
    public final StringPath workDatum = createString(PROP_WORK_DATUM);
    // 亲属信息
    public final StringPath relative = createString(PROP_RELATIVE);
    // 同事信息
    public final StringPath workmate = createString(PROP_WORKMATE);
    // 月收入
    public final NumberPath<BigDecimal> monthIncome = createNumber(PROP_MONTH_INCOME, BigDecimal.class);
    // 打卡工资
    public final NumberPath<BigDecimal> monthWage = createNumber(PROP_MONTH_WAGE, BigDecimal.class);
    // 单张信用卡最高额度
    public final NumberPath<BigDecimal> creditLines = createNumber(PROP_CREDIT_LINES, BigDecimal.class);
    // 发卡银行
    public final StringPath issuingBank = createString(PROP_ISSUING_BANK);
    // 资产信息
    public final NumberPath<Integer> assetValue = createNumber(PROP_ASSET_VALUE, Integer.class);
    // 资产说明
    public final StringPath assetDesc = createString(PROP_ASSET_DESC);
    // 债务信息
    public final StringPath liabilities = createString(PROP_LIABILTIES);

    public final StringPath loanExt = createString(PROP_LOAN_EXT);

    public final PrimaryKey<UserLoanInfo> primary = createPrimaryKey(userId);

    public QUserLoanInfo(String variable, String schema, String table) {
        super(UserLoanInfo.class, variable, schema, table);
    }

    public QUserLoanInfo(String variable) {
        super(UserLoanInfo.class, forVariable(variable), "public", USER_LOAN_INFO_TABLE);
        addMetadatas();
    }

    @SuppressWarnings("all")
    public QUserLoanInfo(Path<? extends UserEducation> path) {
        super((Class) path.getType(), path.getMetadata(), "public", USER_LOAN_INFO_TABLE);
        addMetadatas();
    }

    public QUserLoanInfo(PathMetadata<?> metadata) {
        super(UserLoanInfo.class, metadata, "public", USER_LOAN_INFO_TABLE);
        addMetadatas();
    }

    public void addMetadatas() {
        addMetadata(userId, named("USER_ID").ofType(BIGINT));
        addMetadata(userName, named("USER_NAME").ofType(VARCHAR).withSize(50));
        addMetadata(workDatum, named("WORK_DATUM").ofType(VARCHAR).withSize(1500));
        addMetadata(relative, named("RELATIVE").ofType(VARCHAR).withSize(200));
        addMetadata(workmate, named("WORKMATE").ofType(VARCHAR).withSize(100));
        addMetadata(monthIncome, named("MONTH_INCOME").ofType(DECIMAL).withSize(10).withDigits(2));
        addMetadata(monthWage, named("MONTH_WAGE").ofType(DECIMAL).withSize(10).withDigits(2));
        addMetadata(creditLines, named("CREDIT_LINES").ofType(DECIMAL).withSize(10).withDigits(2));
        addMetadata(issuingBank, named("ISSUING_BANK").ofType(VARCHAR).withSize(50));
        addMetadata(assetValue, named("ASSET_VALUE").ofType(INTEGER));
        addMetadata(assetDesc, named("ASSET_DESC").ofType(VARCHAR).withSize(100));
        addMetadata(liabilities, named("LIABILITIES").ofType(VARCHAR).withSize(1500));
        addMetadata(loanExt, named("LOAN_EXT").ofType(VARCHAR).withSize(2000));

        addRecordingMetadata();
    }
}
