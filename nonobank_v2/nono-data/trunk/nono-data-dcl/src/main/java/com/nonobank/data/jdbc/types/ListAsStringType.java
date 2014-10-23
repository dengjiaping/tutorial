/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) ListAsStringType.java 2014-09-29 08:56
 */

package com.nonobank.data.jdbc.types;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import com.mysema.query.sql.types.AbstractType;

import javax.annotation.Nullable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * QueryDSL List&lt;String&gt; 与{@code String} 类型转换器。
 *
 * @author fuchun
 * @version $Id: ListAsStringType.java 42 2014-09-29 08:27:16Z fuchun $
 * @since 2.0
 */
public class ListAsStringType<T> extends AbstractType<List<T>> {

    private static final String DEFAULT_SEPARATOR = ",";

    private final Function<String, T> toObj;
    private final String separator;

    public ListAsStringType(Function<String, T> toObj) {
        this(toObj, DEFAULT_SEPARATOR);
    }

    public ListAsStringType(Function<String, T> toObj, String separator) {
        super(Types.VARCHAR);
        this.toObj = toObj;
        this.separator = separator;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<List<T>> getReturnedClass() {
        return (Class<List<T>>) new TypeToken<List<T>>() {}.getRawType();
    }

    @Nullable
    @Override
    public List<T> getValue(ResultSet rs, int startIndex) throws SQLException {
        String str = rs.getString(startIndex);
        if (str == null || (str = str.trim()).length() == 0) {
            return null;
        }
        List<String> strList = Splitter.on(separator).trimResults(CharMatcher.WHITESPACE)
                .omitEmptyStrings().splitToList(str);
        return  Lists.transform(strList, toObj);
    }

    @Override
    public void setValue(PreparedStatement st, int startIndex, List<T> value) throws SQLException {
        if (value == null || value.isEmpty()) {
            st.setNull(startIndex, Types.VARCHAR);
        } else {
            String str = Joiner.on(separator).skipNulls()
                    .join(value);
            st.setString(startIndex, str);
        }
    }
}
