/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserID5RecordRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.QUserID5Record;
import com.nonobank.user.domain.ext.UserID5Record;

import java.util.Objects;

import static com.nonobank.user.domain.ext.UserID5Record.*;

/**
 * 国政通(第三方)验证记录数据查询接口
 *
 * @author Yichuan
 * @version $Id: UserID5RecordRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface UserID5RecordRepository extends QueryDslRepository<UserID5Record, Long> {

    public default UserID5Record findByUserId(Long userId) {
        Objects.requireNonNull(userId, PROP_USER_ID);
        return findOne(QUserID5Record.quir.userId.eq(userId));
    }
}
