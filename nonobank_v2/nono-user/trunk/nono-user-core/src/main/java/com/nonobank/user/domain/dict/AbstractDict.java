/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) AbstractDict.java 2014-10-10 16:18
 */

package com.nonobank.user.domain.dict;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.base.MoreObjects;
import com.nonobank.common.json.Views;
import com.nonobank.data.domain.AbstractEntity;

/**
 * {@code Dict} 接口的骨干实现。
 *
 * @author fuchun
 * @version $Id: AbstractDict.java 256 2014-10-23 03:29:06Z fuchun $
 * @since 2.0
 */
public abstract class AbstractDict<E extends AbstractDict<E>>
        extends AbstractEntity<Integer, E> implements Dict {

    public static final String PROP_CODE = "code";
    public static final String PROP_I18N_KEY = "i18nKey";
    public static final String PROP_ORDER_NO = "orderNO";

    private static final long serialVersionUID = -6735229968217500028L;

    private String code;
    private String i18nKey;
    private String name;
    private Integer orderNO;

    protected AbstractDict() {
        super();
    }

    protected AbstractDict(String code, String i18nKey, String name, Integer orderNO) {
        this.code = code;
        this.i18nKey = i18nKey;
        this.name = name;
        this.orderNO = orderNO;
    }

    @Override
    @JsonView(Views.ExtendedPublic.class)
    public Integer getId() {
        return super.getId();
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    @JsonView(Views.ExtendedPublic.class)
    public String getI18nKey() {
        return i18nKey;
    }

    public void setI18nKey(String i18nKey) {
        this.i18nKey = i18nKey;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(Integer orderNO) {
        this.orderNO = orderNO;
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(getClass())
                .add(PROP_ID, getId())
                .add(PROP_CODE, getCode())
                .add(PROP_I18N_KEY, getI18nKey())
                .add(PROP_NAME, getName())
                .add(PROP_ORDER_NO, getOrderNO());
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }
}