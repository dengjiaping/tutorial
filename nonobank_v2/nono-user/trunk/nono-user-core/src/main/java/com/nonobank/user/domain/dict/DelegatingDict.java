/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) DelegatingDict.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.dict;

/**
 * {@code Dict} 接口的委托实现。
 *
 * @author fuchun
 * @version $Id: DelegatingDict.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public final class DelegatingDict implements Dict {

    private static final long serialVersionUID = 6095173645581980363L;

    public static DelegatingDict of(Dict actualDict) {
        return new DelegatingDict(actualDict);
    }

    private final Dict actualDict;

    DelegatingDict(Dict actualDict) {
        this.actualDict = actualDict;
    }

    @Override
    public String getCode() {
        return actualDict.getCode();
    }

    @Override
    public String getI18nKey() {
        return actualDict.getI18nKey();
    }

    @Override
    public String getName() {
        return actualDict.getName();
    }

    @Override
    public Integer getOrderNO() {
        return actualDict.getOrderNO();
    }

    @Override
    public String toString() {
        return String.format("Dict delegating to %s", actualDict);
    }
}
