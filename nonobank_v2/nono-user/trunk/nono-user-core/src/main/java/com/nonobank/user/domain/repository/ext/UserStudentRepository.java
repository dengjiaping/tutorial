/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) UserStudentRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.domain.repository.ext;

import com.nonobank.data.repository.GenericRepository;
import com.nonobank.user.domain.ext.UserStudent;

import javax.annotation.Nonnull;

/**
 * {@code UserStudent} entity repository.
 *
 * @author fuchun
 * @version $Id: UserStudentRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
public interface UserStudentRepository extends GenericRepository<UserStudent, Long> {

    /**
     * 统计查询指定学校id的学生用户数。
     *
     * @param collegeId 学校id(not null)。
     * @return 返回指定学校id的学生用户数。
     */
    @Nonnull
    public Long countByCollegeId(Integer collegeId);

    /**
     * 统计查询指定入学年份的学生用户数。
     *
     * @param attnYear 入学年份。
     * @return 返回指定入学年份的学生用户数。
     */
    @Nonnull
    public Long countByAttnYear(Integer attnYear);
}
