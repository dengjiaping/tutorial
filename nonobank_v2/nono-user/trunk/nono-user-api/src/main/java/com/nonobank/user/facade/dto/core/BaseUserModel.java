/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) BaseUserModel.java 2014-10-30 09:59
 */

package com.nonobank.user.facade.dto.core;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * 用户注册基本模型。
 *
 * @author fuchun
 * @version $Id: BaseUserModel.java 306 2014-10-30 02:54:16Z fuchun $
 * @since 2.0
 */
public abstract class BaseUserModel implements Serializable {

    public static final String PROP_TOKEN = "s_token";
    public static final String PROP_CHANNEL = "channel";
    public static final String PROP_USER_NAME = "userName";
    public static final String PROP_MOBILE_NO = "mobileNo";
    public static final String PROP_SMS_CAPTCHA = "smsCaptcha";
    public static final String PROP_PASSWORD1 = "password1";
    public static final String PROP_PASSWORD2 = "password2";
    public static final String PROP_IDENTITY = "identity";

    private static final String[] PROPERTIES = {
            PROP_TOKEN, PROP_CHANNEL, PROP_USER_NAME, PROP_MOBILE_NO,
            PROP_SMS_CAPTCHA, PROP_PASSWORD1, PROP_PASSWORD2, PROP_IDENTITY
    };

    private static final long serialVersionUID = 1L;

    protected static String[] properties() {
        return PROPERTIES;
    }

    private String s_token;
    private String channel;
    private String userName;
    private String mobileNO;
    private String smsCaptcha;
    private Short identity;

    private String password1;
    private String password2;

    protected BaseUserModel() {
        super();
    }

    /**
     * 特殊值（FORM表单的校验码）
     */
    public String getS_token() {
        return s_token;
    }

    public void setS_token(String s_token) {
        this.s_token = s_token;
    }

    /**
     * 来源、渠道。例：搜索引擎推广、第三方合作、广告商等。
     */
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNO() {
        return mobileNO;
    }

    public void setMobileNO(String mobileNO) {
        this.mobileNO = mobileNO;
    }

    public String getSmsCaptcha() {
        return smsCaptcha;
    }

    public Short getIdentity() {
        return identity;
    }

    public void setIdentity(Short identity) {
        this.identity = identity;
    }

    public void setSmsCaptcha(String smsCaptcha) {
        this.smsCaptcha = smsCaptcha;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(getClass())
                .add(PROP_TOKEN, getS_token())
                .add(PROP_CHANNEL, getChannel())
                .add(PROP_USER_NAME, getUserName())
                .add(PROP_MOBILE_NO, getMobileNO())
                .add(PROP_SMS_CAPTCHA, getSmsCaptcha())
                .add(PROP_PASSWORD1, getPassword1())
                .add(PROP_PASSWORD2, getPassword2())
                .add(PROP_IDENTITY, getIdentity());
    }
}
