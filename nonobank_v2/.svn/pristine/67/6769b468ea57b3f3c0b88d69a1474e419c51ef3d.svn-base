/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserClient.java 2014-10-13 11:12
 */

package com.nonobank.user.domain.authc;

import com.google.common.base.MoreObjects;
import com.nonobank.common.base.EnumValue;

/**
 * 用户设备枚举。
 *
 * @author fuchun
 * @version $Id$
 * @since 2.0
 */
public enum UserDevice implements EnumValue<String> {

    /**
     * 安卓客户端。
     */
    ANDROID(1, "安卓客户端", "device.android", "ANDROID"),

    /**
     * iPhone 客户端。
     */
    IPHONE(2, "iPhone客户端", "device.iPhone", "IPHONE"),

    /**
     * iPad 客户端。
     */
    IPAD(3, "iPad客户端", "device.iPad", "IPAD"),

    /**
     * Windows phone 客户端。
     */
    WINDOWS_PHONE(4, "windows phone客户端", "device.windows_phone", "WP"),

    /**
     * 浏览器客户端（包含移动浏览器）。
     */
    BROWSER(5, "浏览器", "device.browser", "BROWSER"),

    /**
     * 其他客户端。
     */
    OTHER(6, "其他", "device.other", "OTHER");

    final short code;
    final String name;
    final String i18nKey;
    final String alias;

    private UserDevice(int code, String name, String i18nKey, String alias) {
        this.code = (short)code;
        this.name = name;
        this.i18nKey = i18nKey;
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public String getI18nKey() {
        return i18nKey;
    }

    public short getCode() {
        return code;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", getCode())
                .add("name", getName())
                .add("i18nKey", getI18nKey())
                .add("alias", getAlias()).toString();
    }

    @Override
    public String getValue() {
        return alias;
    }
}
