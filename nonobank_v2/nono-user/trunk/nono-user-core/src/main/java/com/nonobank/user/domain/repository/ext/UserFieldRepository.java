/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) UserFieldRepository.java 2014-10-16 15:23
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.QUserField;
import com.nonobank.user.domain.ext.UserField;

import java.util.Objects;

/**
 * 用户属性配置数据查询接口
 *
 * @author Yichuan
 * @version $Id: UserFieldRepository.java 190 2014-10-16 08:17:43Z yichuan $
 * @since 2.0
 */
public interface UserFieldRepository extends QueryDslRepository<UserField, Long> {

    public default UserField findByKwd(String keyword) {
        Objects.requireNonNull(keyword, UserField.PROP_FIELD_KWD);
        return findOne(QUserField.quf.fieldKwd.eq(keyword));
    }
}
