/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) JsonMapper.java 2014-09-24 15:40
 */

package com.nonobank.common.json;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class provides JSON data serializer, deserializer; read, write.
 *
 * @author fuchun
 * @version $Id: JsonMapper.java 22 2014-09-24 07:45:00Z fuchun $
 * @since 2.0
 */
public interface JsonMapper {

    /**
     * Returns the default {@code JsonMapper} implementation of the Jackson2.
     */
    public static JsonMapper getDefault() {
        return JacksonJsonMapper.DEFAULT_MAPPER;
    }

    public <T> T convertValue(Map<String, Object> hashMap, Class<T> clazz);

    public String toJSONString(Object o);

    public byte[] toJSONBytes(Object o);

    public void writeValue(File resultFile, Object target) throws IOException;

    public void writeValue(OutputStream out, Object target) throws IOException;

    public <T> T readValue(File targetFile, Class<T> type) throws IOException;

    public <T> T readValue(File targetFile, Type type) throws IOException;

    public <T> T readValue(InputStream input, Class<T> type) throws IOException;

    public <T> T readValue(InputStream out, Type type) throws IOException;

    public <T> T readValue(String json, Class<T> clazz);

    public <T> T readValue(byte[] bytes, Class<T> clazz);

    public <T> T readValue(String json, Type type);

    public <T> T readValue(byte[] bytes, Type type);

    public <T> List<T> readToList(String json, Class<T> eClass);

    public <T> List<T> readToList(String json, Type eType);

    public <T> List<T> readToList(byte[] bytes, Class<T> eClass);

    public <T> List<T> readToList(byte[] bytes, Type eType);

    public <T> Set<T> readToSet(String json, Class<T> eClass);

    public <T> Set<T> readToSet(byte[] bytes, Class<T> eClass);

    public <T> Set<T> readToSet(String json, Type eType);

    public <T> Set<T> readToSet(byte[] bytes, Type eType);

    public <K, V> Map<K, V> readToMap(String json, Class<K> keyClass, Class<V> valClass);

    public <K, V> Map<K, V> readToMap(String json, Type keyType, Type valType);

    public <K, V> Map<K, V> readToMap(byte[] bytes, Class<K> keyClass, Class<V> valClass);

    public <K, V> Map<K, V> readToMap(byte[] bytes, Type keyType, Type valType);
}
