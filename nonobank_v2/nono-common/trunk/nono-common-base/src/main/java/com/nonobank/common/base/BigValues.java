/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) BigValues.java 2014-10-16 14:03
 */

package com.nonobank.common.base;

import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;
import com.nonobank.common.json.JsonMapper;

import javax.annotation.Nonnull;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 大数据文本值接口，提供常用的数据转换方法。
 *
 * @author fuchun
 * @version $Id: BigValues.java 186 2014-10-16 06:17:50Z fuchun $
 * @since 2.0
 */
public interface BigValues extends Values {

    String getBigValue();

    default <K, V> Map<K, V> jsonToMap(Class<K> keyClass, Class<V> valueClass) {
        return JsonMapper.getDefault().readToMap(getBigValue(), keyClass, valueClass);
    }

    default <K, V> Map<K, V> jsonToMap(Type keyType, Type valueType) {
        return JsonMapper.getDefault().readToMap(getBigValue(), keyType, valueType);
    }

    default <V> Map<String, V> jsonToMap(Class<V> valueClass) {
        return jsonToMap(String.class, valueClass);
    }

    default <V> Map<String, V> jsonToMap(Type valueType) {
        return jsonToMap(String.class, valueType);
    }

    default Map<String, Object> jsonToMap() {
        return jsonToMap(Object.class);
    }

    default <E> List<E> jsonToList(Class<E> elClass) {
        return JsonMapper.getDefault().readToList(getBigValue(), elClass);
    }

    default <E> List<E> jsonToList(Type elType) {
        return JsonMapper.getDefault().readToList(getBigValue(), elType);
    }

    @Nonnull
    default <E> List<E> parseToList(String separator, Function<String, E> mapper) {
        final String s = MoreObjects.firstNonNull(separator, ",");
        List<String> list = Splitter.on(s).trimResults()
                .splitToList(getBigValue());
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        return list.stream().map(mapper).collect(Collectors.toList());
    }
}
