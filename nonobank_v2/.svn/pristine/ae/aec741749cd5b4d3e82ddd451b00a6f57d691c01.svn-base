/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) ScoreCapitalInfoDTO.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.ext;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Yichuan
 * @version $Id$
 * @since 2.0
 */
public class ScoreCapitalInfoDTO implements Serializable {

    private static final long serialVersionUID = 2907754354552830798L;

    private final Short type;
    private final Double minRate;
    private final BigDecimal maxAmount;
    private final BigDecimal maxGuarantee;
    private final Double guaranteeRate;

    public ScoreCapitalInfoDTO(Short type, Double minRate, BigDecimal maxAmount,
                               BigDecimal maxGuarantee, Double guaranteeRate) {
        this.type = type;
        this.minRate = minRate;
        this.maxAmount = maxAmount;
        this.maxGuarantee = maxGuarantee;
        this.guaranteeRate = guaranteeRate;
    }

    public Short getType() {
        return type;
    }

    public Double getMinRate() {
        return minRate;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public BigDecimal getMaxGuarantee() {
        return maxGuarantee;
    }

    public Double getGuaranteeRate() {
        return guaranteeRate;
    }

    @Override
    public String toString() {
        return "ScoreCapitalInfoDTO{" +
                "type=%d" + type +
                ", minRate=" + minRate +
                ", maxAmount=" + maxAmount +
                ", maxGuarantee=" + maxGuarantee +
                ", guaranteeRate=" + guaranteeRate +
                '}';
    }
}
