/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserEducationRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.QueryDslRepository;
import com.nonobank.user.domain.ext.QUserEducation;
import com.nonobank.user.domain.ext.UserEducation;
import org.springframework.data.domain.Sort;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

import static com.nonobank.data.domain.Entity.PROP_USER_ID;

/**
 * 用户教育经历查询接口
 *
 * @author Yichuan
 * @version $Id: UserEducationRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface UserEducationRepository extends QueryDslRepository<UserEducation, Long> {

    @Nonnull
    public default List<UserEducation> findByUserId(Long userId) {
        Objects.requireNonNull(userId, PROP_USER_ID);
        return findAll(QUserEducation.que.userId.eq(userId));
    }

    @Nonnull
    public List<UserEducation> findByUserId(Long userId, @Nullable Sort sort);
}
