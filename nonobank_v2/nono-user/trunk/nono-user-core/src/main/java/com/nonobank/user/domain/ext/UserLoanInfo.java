/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserLoanData.java 2014-10-11 09:04
 */

package com.nonobank.user.domain.ext;

import com.google.common.base.MoreObjects;
import com.nonobank.user.domain.core.BaseUser;

import java.math.BigDecimal;

/**
 * 用户借款所需相关信息实体
 *
 * @author Yichuan
 * @version $Id: UserLoanInfo.java 248 2014-10-22 08:12:56Z yichuan $
 * @since 2.0
 */
public class UserLoanInfo extends BaseUser<UserLoanInfo> {

    public static final String PROP_WORK_DATUM = "workDatum";
    public static final String PROP_RELATIVE = "relative";
    public static final String PROP_WORKMATE = "workmate";
    public static final String PROP_MONTH_INCOME = "monthIncome";
    public static final String PROP_MONTH_WAGE = "monthWage";
    public static final String PROP_CREDIT_LINES = "creditLines";
    public static final String PROP_ISSUING_BANK = "issuingBank";
    public static final String PROP_ASSET_VALUE = "assetValue";
    public static final String PROP_ASSET_DESC = "assetDesc";
    public static final String PROP_LIABILTIES = "liabilities";

    public static final String PROP_LOAN_EXT = "loanExt";

    private static final long serialVersionUID = 6391360692684472632L;

    // 用户名
    private String userName;

    // 工作单位信息
    private String workDatum;

    // 亲属信息
    private String relative;
    // 同事信息
    private String workmate;
    // 资产信息
    // 月收入
    private BigDecimal monthIncome;
    // 打卡工资
    private BigDecimal monthWage;
    // 单张信用卡最高额度
    private BigDecimal creditLines;
    // 发卡银行
    private String issuingBank;
    // 资产信息
    private Integer assetValue;
    // 资产说明
    private String assetDesc;

    // 负债信息
    private String liabilities;

    // 扩展字段
    private String loanExt;

    public UserLoanInfo() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWorkDatum() {
        return workDatum;
    }

    public void setWorkDatum(String workDatum) {
        this.workDatum = workDatum;
    }

    public String getRelative() {
        return relative;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }

    public String getWorkmate() {
        return workmate;
    }

    public void setWorkmate(String workmate) {
        this.workmate = workmate;
    }

    public BigDecimal getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(BigDecimal monthIncome) {
        this.monthIncome = monthIncome;
    }

    public BigDecimal getMonthWage() {
        return monthWage;
    }

    public void setMonthWage(BigDecimal monthWage) {
        this.monthWage = monthWage;
    }

    public BigDecimal getCreditLines() {
        return creditLines;
    }

    public void setCreditLines(BigDecimal creditLines) {
        this.creditLines = creditLines;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public Integer getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(Integer assetValue) {
        this.assetValue = assetValue;
    }

    public String getAssetDesc() {
        return assetDesc;
    }

    public void setAssetDesc(String assetDesc) {
        this.assetDesc = assetDesc;
    }

    public String getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(String liabilities) {
        this.liabilities = liabilities;
    }

    public String getLoanExt() {
        return loanExt;
    }

    public void setLoanExt(String loanExt) {
        this.loanExt = loanExt;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_USER_ID, getUserId()).add(PROP_USER_NAME, getUserName())
                .add(PROP_WORK_DATUM, getWorkmate()).add(PROP_RELATIVE, getRelative())
                .add(PROP_WORKMATE, getWorkmate()).add(PROP_MONTH_INCOME, getMonthIncome())
                .add(PROP_MONTH_WAGE, getMonthWage()).add(PROP_CREDIT_LINES, getCreditLines())
                .add(PROP_ISSUING_BANK, getIssuingBank()).add(PROP_ASSET_VALUE, getAssetValue())
                .add(PROP_ASSET_DESC, getAssetDesc()).add(PROP_LIABILTIES, getLiabilities())
                .add(PROP_LOAN_EXT, getLoanExt())
                .add(PROP_LAST_MODIFIED_DATE, getLastModifiedDate())
                .add(PROP_CREATED_DATE, getCreatedDate()).toString();
    }
}
