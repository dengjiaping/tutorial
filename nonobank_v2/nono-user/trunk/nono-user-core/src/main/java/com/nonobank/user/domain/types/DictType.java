/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) DictType.java 2014-10-11 09:12
 */

package com.nonobank.user.domain.types;

import com.mysema.query.sql.types.AbstractType;
import com.nonobank.user.domain.ctx.DictCmdContext;
import com.nonobank.user.domain.dict.Dict;

import javax.annotation.Nullable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 数据库中的字典数据的{@code code} 和对像的映射转换。
 *
 * @author fuchun
 * @version $Id$
 * @since 2.0
 */
public class DictType extends AbstractType<Dict> {

    private final String typeKey;

    public DictType(String typeKey) {
        this(Types.VARCHAR, typeKey);
    }

    public DictType(int type, String typeKey) {
        super(type);
        this.typeKey = typeKey;
    }

    @Override
    public Class<Dict> getReturnedClass() {
        return Dict.class;
    }

    @Nullable
    @Override
    public Dict getValue(ResultSet rs, int startIndex) throws SQLException {
        String value = rs.getString(startIndex);
        if (value == null || (value = value.trim()).length() == 0) {
            return null;
        }
        return DictCmdContext.commonDictRepository()
                .findByTypeKeyAndCode(typeKey, value);
    }

    @Override
    public void setValue(PreparedStatement st, int startIndex, Dict value) throws SQLException {
        if (value == null) {
            st.setNull(startIndex, Types.VARCHAR);
        } else {
            st.setString(startIndex, value.getCode());
        }
    }
}
