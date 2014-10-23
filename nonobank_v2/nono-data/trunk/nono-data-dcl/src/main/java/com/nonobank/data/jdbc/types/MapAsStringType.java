/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) MapAsStringType.java 2014-09-28 15:35
 */

package com.nonobank.data.jdbc.types;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.reflect.TypeToken;
import com.mysema.query.sql.types.AbstractType;

import javax.annotation.Nullable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import static com.google.common.base.CharMatcher.WHITESPACE;

/**
 * QueryDSL Map&lt;String, String&gt; 与{@code String} 类型转换器。
 * <pre>{@code
 * "k1:v1,k2:v2,k3:v3" &lt;=&gt; {k1=v1, k2=v2, k3=v3}
 * }</pre>
 *
 * @author fuchun
 * @version $Id: MapAsStringType.java 42 2014-09-29 08:27:16Z fuchun $
 * @since 2.0
 */
public class MapAsStringType extends AbstractType<Map<String, String>> {

    private static final String DEFAULT_SEPARATOR = ",";
    private static final String DEFAULT_KEY_VALUE_SEPARATOR = ":";

    private final String separator;
    private final String keyValueSeparator;

    public MapAsStringType() {
        this(DEFAULT_SEPARATOR, DEFAULT_KEY_VALUE_SEPARATOR);
    }

    public MapAsStringType(String separator, String keyValueSeparator) {
        super(Types.VARCHAR);
        this.separator = separator;
        this.keyValueSeparator = keyValueSeparator;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<Map<String, String>> getReturnedClass() {
        return (Class<Map<String, String>>) new TypeToken<Map<String, String>>() {}.getRawType();
    }

    @Nullable
    @Override
    public Map<String, String> getValue(ResultSet rs, int startIndex) throws SQLException {
        String str = rs.getString(startIndex);
        if (str == null || (str = str.trim()).length() == 0) {
            return null;
        }
        return Splitter.on(separator).trimResults(WHITESPACE)
                .omitEmptyStrings().withKeyValueSeparator(keyValueSeparator)
                .split(str);
    }

    @Override
    public void setValue(PreparedStatement st, int startIndex, Map<String, String> value) throws SQLException {
        if (value == null || value.isEmpty()) {
            st.setNull(startIndex, getSQLTypes()[0]);
        } else {
            String str = Joiner.on(separator)
                    .withKeyValueSeparator(keyValueSeparator)
                    .join(value);
            st.setString(startIndex, str);
        }
    }
}