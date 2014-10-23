/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) BeanUtilsBeanHashMapper.java 2014-10-08 14:37
 */

package com.nonobank.data.redis;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.data.redis.hash.HashMapper;

import java.util.Map;

/**
 *  HashMapper based on Apache Commons BeanUtils project. Does NOT supports nested properties.
 *
 * @author fuchun
 * @version $Id: BeanUtilsBeanHashMapper.java 47 2014-10-08 07:39:43Z fuchun $
 * @since 2.0
 */
public class BeanUtilsBeanHashMapper<T> implements HashMapper<T, String, String> {

    private final Class<T> type;
    private final BeanUtilsBean bub;

    public BeanUtilsBeanHashMapper(Class<T> type) {
        this(type, BeanUtilsBean.getInstance());
    }

    public BeanUtilsBeanHashMapper(Class<T> type, BeanUtilsBean bub) {
        super();
        this.type = type;
        this.bub = bub;
    }

    @Override
    public Map<String, String> toHash(T object) {
        try {
            return bub.describe(object);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Cannot describe object " + object);
        }
    }

    @Override
    public T fromHash(Map<String, String> hash) {
        T instance = org.springframework.beans.BeanUtils.instantiate(type);
        try {
            bub.populate(instance, hash);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return instance;
    }

    public BeanUtilsBean getBeanUtilsBean() {
        return bub;
    }
}