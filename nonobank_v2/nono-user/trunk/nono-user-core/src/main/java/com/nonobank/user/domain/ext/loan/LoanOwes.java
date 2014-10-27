/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) LoanOwes.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.ext.loan;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 各贷款债务信息
 *
 * @author Yichuan
 * @version $Id: LoanOwes.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class LoanOwes implements Serializable {

    private static final long serialVersionUID = -813736648099071596L;

    // 是否来源银行机构
    private boolean isBank;
    // 是否有抵押
    private boolean isPledge;
    // 欠款(未还金额)
    private BigDecimal arrear;
    // 每月还款
    private BigDecimal monthRepay;
    // 说明
    private String desc;

    public LoanOwes() {
        super();
    }

    public LoanOwes(boolean isBank, boolean isPledge, BigDecimal arrear, BigDecimal monthRepay, String desc) {
        this.isBank = isBank;
        this.isPledge = isPledge;
        this.arrear = arrear;
        this.monthRepay = monthRepay;
        this.desc = desc;
    }

    public boolean isBank() {
        return isBank;
    }

    public void setBank(boolean isBank) {
        this.isBank = isBank;
    }

    public boolean isPledge() {
        return isPledge;
    }

    public void setPledge(boolean isPledge) {
        this.isPledge = isPledge;
    }

    public BigDecimal getArrear() {
        return arrear;
    }

    public void setArrear(BigDecimal arrear) {
        this.arrear = arrear;
    }

    public BigDecimal getMonthRepay() {
        return monthRepay;
    }

    public void setMonthRepay(BigDecimal monthRepay) {
        this.monthRepay = monthRepay;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
