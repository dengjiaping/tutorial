/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) EnumValuePropertyEditor.java 2014-10-27 16:47
 */

package com.nonobank.common.base.propertyeditors;

import com.google.common.primitives.Ints;
import com.nonobank.common.base.EnumValue;

import java.beans.PropertyEditorSupport;
import java.util.Objects;

import static com.google.common.base.CharMatcher.JAVA_DIGIT;

/**
 * @author fuchun
 * @version $Id: EnumValuePropertyEditor.java 290 2014-10-27 08:48:18Z fuchun $
 * @since 2.0
 */
public class EnumValuePropertyEditor<T extends Enum<T>> extends PropertyEditorSupport {

    private final Class<T> enumClass;

    /**
     * Constructs a <code>EnumValuePropertyEditor</code> object.
     */
    public EnumValuePropertyEditor(Class<T> enumClass) {
        Objects.requireNonNull(enumClass, "The given enum class must be not null!");
        this.enumClass = enumClass;
    }

    /**
     * Set (or change) the object that is to be edited.
     *
     * @param value The new target object to be edited.  Note that this
     *              object should not be modified by the PropertyEditor, rather
     *              the PropertyEditor should create a new object to hold any
     *              modified value.
     */
    @Override
    public void setValue(Object value) {
        if (value instanceof Number) {
            Integer v = ((Number) value).intValue();
            for (T e : enumClass.getEnumConstants()) {
                if (e instanceof EnumValue) {
                    @SuppressWarnings("unchecked")
                    EnumValue<? extends Number> ev = (EnumValue<? extends Number>) e;
                    if (v == ev.getValue().intValue()) {
                        super.setValue(e);
                        break;
                    }
                } else {
                    if (e.ordinal() == v) {
                        super.setValue(e);
                        break;
                    }
                }
            }
        } else {
            super.setValue(value);
        }
    }

    /**
     * Sets the property value by parsing a given String.  May raise
     * java.lang.IllegalArgumentException if either the String is
     * badly formatted or if this kind of property can't be expressed
     * as text.
     *
     * @param text The string to be parsed.
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String input;
        if (text == null || (input = text.trim()).length() == 0) {
            setValue(null);
        } else if (JAVA_DIGIT.matchesAllOf(input)) {
            Integer v = Ints.tryParse(input);
            if (v == null) {
                throw new IllegalArgumentException(
                        "The given string(" + input + ") cannot convert to int.");
            }
            try {
                T[] enums = enumClass.getEnumConstants();

                for (T e : enums) {
                    if (e instanceof EnumValue) {
                        @SuppressWarnings("unchecked")
                        EnumValue<? extends Number> ev = (EnumValue<? extends Number>) e;
                        if (v == ev.getValue().intValue()) {
                            super.setValue(e);
                            break;
                        }
                    } else {
                        if (e.ordinal() == v) {
                            super.setValue(e);
                            break;
                        }
                    }
                }
            } catch (Exception ex) {
                throw new IllegalArgumentException(
                        "The given value(" + v + " cannot convert to " + enumClass);
            }
        } else {
            try {
                setValue(Enum.valueOf(enumClass, input));
            } catch (IllegalArgumentException | NullPointerException ex) {
                setValue(null);
            }
        }
    }

    /**
     * Gets the property value as a string suitable for presentation
     * to a human to edit.
     *
     * @return The property value as a string suitable for presentation
     * to a human to edit.
     * <p>   Returns null if the value can't be expressed as a string.
     * <p>   If a non-null value is returned, then the PropertyEditor should
     * be prepared to parse that string back in setAsText().
     */
    @Override
    public String getAsText() {
        @SuppressWarnings("unchecked")
        T e = (T) getValue();
        if (e != null) {
            if (e instanceof EnumValue) {
                return String.valueOf(((EnumValue) e).getValue());
            } else {
                return e.name();
            }
        }
        return null;
    }
}
