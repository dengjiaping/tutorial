/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) ScoreCapitalPrefer.java 2014-10-15 11:22
 */

package com.nonobank.user.domain.ext.capital;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 积分等级对应相关资本信息实体
 *
 * @author Yichuan
 * @version $Id: ScoreCapitalInfo.java 176 2014-10-15 09:11:14Z yichuan $
 * @since 2.0
 */
public class ScoreCapitalInfo implements Serializable {

    private static final long serialVersionUID = -8524611254977503506L;

    // 类型(对应CapitalType)
    private CapitalType type;
    // 享受最低利率
    private Double minRate;
    // 最大金额
    private BigDecimal maxAmount;
    // 最大可担保额度
    private BigDecimal maxGuarantee;
    // 最高可担保额度系数
    private Double guaranteeRate;

    public ScoreCapitalInfo() {
        super();
    }

    public CapitalType getType() {
        return type;
    }

    public void setType(CapitalType type) {
        this.type = type;
    }

    public Double getMinRate() {
        return minRate;
    }

    public void setMinRate(Double minRate) {
        this.minRate = minRate;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public BigDecimal getMaxGuarantee() {
        return maxGuarantee;
    }

    public void setMaxGuarantee(BigDecimal maxGuarantee) {
        this.maxGuarantee = maxGuarantee;
    }

    public Double getGuaranteeRate() {
        return guaranteeRate;
    }

    public void setGuaranteeRate(Double guaranteeRate) {
        this.guaranteeRate = guaranteeRate;
    }

    public ScoreCapitalInfo(CapitalType type, Double minRate, BigDecimal maxAmount,
                            BigDecimal maxGuarantee, Double guaranteeRate) {
        this.type = type;
        this.minRate = minRate;
        this.maxAmount = maxAmount;
        this.maxGuarantee = maxGuarantee;
        this.guaranteeRate = guaranteeRate;
    }

    public static ScoreCapitalInfo create(CapitalType type, Double minRate, BigDecimal maxAmount,
                                          BigDecimal maxGuarantee, Double guaranteeRate) {
        return new ScoreCapitalInfo(type, minRate, maxAmount, maxGuarantee, guaranteeRate);
    }

    public ScoreCapitalInfo(CapitalType type, Double minRate, BigDecimal maxAmount,
                            BigDecimal maxGuarantee) {
        this.type = type;
        this.minRate = minRate;
        this.maxAmount = maxAmount;
        this.maxGuarantee = maxGuarantee;
    }

    public static ScoreCapitalInfo create(CapitalType type, Double minRate, BigDecimal maxAmount,
                                          BigDecimal maxGuarantee) {
        return new ScoreCapitalInfo(type, minRate, maxAmount, maxGuarantee);
    }
}
