/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) CommonDict.java 2014-10-10 15:08
 */

package com.nonobank.user.domain.dict;

import com.fasterxml.jackson.annotation.JsonView;
import com.nonobank.common.json.Views;
import org.springframework.data.domain.Sort;

/**
 * 分类字典数据信息实体。
 *
 * @author fuchun
 * @version $Id: CommonDict.java 254 2014-10-23 03:00:31Z fuchun $
 * @since 2.0
 */
public class CommonDict extends AbstractDict<CommonDict> {

    public static final String PROP_TYPE_KEY = "typeKey";
    public static final Sort DEFAULT_SORT = new Sort(
            Sort.Direction.ASC, PROP_ORDER_NO);

    private static final long serialVersionUID = -992567511874854703L;

    private String typeKey;

    public CommonDict() {
        super();
    }

    public CommonDict(String typeKey) {
        super();
        this.typeKey = typeKey;
    }

    public CommonDict(String typeKey, String code, String i18nKey, String name, Integer orderNO) {
        super(code, i18nKey, name, orderNO);
        this.typeKey = typeKey;
    }

    // full constructor
    public CommonDict(Integer id, String typeKey, String code, String i18nKey, String name, Integer orderNO) {
        super(code, i18nKey, name, orderNO);
        setId(id);
        this.typeKey = typeKey;
    }

    /**
     * 返回类型关键字。
     */
    @JsonView(Views.Internal.class)
    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    @Override
    public String toString() {
        return toStringHelper()
                .add(PROP_ORDER_NO, getOrderNO())
                .toString();
    }
}
