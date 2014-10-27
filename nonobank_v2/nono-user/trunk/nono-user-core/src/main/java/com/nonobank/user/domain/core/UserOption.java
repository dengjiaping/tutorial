/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserOption.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.core;

import com.google.common.base.MoreObjects;
import com.nonobank.common.base.BigValues;
import com.nonobank.data.domain.AbstractEntity;

/**
 * 用户偏好配置选择实体。
 *
 * @author fuchun
 * @version $Id: UserOption.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public class UserOption extends AbstractEntity<Long, UserOption>
        implements BigValues {

    public static final String PROP_KEY = "key";
    public static final String PROP_BIG_VALUE = "bigValue";
    public static final String PROP_BIG = "big";

    private static final long serialVersionUID = 1918868873355677896L;

    public static BoundUserOption boundUserOption(Long userId) {
        return new DefaultBoundUserOption(userId);
    }

    public static UserOption value(
            Long userId, String key, String value) {
        return new UserOption(userId, key, value, null, false);
    }

    public static UserOption bigValue(
            Long userId, String key, String bigValue) {
        return new UserOption(
                userId, key, null, bigValue, true);
    }

    private Long userId;
    private String key;
    private String value;
    private String bigValue;
    private boolean isBig = false;

    public UserOption() {
        super();
    }

    public UserOption(Long userId) {
        super();
        this.userId = userId;
    }

    public UserOption(
            Long userId, String key, String value, String bigValue,
            boolean isBig) {
        super();
        this.userId = userId;
        this.key = key;
        this.value = value;
        this.bigValue = bigValue;
        this.isBig = isBig;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBigValue() {
        return bigValue;
    }

    public void setBigValue(String bigValue) {
        this.bigValue = bigValue;
    }

    public boolean isBig() {
        return isBig;
    }

    public void setBig(boolean isText) {
        this.isBig = isText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserOption)) return false;
        if (!super.equals(o)) return false;

        UserOption that = (UserOption) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (bigValue != null ? !bigValue.equals(that.bigValue) : that.bigValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (bigValue != null ? bigValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(PROP_ID, getId())
                .add(PROP_USER_ID, getUserId())
                .add(PROP_KEY, getKey())
                .add(PROP_VALUE, getValue())
                .add(PROP_BIG_VALUE, getBigValue())
                .toString();
    }
}
