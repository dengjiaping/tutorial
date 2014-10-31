/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserModel.java 2014-10-27 16:40
 */

package com.nonobank.user.facade.dto.core;

/**
 * 用户帐号注册模型。
 *
 * @author fuchun
 * @version $Id: UserModel.java 306 2014-10-30 02:54:16Z fuchun $
 * @since 2.0
 */
public class UserModel extends BaseUserModel {

    private static final long serialVersionUID = -6320633121300685097L;

    public UserModel() {
        super();
    }

    @Override
    public String toString() {
        return toStringHelper().toString();
    }
}
