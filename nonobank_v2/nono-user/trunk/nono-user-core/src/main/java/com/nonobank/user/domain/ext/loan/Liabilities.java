/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) Liabilities.java 2014-10-22 15:37
 */

package com.nonobank.user.domain.ext.loan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 负债信息
 *
 * @author Yichuan
 * @version $Id: Liabilities.java 248 2014-10-22 08:12:56Z yichuan $
 * @since 2.0
 */
public class Liabilities implements Serializable {

    private static final long serialVersionUID = -1278006444967052478L;

    // 信用卡透支总金额
    private BigDecimal creditOverdraft;
    // 信用卡每月还款
    private BigDecimal creditRepay;

    // 银行无抵押贷款总金额(bank unsecured loan)
    private BigDecimal usLoan;
    // 银行无抵押贷款每月还款(month repay of the bank unsecured loan)
    private BigDecimal usRepay;

    // 债务信息
    private List<LoanOwes> owes;

    public Liabilities() {
        super();
    }

    public BigDecimal getCreditOverdraft() {
        return creditOverdraft;
    }

    public void setCreditOverdraft(BigDecimal creditOverdraft) {
        this.creditOverdraft = creditOverdraft;
    }

    public BigDecimal getCreditRepay() {
        return creditRepay;
    }

    public void setCreditRepay(BigDecimal creditRepay) {
        this.creditRepay = creditRepay;
    }

    public BigDecimal getUsLoan() {
        return usLoan;
    }

    public void setUsLoan(BigDecimal usLoan) {
        this.usLoan = usLoan;
    }

    public BigDecimal getUsRepay() {
        return usRepay;
    }

    public void setUsRepay(BigDecimal usRepay) {
        this.usRepay = usRepay;
    }

    public List<LoanOwes> getOwes() {
        return owes;
    }

    public void setOwes(List<LoanOwes> owes) {
        this.owes = owes;
    }
}