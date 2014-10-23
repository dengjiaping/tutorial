/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) TUserStatusType.java 2014-09-29 12:38
 */

package com.nonobank.data.jdbc.types;

import com.nonobank.data.domain.TUserStatus;

/**
 * @author fuchun
 * @version $Id: TUserStatusType.java 117 2014-10-13 02:50:58Z fuchun $
 * @since 2.0
 */
public class TUserStatusType extends EnumValueType<TUserStatus, Short> {

    public TUserStatusType() {
        super(TUserStatus.class);
    }
}
