/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) EnumAsValueType.java 2014-09-28 15:29
 */

package com.nonobank.data.jdbc.types;

import com.mysema.query.sql.types.AbstractType;
import com.nonobank.common.base.EnumValue;

import javax.annotation.Nullable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

/**
 * QueryDSL 的枚举类型与数字类型的转换实现。
 *
 * @author Fuchun
 * @since 2.0
 * @version $Id: EnumValueType.java 118 2014-10-13 02:53:35Z fuchun $
 */
public class EnumValueType<E extends EnumValue<V>, V> extends AbstractType<E> {

    public static <E extends EnumValue<V>, V> EnumValueType<E, V>
            forString(Class<E> enumClass) {
        return new EnumValueType<>(Types.VARCHAR, enumClass);
    }

    final Class<E> enumClass;
    final E[] enums;

    /**
     * 默认使用{@code SMALLINT} 作为原始值的枚举。
     *
     * @param enumClass 枚举类型。
     */
    public EnumValueType(Class<E> enumClass) {
        this(Types.SMALLINT, enumClass);
    }

    /**
     * 指定{@code SQL type} 作为原始值的枚举类型。
     *
     * @param type SQL type.
     * @param enumClass 枚举类型。
     */
    public EnumValueType(int type, Class<E> enumClass) {
        super(type);
        this.enumClass = enumClass;
        this.enums = this.enumClass.getEnumConstants();
    }

    @Override
    public Class<E> getReturnedClass() {
        return enumClass;
    }

    @Nullable
    @Override
    public E getValue(ResultSet rs, int i) throws SQLException {
        int type = getSQLTypes()[0];
        Object v = rs.getObject(i);
        if (v == null) {
            return null;
        }
        // 只支持 数字和字符串
        switch (type) {
            case Types.TINYINT:
            case Types.SMALLINT:
            case Types.INTEGER:
                int value = rs.getInt(i);
                for (E e : enums) {
                    if (((Number) e.getValue()).intValue() == value) {
                        return e;
                    }
                }
                break;
            case Types.VARCHAR:
                String strVal = rs.getString(i);
                for (E e : enums) {
                    if (Objects.equals(e.getValue(), strVal)) {
                        return e;
                    }
                }
                break;
            default:
                throw new SQLException("Not support other type unless tinyint, smallint, int and varchar.");
        }
        return null;
    }

    @Override
    public void setValue(PreparedStatement st, int i, E value) throws SQLException {
        int type = getSQLTypes()[0];
        if (value == null) {
            st.setNull(i, type);
        } else {
            Class<?> vClass = value.getValue().getClass();
            if (Short.class.equals(vClass)) {
                st.setShort(i, ((Short) value.getValue()));
            } else if (Byte.class.equals(vClass)) {
                st.setByte(i, ((Byte) value.getValue()));
            } else if (Integer.class.equals(vClass)) {
                st.setInt(i, ((Integer) value.getValue()));
            } else if (Number.class.equals(vClass)) {
                st.setObject(i, ((Number) value.getValue()).intValue());
            }
            st.setObject(i, value.getValue());
        }
    }
}
