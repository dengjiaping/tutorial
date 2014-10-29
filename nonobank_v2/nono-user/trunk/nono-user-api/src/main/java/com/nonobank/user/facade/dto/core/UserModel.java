/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserModel.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.core;

import java.io.Serializable;

/**
 * 用户帐号注册模型。
 *
 * @author fuchun
 * @version $Id: UserModel.java 298 2014-10-29 03:05:00Z fuchun $
 * @since 2.0
 */
public class UserModel implements Serializable {

    public static final String PROP_TOKEN = "token";
    public static final String PROP_USER_NAME = "userName";
    public static final String PROP_MOBILE_NO = "mobileNo";
    public static final String PROP_MOBILE_CAPTCHA = "mobileCaptcha";
    public static final String PROP_PASSWORD1 = "password1";
    public static final String PROP_PASSWORD2 = "password2";

    private static final long serialVersionUID = -7869399240000792511L;

    /** 特殊值（FORM表单的校验码） */
    private String s_token;
    private String userName;
    private String mobileNo;
    private String mobileCaptcha;
    private String password1;
    private String password2;

    private Short identity;

    public UserModel() {
        super();
    }

    public String getS_token() {
        return s_token;
    }

    public void setS_token(String s_token) {
        this.s_token = s_token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMobileCaptcha() {
        return mobileCaptcha;
    }

    public void setMobileCaptcha(String mobileCaptcha) {
        this.mobileCaptcha = mobileCaptcha;
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

    public Short getIdentity() {
        return identity;
    }

    public void setIdentity(Short identity) {
        this.identity = identity;
    }
}
