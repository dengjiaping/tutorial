/*
 * Copyright (c) 2009-2014. 上海诺诺谤客 All rights reserved.
 * @(#) EmailVerifySourceRepository.java 2014-10-13 15:15
 */

package com.nonobank.user.domain.repository.message;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.message.EmailVerifySource;
import com.nonobank.user.domain.message.QEmailVerifySource;

import java.util.Objects;

/**
 * 验证类邮件信息查询接口
 *
 * @author Yichuan
 * @version $Id: EmailVerifySourceRepository.java 141 2014-10-13 07:20:48Z yichuan $
 * @since 2.0
 */
public interface EmailVerifySourceRepository extends QueryDslRepository<EmailVerifySource, Long> {

    public default EmailVerifySource findByToken(String token) {
        Objects.requireNonNull(token, EmailVerifySource.PROP_TOKEN);
        return findOne(QEmailVerifySource.qevs.token.eq(token));
    }
}
