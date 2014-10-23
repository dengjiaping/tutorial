/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) SocialSource.java 2014-10-11 13:51
 */

package com.nonobank.user.domain.core;

/**
 * 第三方社交平台帐号来源枚举。
 *
 * @author fuchun
 * @version $Id$
 * @since 2.0
 */
public enum SocialSource {

    /**
     * QQ开放平台。
     */
    QQ,

    /**
     * 新浪微博开放平台。
     */
    WEIBO,

    /**
     * 支付宝开放平台。
     */
    ALIPAY;

    public static SocialSource of(String source) {
        if (source == null || source.length() == 0) {
            return null;
        }
        final String actualSrc = source.toUpperCase();
        for (SocialSource src : values()) {
            if (src.name().equals(actualSrc)) {
                return src;
            }
        }
        return null;
    }
}
