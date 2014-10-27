/*
 * Copyright (c) 2009-2014. 上海诺诺镑客 All rights reserved.
 * @(#) JdbcUserStudentRepository.java 2014-10-27 16:41
 */

package com.nonobank.user.base.jdbc.ext;

import com.nonobank.data.repository.support.QueryDslJdbcRepository;
import com.nonobank.user.domain.ext.UserStudent;
import com.nonobank.user.domain.repository.ext.UserStudentRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;

import java.util.Objects;

import static com.nonobank.user.domain.ext.QUserStudent.qust;
import static com.nonobank.user.domain.ext.UserStudent.PROP_ATTN_YEAR;
import static com.nonobank.user.domain.ext.UserStudent.PROP_COLLEGE_ID;

/**
 * The JDBC based on implementation of the {@code UserStudentRepository}.
 *
 * @author fuchun
 * @version $Id: JdbcUserStudentRepository.java 289 2014-10-27 08:46:50Z fuchun $
 * @since 2.0
 */
@Repository("userStudentRepository")
public class JdbcUserStudentRepository extends QueryDslJdbcRepository<UserStudent, Long>
        implements UserStudentRepository {

    public JdbcUserStudentRepository() {
        super(qust);
    }

    @Nonnull
    @Override
    public Long countByCollegeId(Integer collegeId) {
        Objects.requireNonNull(collegeId, PROP_COLLEGE_ID);
        if (collegeId <= 0) {
            return 0L;
        }
        return count(qust.collegeId.eq(collegeId));
    }

    @Nonnull
    @Override
    public Long countByAttnYear(Integer attnYear) {
        Objects.requireNonNull(attnYear, PROP_ATTN_YEAR);
        if (attnYear <= 1949) {
            return 0L;
        }
        return count(qust.attnYear.eq(attnYear));
    }
}
